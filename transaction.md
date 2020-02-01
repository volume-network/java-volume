# Transaction 处理流程

## 请求接收逻辑

1. 接收到http请求
2. 解析内容, 根据接口不同构造不同 Transaction 的 Attachment, Attachment 内有 TransactionType 对象
3. APITransactionManagerImpl.createTransaction
    - 解析请求内容
    - 验证请求数据内容（数值合法性验证）
    - 构造 Transaction 对象
        - transactionProcessor.newTransactionBuilder(...)
        - builder.build()
    - 验证生成的 Transaction
        - transactionService.validate(transaction) 验证失败，抛出异常
    - 如果存在私钥
        - 对交易进行签名
            - transaction.sign(secretPhrase)
        - 再次验证签名后的交易
            - transactionService.validate(transaction)
        - 如果需要广播，广播交易 **真正的Transaction处理起点**
            - transactionProcessor.broadcast(transaction)
    - 返回生成 Transaction 对象JSON对象

## TransactionProcessor.validate 交易验证逻辑

1. 循环验证 Transaction 的 appendix
    - for each transaction.getAppendages as appendage: appendage.validate(transaction)
2. 验证 Transaction 的交易费用
3. 验证 Recipient 用户的公钥，如果区块高度大于挖矿有奖励的区块数，则接收人必须有公钥

> 从验证逻辑看，特定类型的交易的验证逻辑，实现在 Transaction 的 appendix 中
> Attach 中的验证也只是做了数值范围验证，没有做逻辑验证(账户余额是否足够)

## Attachment

## Appendix

## 交易处理 1 TransactionProcessorImpl.broadcast

1. 验证交易的签名，待处理的交易必须是签过名的
    - transaction.verifySignature()
2. 根据交易ID，查询数据库中的交易，如果存在，无需处理
3. 根据交易ID，查询未确认交易缓存，如果存在，无需处理
4. 处理交易
    - processTransactions
5. 如果`4`返回的结果非空列表，广播交易
    - broadcastToPeers(true)

## 交易处理 2 TransactionProcessorImpl.processTransactions

全程加锁 unconfirmedTransactionsSyncObj

循环每个待处理的交易

1. 检查交易的过期时间，过期不处理
2. 开启一个事务
    1. 检查当前区块链高度，高度 < 0, 不处理
    2. 根据交易ID，从 DB 和 未确认缓存中查询交易，如果存在，不处理
        - dbs.getTransactionDb().hasTransaction(transaction.getId())
        - unconfirmedTransactionStore.exists(transaction.getId())
    3. 验证交易签名，验证交易的公钥
        - transaction.verifySignature()
        - transactionService.verifyPublicKey(transaction) **尝试保存/验证 transaction sender的公钥**
    4. 将交易加入未确认交易缓存（未确认交易缓存按照peer分开存放）
        - unconfirmedTransactionStore.put(transaction, peer) **验证发起用户的所有未确认交易余额是否满足账户的额度**

## UnconfirmedTransactionStoreImpl.put

fingerPrintsOverview => `HashMap<Transaction, HashSet<Peer>>`

`put` 方法在调用期间已经处于事务中
全程加锁 internalStore `SortedMap<Long, List<Transaction>>`

internalStore 的key是根据 transaction 的 feeNQT 计算出的
`key = transaction.getFeeNQT() / Constants.FEE_QUANT(735000)`

## TransactionServiceImpl.applyUnconfirmed(transaction, senderAccount)

这是个接受交易的动作