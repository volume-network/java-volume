package vlm.assetexchange;

import vlm.Block;
import vlm.Order;
import vlm.Trade;
import vlm.db.DbIterator;
import vlm.db.DbKey;
import vlm.db.sql.EntitySqlTable;
import vlm.db.store.TradeStore;
import vlm.util.Listener;
import vlm.util.Listeners;

class TradeServiceImpl {

    private final Listeners<Trade, Trade.Event> listeners = new Listeners<>();

    private final TradeStore tradeStore;
    private final EntitySqlTable<Trade> tradeTable;
    private final DbKey.LinkKeyFactory<Trade> tradeDbKeyFactory;


    public TradeServiceImpl(TradeStore tradeStore) {
        this.tradeStore = tradeStore;
        this.tradeTable = tradeStore.getTradeTable();
        this.tradeDbKeyFactory = tradeStore.getTradeDbKeyFactory();
    }

    public DbIterator<Trade> getAssetTrades(long assetId, int from, int to) {
        return tradeStore.getAssetTrades(assetId, from, to);
    }

    public DbIterator<Trade> getAccountAssetTrades(long accountId, long assetId, int from, int to) {
        return tradeStore.getAccountAssetTrades(accountId, assetId, from, to);
    }

    public DbIterator<Trade> getAccountTrades(long id, int from, int to) {
        return tradeStore.getAccountTrades(id, from, to);
    }

    public int getCount() {
        return tradeTable.getCount();
    }

    public int getTradeCount(long assetId) {
        return tradeStore.getTradeCount(assetId);
    }

    public DbIterator<Trade> getAllTrades(int from, int to) {
        return tradeTable.getAll(from, to);
    }

    public boolean addListener(Listener<Trade> listener, Trade.Event eventType) {
        return listeners.addListener(listener, eventType);
    }

    public boolean removeListener(Listener<Trade> listener, Trade.Event eventType) {
        return listeners.removeListener(listener, eventType);
    }

    public Trade addTrade(long assetId, Block block, Order.Ask askOrder, Order.Bid bidOrder) {
        DbKey dbKey = tradeDbKeyFactory.newKey(askOrder.getId(), bidOrder.getId());
        Trade trade = new Trade(dbKey, assetId, block, askOrder, bidOrder);
        tradeTable.insert(trade);
        listeners.notify(trade, Trade.Event.TRADE);
        return trade;
    }
}
