/*
 * This file is generated by jOOQ.
 */
package vlm.schema;


import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;
import vlm.schema.tables.*;

import javax.annotation.Generated;


/**
 * A class modelling indexes of tables of the <code>DB</code> schema.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.10.5"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index ACCOUNT_ACCOUNT_ID_BALANCE_HEIGHT_IDX = Indexes0.ACCOUNT_ACCOUNT_ID_BALANCE_HEIGHT_IDX;
    public static final Index ACCOUNT_ACCOUNT_ID_HEIGHT_IDX = Indexes0.ACCOUNT_ACCOUNT_ID_HEIGHT_IDX;
    public static final Index ACCOUNT_ACCOUNT_ID_LATEST_IDX = Indexes0.ACCOUNT_ACCOUNT_ID_LATEST_IDX;
    public static final Index ACCOUNT_PRIMARY = Indexes0.ACCOUNT_PRIMARY;
    public static final Index ACCOUNT_ASSET_ACCOUNT_ASSET_ID_HEIGHT_IDX = Indexes0.ACCOUNT_ASSET_ACCOUNT_ASSET_ID_HEIGHT_IDX;
    public static final Index ACCOUNT_ASSET_ACCOUNT_ASSET_QUANTITY_IDX = Indexes0.ACCOUNT_ASSET_ACCOUNT_ASSET_QUANTITY_IDX;
    public static final Index ACCOUNT_ASSET_PRIMARY = Indexes0.ACCOUNT_ASSET_PRIMARY;
    public static final Index ALIAS_ALIAS_ACCOUNT_ID_IDX = Indexes0.ALIAS_ALIAS_ACCOUNT_ID_IDX;
    public static final Index ALIAS_ALIAS_ID_HEIGHT_IDX = Indexes0.ALIAS_ALIAS_ID_HEIGHT_IDX;
    public static final Index ALIAS_ALIAS_NAME_LOWER_IDX = Indexes0.ALIAS_ALIAS_NAME_LOWER_IDX;
    public static final Index ALIAS_PRIMARY = Indexes0.ALIAS_PRIMARY;
    public static final Index ALIAS_OFFER_ALIAS_OFFER_ID_HEIGHT_IDX = Indexes0.ALIAS_OFFER_ALIAS_OFFER_ID_HEIGHT_IDX;
    public static final Index ALIAS_OFFER_PRIMARY = Indexes0.ALIAS_OFFER_PRIMARY;
    public static final Index ASK_ORDER_ASK_ORDER_ACCOUNT_ID_IDX = Indexes0.ASK_ORDER_ASK_ORDER_ACCOUNT_ID_IDX;
    public static final Index ASK_ORDER_ASK_ORDER_ASSET_ID_PRICE_IDX = Indexes0.ASK_ORDER_ASK_ORDER_ASSET_ID_PRICE_IDX;
    public static final Index ASK_ORDER_ASK_ORDER_CREATION_IDX = Indexes0.ASK_ORDER_ASK_ORDER_CREATION_IDX;
    public static final Index ASK_ORDER_ASK_ORDER_ID_HEIGHT_IDX = Indexes0.ASK_ORDER_ASK_ORDER_ID_HEIGHT_IDX;
    public static final Index ASK_ORDER_PRIMARY = Indexes0.ASK_ORDER_PRIMARY;
    public static final Index ASSET_ASSET_ACCOUNT_ID_IDX = Indexes0.ASSET_ASSET_ACCOUNT_ID_IDX;
    public static final Index ASSET_ASSET_ID_IDX = Indexes0.ASSET_ASSET_ID_IDX;
    public static final Index ASSET_PRIMARY = Indexes0.ASSET_PRIMARY;
    public static final Index ASSET_TRANSFER_ASSET_TRANSFER_ASSET_ID_IDX = Indexes0.ASSET_TRANSFER_ASSET_TRANSFER_ASSET_ID_IDX;
    public static final Index ASSET_TRANSFER_ASSET_TRANSFER_ID_IDX = Indexes0.ASSET_TRANSFER_ASSET_TRANSFER_ID_IDX;
    public static final Index ASSET_TRANSFER_ASSET_TRANSFER_RECIPIENT_ID_IDX = Indexes0.ASSET_TRANSFER_ASSET_TRANSFER_RECIPIENT_ID_IDX;
    public static final Index ASSET_TRANSFER_ASSET_TRANSFER_SENDER_ID_IDX = Indexes0.ASSET_TRANSFER_ASSET_TRANSFER_SENDER_ID_IDX;
    public static final Index ASSET_TRANSFER_PRIMARY = Indexes0.ASSET_TRANSFER_PRIMARY;
    public static final Index AT_AT_CREATOR_ID_HEIGHT_IDX = Indexes0.AT_AT_CREATOR_ID_HEIGHT_IDX;
    public static final Index AT_AT_ID_HEIGHT_IDX = Indexes0.AT_AT_ID_HEIGHT_IDX;
    public static final Index AT_PRIMARY = Indexes0.AT_PRIMARY;
    public static final Index AT_STATE_AT_STATE_AT_ID_HEIGHT_IDX = Indexes0.AT_STATE_AT_STATE_AT_ID_HEIGHT_IDX;
    public static final Index AT_STATE_AT_STATE_ID_NEXT_HEIGHT_HEIGHT_IDX = Indexes0.AT_STATE_AT_STATE_ID_NEXT_HEIGHT_HEIGHT_IDX;
    public static final Index AT_STATE_PRIMARY = Indexes0.AT_STATE_PRIMARY;
    public static final Index BID_ORDER_BID_ORDER_ACCOUNT_ID_IDX = Indexes0.BID_ORDER_BID_ORDER_ACCOUNT_ID_IDX;
    public static final Index BID_ORDER_BID_ORDER_ASSET_ID_PRICE_IDX = Indexes0.BID_ORDER_BID_ORDER_ASSET_ID_PRICE_IDX;
    public static final Index BID_ORDER_BID_ORDER_CREATION_IDX = Indexes0.BID_ORDER_BID_ORDER_CREATION_IDX;
    public static final Index BID_ORDER_BID_ORDER_ID_HEIGHT_IDX = Indexes0.BID_ORDER_BID_ORDER_ID_HEIGHT_IDX;
    public static final Index BID_ORDER_PRIMARY = Indexes0.BID_ORDER_PRIMARY;
    public static final Index BLOCK_BLOCK_GENERATOR_ID_IDX = Indexes0.BLOCK_BLOCK_GENERATOR_ID_IDX;
    public static final Index BLOCK_BLOCK_HEIGHT_IDX = Indexes0.BLOCK_BLOCK_HEIGHT_IDX;
    public static final Index BLOCK_BLOCK_ID_IDX = Indexes0.BLOCK_BLOCK_ID_IDX;
    public static final Index BLOCK_BLOCK_POOL_ID_IDX = Indexes0.BLOCK_BLOCK_POOL_ID_IDX;
    public static final Index BLOCK_BLOCK_TIMESTAMP_IDX = Indexes0.BLOCK_BLOCK_TIMESTAMP_IDX;
    public static final Index BLOCK_CONSTRAINT_3C = Indexes0.BLOCK_CONSTRAINT_3C;
    public static final Index BLOCK_CONSTRAINT_3C5 = Indexes0.BLOCK_CONSTRAINT_3C5;
    public static final Index BLOCK_PRIMARY = Indexes0.BLOCK_PRIMARY;
    public static final Index ESCROW_ESCROW_DEADLINE_HEIGHT_IDX = Indexes0.ESCROW_ESCROW_DEADLINE_HEIGHT_IDX;
    public static final Index ESCROW_ESCROW_ID_HEIGHT_IDX = Indexes0.ESCROW_ESCROW_ID_HEIGHT_IDX;
    public static final Index ESCROW_ESCROW_RECIPIENT_ID_HEIGHT_IDX = Indexes0.ESCROW_ESCROW_RECIPIENT_ID_HEIGHT_IDX;
    public static final Index ESCROW_ESCROW_SENDER_ID_HEIGHT_IDX = Indexes0.ESCROW_ESCROW_SENDER_ID_HEIGHT_IDX;
    public static final Index ESCROW_PRIMARY = Indexes0.ESCROW_PRIMARY;
    public static final Index ESCROW_DECISION_ESCROW_DECISION_ACCOUNT_ID_HEIGHT_IDX = Indexes0.ESCROW_DECISION_ESCROW_DECISION_ACCOUNT_ID_HEIGHT_IDX;
    public static final Index ESCROW_DECISION_ESCROW_DECISION_ESCROW_ID_ACCOUNT_ID_HEIGHT_IDX = Indexes0.ESCROW_DECISION_ESCROW_DECISION_ESCROW_ID_ACCOUNT_ID_HEIGHT_IDX;
    public static final Index ESCROW_DECISION_ESCROW_DECISION_ESCROW_ID_HEIGHT_IDX = Indexes0.ESCROW_DECISION_ESCROW_DECISION_ESCROW_ID_HEIGHT_IDX;
    public static final Index ESCROW_DECISION_PRIMARY = Indexes0.ESCROW_DECISION_PRIMARY;
    public static final Index GLOBAL_PARAMETER_IDX_GLOBAL_NAME = Indexes0.GLOBAL_PARAMETER_IDX_GLOBAL_NAME;
    public static final Index GLOBAL_PARAMETER_PRIMARY = Indexes0.GLOBAL_PARAMETER_PRIMARY;
    public static final Index GLOBAL_PARAMETER_UNIQ_ID_HEIGHT = Indexes0.GLOBAL_PARAMETER_UNIQ_ID_HEIGHT;
    public static final Index GOODS_GOODS_ID_HEIGHT_IDX = Indexes0.GOODS_GOODS_ID_HEIGHT_IDX;
    public static final Index GOODS_GOODS_SELLER_ID_NAME_IDX = Indexes0.GOODS_GOODS_SELLER_ID_NAME_IDX;
    public static final Index GOODS_GOODS_TIMESTAMP_IDX = Indexes0.GOODS_GOODS_TIMESTAMP_IDX;
    public static final Index GOODS_PRIMARY = Indexes0.GOODS_PRIMARY;
    public static final Index PEER_PRIMARY = Indexes0.PEER_PRIMARY;
    public static final Index PLEDGES_IDX_RECIPER_HEIGHT = Indexes0.PLEDGES_IDX_RECIPER_HEIGHT;
    public static final Index PLEDGES_IDX_SENDER_HEIGHT = Indexes0.PLEDGES_IDX_SENDER_HEIGHT;
    public static final Index PLEDGES_PRIMARY = Indexes0.PLEDGES_PRIMARY;
    public static final Index PLEDGES_UNIQUE_ID_HEIGHT = Indexes0.PLEDGES_UNIQUE_ID_HEIGHT;
    public static final Index POOL_MINER_IDX_POOL_LIST = Indexes0.POOL_MINER_IDX_POOL_LIST;
    public static final Index POOL_MINER_IDX_POOL_QUERY = Indexes0.POOL_MINER_IDX_POOL_QUERY;
    public static final Index POOL_MINER_PRIMARY = Indexes0.POOL_MINER_PRIMARY;
    public static final Index PURCHASE_PRIMARY = Indexes0.PURCHASE_PRIMARY;
    public static final Index PURCHASE_PURCHASE_BUYER_ID_HEIGHT_IDX = Indexes0.PURCHASE_PURCHASE_BUYER_ID_HEIGHT_IDX;
    public static final Index PURCHASE_PURCHASE_DEADLINE_IDX = Indexes0.PURCHASE_PURCHASE_DEADLINE_IDX;
    public static final Index PURCHASE_PURCHASE_ID_HEIGHT_IDX = Indexes0.PURCHASE_PURCHASE_ID_HEIGHT_IDX;
    public static final Index PURCHASE_PURCHASE_SELLER_ID_HEIGHT_IDX = Indexes0.PURCHASE_PURCHASE_SELLER_ID_HEIGHT_IDX;
    public static final Index PURCHASE_PURCHASE_TIMESTAMP_IDX = Indexes0.PURCHASE_PURCHASE_TIMESTAMP_IDX;
    public static final Index PURCHASE_FEEDBACK_PRIMARY = Indexes0.PURCHASE_FEEDBACK_PRIMARY;
    public static final Index PURCHASE_FEEDBACK_PURCHASE_FEEDBACK_ID_HEIGHT_IDX = Indexes0.PURCHASE_FEEDBACK_PURCHASE_FEEDBACK_ID_HEIGHT_IDX;
    public static final Index PURCHASE_PUBLIC_FEEDBACK_PRIMARY = Indexes0.PURCHASE_PUBLIC_FEEDBACK_PRIMARY;
    public static final Index PURCHASE_PUBLIC_FEEDBACK_PURCHASE_PUBLIC_FEEDBACK_ID_HEIGHT_IDX = Indexes0.PURCHASE_PUBLIC_FEEDBACK_PURCHASE_PUBLIC_FEEDBACK_ID_HEIGHT_IDX;
    public static final Index REWARD_RECIP_ASSIGN_PRIMARY = Indexes0.REWARD_RECIP_ASSIGN_PRIMARY;
    public static final Index REWARD_RECIP_ASSIGN_REWARD_RECIP_ASSIGN_ACCOUNT_ID_HEIGHT_IDX = Indexes0.REWARD_RECIP_ASSIGN_REWARD_RECIP_ASSIGN_ACCOUNT_ID_HEIGHT_IDX;
    public static final Index REWARD_RECIP_ASSIGN_REWARD_RECIP_ASSIGN_RECIP_ID_HEIGHT_IDX = Indexes0.REWARD_RECIP_ASSIGN_REWARD_RECIP_ASSIGN_RECIP_ID_HEIGHT_IDX;
    public static final Index SUBSCRIPTION_PRIMARY = Indexes0.SUBSCRIPTION_PRIMARY;
    public static final Index SUBSCRIPTION_SUBSCRIPTION_ID_HEIGHT_IDX = Indexes0.SUBSCRIPTION_SUBSCRIPTION_ID_HEIGHT_IDX;
    public static final Index SUBSCRIPTION_SUBSCRIPTION_RECIPIENT_ID_HEIGHT_IDX = Indexes0.SUBSCRIPTION_SUBSCRIPTION_RECIPIENT_ID_HEIGHT_IDX;
    public static final Index SUBSCRIPTION_SUBSCRIPTION_SENDER_ID_HEIGHT_IDX = Indexes0.SUBSCRIPTION_SUBSCRIPTION_SENDER_ID_HEIGHT_IDX;
    public static final Index TRADE_PRIMARY = Indexes0.TRADE_PRIMARY;
    public static final Index TRADE_TRADE_ASK_BID_IDX = Indexes0.TRADE_TRADE_ASK_BID_IDX;
    public static final Index TRADE_TRADE_ASSET_ID_IDX = Indexes0.TRADE_TRADE_ASSET_ID_IDX;
    public static final Index TRADE_TRADE_BUYER_ID_IDX = Indexes0.TRADE_TRADE_BUYER_ID_IDX;
    public static final Index TRADE_TRADE_SELLER_ID_IDX = Indexes0.TRADE_TRADE_SELLER_ID_IDX;
    public static final Index TRANSACTION_CONSTRAINT_FF = Indexes0.TRANSACTION_CONSTRAINT_FF;
    public static final Index TRANSACTION_PRIMARY = Indexes0.TRANSACTION_PRIMARY;
    public static final Index TRANSACTION_TRANSACTION_BLOCK_TIMESTAMP_IDX = Indexes0.TRANSACTION_TRANSACTION_BLOCK_TIMESTAMP_IDX;
    public static final Index TRANSACTION_TRANSACTION_FULL_HASH_IDX = Indexes0.TRANSACTION_TRANSACTION_FULL_HASH_IDX;
    public static final Index TRANSACTION_TRANSACTION_ID_IDX = Indexes0.TRANSACTION_TRANSACTION_ID_IDX;
    public static final Index TRANSACTION_TRANSACTION_RECIPIENT_ID_AMOUNT_HEIGHT_IDX = Indexes0.TRANSACTION_TRANSACTION_RECIPIENT_ID_AMOUNT_HEIGHT_IDX;
    public static final Index TRANSACTION_TRANSACTION_RECIPIENT_ID_IDX = Indexes0.TRANSACTION_TRANSACTION_RECIPIENT_ID_IDX;
    public static final Index TRANSACTION_TRANSACTION_SENDER_ID_IDX = Indexes0.TRANSACTION_TRANSACTION_SENDER_ID_IDX;
    public static final Index UNCONFIRMED_TRANSACTION_PRIMARY = Indexes0.UNCONFIRMED_TRANSACTION_PRIMARY;
    public static final Index UNCONFIRMED_TRANSACTION_UNCONFIRMED_TRANSACTION_HEIGHT_FEE_TIMESTAMP_IDX = Indexes0.UNCONFIRMED_TRANSACTION_UNCONFIRMED_TRANSACTION_HEIGHT_FEE_TIMESTAMP_IDX;
    public static final Index UNCONFIRMED_TRANSACTION_UNCONFIRMED_TRANSACTION_ID_IDX = Indexes0.UNCONFIRMED_TRANSACTION_UNCONFIRMED_TRANSACTION_ID_IDX;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index ACCOUNT_ACCOUNT_ID_BALANCE_HEIGHT_IDX = Internal.createIndex("account_id_balance_height_idx", Account.ACCOUNT, new OrderField[]{Account.ACCOUNT.ID, Account.ACCOUNT.BALANCE, Account.ACCOUNT.HEIGHT}, false);
        public static Index ACCOUNT_ACCOUNT_ID_HEIGHT_IDX = Internal.createIndex("account_id_height_idx", Account.ACCOUNT, new OrderField[]{Account.ACCOUNT.ID, Account.ACCOUNT.HEIGHT}, true);
        public static Index ACCOUNT_ACCOUNT_ID_LATEST_IDX = Internal.createIndex("account_id_latest_idx", Account.ACCOUNT, new OrderField[]{Account.ACCOUNT.ID, Account.ACCOUNT.LATEST}, false);
        public static Index ACCOUNT_PRIMARY = Internal.createIndex("PRIMARY", Account.ACCOUNT, new OrderField[]{Account.ACCOUNT.DB_ID}, true);
        public static Index ACCOUNT_ASSET_ACCOUNT_ASSET_ID_HEIGHT_IDX = Internal.createIndex("account_asset_id_height_idx", AccountAsset.ACCOUNT_ASSET, new OrderField[]{AccountAsset.ACCOUNT_ASSET.ACCOUNT_ID, AccountAsset.ACCOUNT_ASSET.ASSET_ID, AccountAsset.ACCOUNT_ASSET.HEIGHT}, true);
        public static Index ACCOUNT_ASSET_ACCOUNT_ASSET_QUANTITY_IDX = Internal.createIndex("account_asset_quantity_idx", AccountAsset.ACCOUNT_ASSET, new OrderField[]{AccountAsset.ACCOUNT_ASSET.QUANTITY}, false);
        public static Index ACCOUNT_ASSET_PRIMARY = Internal.createIndex("PRIMARY", AccountAsset.ACCOUNT_ASSET, new OrderField[]{AccountAsset.ACCOUNT_ASSET.DB_ID}, true);
        public static Index ALIAS_ALIAS_ACCOUNT_ID_IDX = Internal.createIndex("alias_account_id_idx", Alias.ALIAS, new OrderField[]{Alias.ALIAS.ACCOUNT_ID, Alias.ALIAS.HEIGHT}, false);
        public static Index ALIAS_ALIAS_ID_HEIGHT_IDX = Internal.createIndex("alias_id_height_idx", Alias.ALIAS, new OrderField[]{Alias.ALIAS.ID, Alias.ALIAS.HEIGHT}, true);
        public static Index ALIAS_ALIAS_NAME_LOWER_IDX = Internal.createIndex("alias_name_lower_idx", Alias.ALIAS, new OrderField[]{Alias.ALIAS.ALIAS_NAME_LOWER}, false);
        public static Index ALIAS_PRIMARY = Internal.createIndex("PRIMARY", Alias.ALIAS, new OrderField[]{Alias.ALIAS.DB_ID}, true);
        public static Index ALIAS_OFFER_ALIAS_OFFER_ID_HEIGHT_IDX = Internal.createIndex("alias_offer_id_height_idx", AliasOffer.ALIAS_OFFER, new OrderField[]{AliasOffer.ALIAS_OFFER.ID, AliasOffer.ALIAS_OFFER.HEIGHT}, true);
        public static Index ALIAS_OFFER_PRIMARY = Internal.createIndex("PRIMARY", AliasOffer.ALIAS_OFFER, new OrderField[]{AliasOffer.ALIAS_OFFER.DB_ID}, true);
        public static Index ASK_ORDER_ASK_ORDER_ACCOUNT_ID_IDX = Internal.createIndex("ask_order_account_id_idx", AskOrder.ASK_ORDER, new OrderField[]{AskOrder.ASK_ORDER.ACCOUNT_ID, AskOrder.ASK_ORDER.HEIGHT}, false);
        public static Index ASK_ORDER_ASK_ORDER_ASSET_ID_PRICE_IDX = Internal.createIndex("ask_order_asset_id_price_idx", AskOrder.ASK_ORDER, new OrderField[]{AskOrder.ASK_ORDER.ASSET_ID, AskOrder.ASK_ORDER.PRICE}, false);
        public static Index ASK_ORDER_ASK_ORDER_CREATION_IDX = Internal.createIndex("ask_order_creation_idx", AskOrder.ASK_ORDER, new OrderField[]{AskOrder.ASK_ORDER.CREATION_HEIGHT}, false);
        public static Index ASK_ORDER_ASK_ORDER_ID_HEIGHT_IDX = Internal.createIndex("ask_order_id_height_idx", AskOrder.ASK_ORDER, new OrderField[]{AskOrder.ASK_ORDER.ID, AskOrder.ASK_ORDER.HEIGHT}, true);
        public static Index ASK_ORDER_PRIMARY = Internal.createIndex("PRIMARY", AskOrder.ASK_ORDER, new OrderField[]{AskOrder.ASK_ORDER.DB_ID}, true);
        public static Index ASSET_ASSET_ACCOUNT_ID_IDX = Internal.createIndex("asset_account_id_idx", Asset.ASSET, new OrderField[]{Asset.ASSET.ACCOUNT_ID}, false);
        public static Index ASSET_ASSET_ID_IDX = Internal.createIndex("asset_id_idx", Asset.ASSET, new OrderField[]{Asset.ASSET.ID}, true);
        public static Index ASSET_PRIMARY = Internal.createIndex("PRIMARY", Asset.ASSET, new OrderField[]{Asset.ASSET.DB_ID}, true);
        public static Index ASSET_TRANSFER_ASSET_TRANSFER_ASSET_ID_IDX = Internal.createIndex("asset_transfer_asset_id_idx", AssetTransfer.ASSET_TRANSFER, new OrderField[]{AssetTransfer.ASSET_TRANSFER.ASSET_ID, AssetTransfer.ASSET_TRANSFER.HEIGHT}, false);
        public static Index ASSET_TRANSFER_ASSET_TRANSFER_ID_IDX = Internal.createIndex("asset_transfer_id_idx", AssetTransfer.ASSET_TRANSFER, new OrderField[]{AssetTransfer.ASSET_TRANSFER.ID}, true);
        public static Index ASSET_TRANSFER_ASSET_TRANSFER_RECIPIENT_ID_IDX = Internal.createIndex("asset_transfer_recipient_id_idx", AssetTransfer.ASSET_TRANSFER, new OrderField[]{AssetTransfer.ASSET_TRANSFER.RECIPIENT_ID, AssetTransfer.ASSET_TRANSFER.HEIGHT}, false);
        public static Index ASSET_TRANSFER_ASSET_TRANSFER_SENDER_ID_IDX = Internal.createIndex("asset_transfer_sender_id_idx", AssetTransfer.ASSET_TRANSFER, new OrderField[]{AssetTransfer.ASSET_TRANSFER.SENDER_ID, AssetTransfer.ASSET_TRANSFER.HEIGHT}, false);
        public static Index ASSET_TRANSFER_PRIMARY = Internal.createIndex("PRIMARY", AssetTransfer.ASSET_TRANSFER, new OrderField[]{AssetTransfer.ASSET_TRANSFER.DB_ID}, true);
        public static Index AT_AT_CREATOR_ID_HEIGHT_IDX = Internal.createIndex("at_creator_id_height_idx", At.AT, new OrderField[]{At.AT.CREATOR_ID, At.AT.HEIGHT}, false);
        public static Index AT_AT_ID_HEIGHT_IDX = Internal.createIndex("at_id_height_idx", At.AT, new OrderField[]{At.AT.ID, At.AT.HEIGHT}, true);
        public static Index AT_PRIMARY = Internal.createIndex("PRIMARY", At.AT, new OrderField[]{At.AT.DB_ID}, true);
        public static Index AT_STATE_AT_STATE_AT_ID_HEIGHT_IDX = Internal.createIndex("at_state_at_id_height_idx", AtState.AT_STATE, new OrderField[]{AtState.AT_STATE.AT_ID, AtState.AT_STATE.HEIGHT}, true);
        public static Index AT_STATE_AT_STATE_ID_NEXT_HEIGHT_HEIGHT_IDX = Internal.createIndex("at_state_id_next_height_height_idx", AtState.AT_STATE, new OrderField[]{AtState.AT_STATE.AT_ID, AtState.AT_STATE.NEXT_HEIGHT, AtState.AT_STATE.HEIGHT}, false);
        public static Index AT_STATE_PRIMARY = Internal.createIndex("PRIMARY", AtState.AT_STATE, new OrderField[]{AtState.AT_STATE.DB_ID}, true);
        public static Index BID_ORDER_BID_ORDER_ACCOUNT_ID_IDX = Internal.createIndex("bid_order_account_id_idx", BidOrder.BID_ORDER, new OrderField[]{BidOrder.BID_ORDER.ACCOUNT_ID, BidOrder.BID_ORDER.HEIGHT}, false);
        public static Index BID_ORDER_BID_ORDER_ASSET_ID_PRICE_IDX = Internal.createIndex("bid_order_asset_id_price_idx", BidOrder.BID_ORDER, new OrderField[]{BidOrder.BID_ORDER.ASSET_ID, BidOrder.BID_ORDER.PRICE}, false);
        public static Index BID_ORDER_BID_ORDER_CREATION_IDX = Internal.createIndex("bid_order_creation_idx", BidOrder.BID_ORDER, new OrderField[]{BidOrder.BID_ORDER.CREATION_HEIGHT}, false);
        public static Index BID_ORDER_BID_ORDER_ID_HEIGHT_IDX = Internal.createIndex("bid_order_id_height_idx", BidOrder.BID_ORDER, new OrderField[]{BidOrder.BID_ORDER.ID, BidOrder.BID_ORDER.HEIGHT}, true);
        public static Index BID_ORDER_PRIMARY = Internal.createIndex("PRIMARY", BidOrder.BID_ORDER, new OrderField[]{BidOrder.BID_ORDER.DB_ID}, true);
        public static Index BLOCK_BLOCK_GENERATOR_ID_IDX = Internal.createIndex("block_generator_id_idx", Block.BLOCK, new OrderField[]{Block.BLOCK.GENERATOR_ID}, false);
        public static Index BLOCK_BLOCK_HEIGHT_IDX = Internal.createIndex("block_height_idx", Block.BLOCK, new OrderField[]{Block.BLOCK.HEIGHT}, true);
        public static Index BLOCK_BLOCK_ID_IDX = Internal.createIndex("block_id_idx", Block.BLOCK, new OrderField[]{Block.BLOCK.ID}, true);
        public static Index BLOCK_BLOCK_POOL_ID_IDX = Internal.createIndex("block_pool_id_idx", Block.BLOCK, new OrderField[]{Block.BLOCK.POOL_ID}, false);
        public static Index BLOCK_BLOCK_TIMESTAMP_IDX = Internal.createIndex("block_timestamp_idx", Block.BLOCK, new OrderField[]{Block.BLOCK.TIMESTAMP}, true);
        public static Index BLOCK_CONSTRAINT_3C = Internal.createIndex("constraint_3c", Block.BLOCK, new OrderField[]{Block.BLOCK.PREVIOUS_BLOCK_ID}, false);
        public static Index BLOCK_CONSTRAINT_3C5 = Internal.createIndex("constraint_3c5", Block.BLOCK, new OrderField[]{Block.BLOCK.NEXT_BLOCK_ID}, false);
        public static Index BLOCK_PRIMARY = Internal.createIndex("PRIMARY", Block.BLOCK, new OrderField[]{Block.BLOCK.DB_ID}, true);
        public static Index ESCROW_ESCROW_DEADLINE_HEIGHT_IDX = Internal.createIndex("escrow_deadline_height_idx", Escrow.ESCROW, new OrderField[]{Escrow.ESCROW.DEADLINE, Escrow.ESCROW.HEIGHT}, false);
        public static Index ESCROW_ESCROW_ID_HEIGHT_IDX = Internal.createIndex("escrow_id_height_idx", Escrow.ESCROW, new OrderField[]{Escrow.ESCROW.ID, Escrow.ESCROW.HEIGHT}, true);
        public static Index ESCROW_ESCROW_RECIPIENT_ID_HEIGHT_IDX = Internal.createIndex("escrow_recipient_id_height_idx", Escrow.ESCROW, new OrderField[]{Escrow.ESCROW.RECIPIENT_ID, Escrow.ESCROW.HEIGHT}, false);
        public static Index ESCROW_ESCROW_SENDER_ID_HEIGHT_IDX = Internal.createIndex("escrow_sender_id_height_idx", Escrow.ESCROW, new OrderField[]{Escrow.ESCROW.SENDER_ID, Escrow.ESCROW.HEIGHT}, false);
        public static Index ESCROW_PRIMARY = Internal.createIndex("PRIMARY", Escrow.ESCROW, new OrderField[]{Escrow.ESCROW.DB_ID}, true);
        public static Index ESCROW_DECISION_ESCROW_DECISION_ACCOUNT_ID_HEIGHT_IDX = Internal.createIndex("escrow_decision_account_id_height_idx", EscrowDecision.ESCROW_DECISION, new OrderField[]{EscrowDecision.ESCROW_DECISION.ACCOUNT_ID, EscrowDecision.ESCROW_DECISION.HEIGHT}, false);
        public static Index ESCROW_DECISION_ESCROW_DECISION_ESCROW_ID_ACCOUNT_ID_HEIGHT_IDX = Internal.createIndex("escrow_decision_escrow_id_account_id_height_idx", EscrowDecision.ESCROW_DECISION, new OrderField[]{EscrowDecision.ESCROW_DECISION.ESCROW_ID, EscrowDecision.ESCROW_DECISION.ACCOUNT_ID, EscrowDecision.ESCROW_DECISION.HEIGHT}, true);
        public static Index ESCROW_DECISION_ESCROW_DECISION_ESCROW_ID_HEIGHT_IDX = Internal.createIndex("escrow_decision_escrow_id_height_idx", EscrowDecision.ESCROW_DECISION, new OrderField[]{EscrowDecision.ESCROW_DECISION.ESCROW_ID, EscrowDecision.ESCROW_DECISION.HEIGHT}, false);
        public static Index ESCROW_DECISION_PRIMARY = Internal.createIndex("PRIMARY", EscrowDecision.ESCROW_DECISION, new OrderField[]{EscrowDecision.ESCROW_DECISION.DB_ID}, true);
        public static Index GLOBAL_PARAMETER_IDX_GLOBAL_NAME = Internal.createIndex("idx_global_name", GlobalParameter.GLOBAL_PARAMETER, new OrderField[]{GlobalParameter.GLOBAL_PARAMETER.ID}, false);
        public static Index GLOBAL_PARAMETER_PRIMARY = Internal.createIndex("PRIMARY", GlobalParameter.GLOBAL_PARAMETER, new OrderField[]{GlobalParameter.GLOBAL_PARAMETER.DB_ID}, true);
        public static Index GLOBAL_PARAMETER_UNIQ_ID_HEIGHT = Internal.createIndex("uniq_id_height", GlobalParameter.GLOBAL_PARAMETER, new OrderField[]{GlobalParameter.GLOBAL_PARAMETER.ID, GlobalParameter.GLOBAL_PARAMETER.HEIGHT}, true);
        public static Index GOODS_GOODS_ID_HEIGHT_IDX = Internal.createIndex("goods_id_height_idx", Goods.GOODS, new OrderField[]{Goods.GOODS.ID, Goods.GOODS.HEIGHT}, true);
        public static Index GOODS_GOODS_SELLER_ID_NAME_IDX = Internal.createIndex("goods_seller_id_name_idx", Goods.GOODS, new OrderField[]{Goods.GOODS.SELLER_ID, Goods.GOODS.NAME}, false);
        public static Index GOODS_GOODS_TIMESTAMP_IDX = Internal.createIndex("goods_timestamp_idx", Goods.GOODS, new OrderField[]{Goods.GOODS.TIMESTAMP, Goods.GOODS.HEIGHT}, false);
        public static Index GOODS_PRIMARY = Internal.createIndex("PRIMARY", Goods.GOODS, new OrderField[]{Goods.GOODS.DB_ID}, true);
        public static Index PEER_PRIMARY = Internal.createIndex("PRIMARY", Peer.PEER, new OrderField[]{Peer.PEER.ADDRESS}, true);
        public static Index PLEDGES_IDX_RECIPER_HEIGHT = Internal.createIndex("idx_reciper_height", Pledges.PLEDGES, new OrderField[]{Pledges.PLEDGES.RECIP_ID, Pledges.PLEDGES.HEIGHT}, false);
        public static Index PLEDGES_IDX_SENDER_HEIGHT = Internal.createIndex("idx_sender_height", Pledges.PLEDGES, new OrderField[]{Pledges.PLEDGES.ACCOUNT_ID, Pledges.PLEDGES.HEIGHT}, false);
        public static Index PLEDGES_PRIMARY = Internal.createIndex("PRIMARY", Pledges.PLEDGES, new OrderField[]{Pledges.PLEDGES.DB_ID}, true);
        public static Index PLEDGES_UNIQUE_ID_HEIGHT = Internal.createIndex("unique_id_height", Pledges.PLEDGES, new OrderField[]{Pledges.PLEDGES.ID, Pledges.PLEDGES.HEIGHT}, true);
        public static Index POOL_MINER_IDX_POOL_LIST = Internal.createIndex("idx_pool_list", PoolMiner.POOL_MINER, new OrderField[]{PoolMiner.POOL_MINER.POOL_ID, PoolMiner.POOL_MINER.STATUS}, false);
        public static Index POOL_MINER_IDX_POOL_QUERY = Internal.createIndex("idx_pool_query", PoolMiner.POOL_MINER, new OrderField[]{PoolMiner.POOL_MINER.ACCOUNT_ID, PoolMiner.POOL_MINER.POOL_ID, PoolMiner.POOL_MINER.STATUS}, false);
        public static Index POOL_MINER_PRIMARY = Internal.createIndex("PRIMARY", PoolMiner.POOL_MINER, new OrderField[]{PoolMiner.POOL_MINER.DB_ID}, true);
        public static Index PURCHASE_PRIMARY = Internal.createIndex("PRIMARY", Purchase.PURCHASE, new OrderField[]{Purchase.PURCHASE.DB_ID}, true);
        public static Index PURCHASE_PURCHASE_BUYER_ID_HEIGHT_IDX = Internal.createIndex("purchase_buyer_id_height_idx", Purchase.PURCHASE, new OrderField[]{Purchase.PURCHASE.BUYER_ID, Purchase.PURCHASE.HEIGHT}, false);
        public static Index PURCHASE_PURCHASE_DEADLINE_IDX = Internal.createIndex("purchase_deadline_idx", Purchase.PURCHASE, new OrderField[]{Purchase.PURCHASE.DEADLINE, Purchase.PURCHASE.HEIGHT}, false);
        public static Index PURCHASE_PURCHASE_ID_HEIGHT_IDX = Internal.createIndex("purchase_id_height_idx", Purchase.PURCHASE, new OrderField[]{Purchase.PURCHASE.ID, Purchase.PURCHASE.HEIGHT}, true);
        public static Index PURCHASE_PURCHASE_SELLER_ID_HEIGHT_IDX = Internal.createIndex("purchase_seller_id_height_idx", Purchase.PURCHASE, new OrderField[]{Purchase.PURCHASE.SELLER_ID, Purchase.PURCHASE.HEIGHT}, false);
        public static Index PURCHASE_PURCHASE_TIMESTAMP_IDX = Internal.createIndex("purchase_timestamp_idx", Purchase.PURCHASE, new OrderField[]{Purchase.PURCHASE.TIMESTAMP, Purchase.PURCHASE.ID}, false);
        public static Index PURCHASE_FEEDBACK_PRIMARY = Internal.createIndex("PRIMARY", PurchaseFeedback.PURCHASE_FEEDBACK, new OrderField[]{PurchaseFeedback.PURCHASE_FEEDBACK.DB_ID}, true);
        public static Index PURCHASE_FEEDBACK_PURCHASE_FEEDBACK_ID_HEIGHT_IDX = Internal.createIndex("purchase_feedback_id_height_idx", PurchaseFeedback.PURCHASE_FEEDBACK, new OrderField[]{PurchaseFeedback.PURCHASE_FEEDBACK.ID, PurchaseFeedback.PURCHASE_FEEDBACK.HEIGHT}, false);
        public static Index PURCHASE_PUBLIC_FEEDBACK_PRIMARY = Internal.createIndex("PRIMARY", PurchasePublicFeedback.PURCHASE_PUBLIC_FEEDBACK, new OrderField[]{PurchasePublicFeedback.PURCHASE_PUBLIC_FEEDBACK.DB_ID}, true);
        public static Index PURCHASE_PUBLIC_FEEDBACK_PURCHASE_PUBLIC_FEEDBACK_ID_HEIGHT_IDX = Internal.createIndex("purchase_public_feedback_id_height_idx", PurchasePublicFeedback.PURCHASE_PUBLIC_FEEDBACK, new OrderField[]{PurchasePublicFeedback.PURCHASE_PUBLIC_FEEDBACK.ID, PurchasePublicFeedback.PURCHASE_PUBLIC_FEEDBACK.HEIGHT}, false);
        public static Index REWARD_RECIP_ASSIGN_PRIMARY = Internal.createIndex("PRIMARY", RewardRecipAssign.REWARD_RECIP_ASSIGN, new OrderField[]{RewardRecipAssign.REWARD_RECIP_ASSIGN.DB_ID}, true);
        public static Index REWARD_RECIP_ASSIGN_REWARD_RECIP_ASSIGN_ACCOUNT_ID_HEIGHT_IDX = Internal.createIndex("reward_recip_assign_account_id_height_idx", RewardRecipAssign.REWARD_RECIP_ASSIGN, new OrderField[]{RewardRecipAssign.REWARD_RECIP_ASSIGN.ACCOUNT_ID, RewardRecipAssign.REWARD_RECIP_ASSIGN.HEIGHT}, true);
        public static Index REWARD_RECIP_ASSIGN_REWARD_RECIP_ASSIGN_RECIP_ID_HEIGHT_IDX = Internal.createIndex("reward_recip_assign_recip_id_height_idx", RewardRecipAssign.REWARD_RECIP_ASSIGN, new OrderField[]{RewardRecipAssign.REWARD_RECIP_ASSIGN.RECIP_ID, RewardRecipAssign.REWARD_RECIP_ASSIGN.HEIGHT}, false);
        public static Index SUBSCRIPTION_PRIMARY = Internal.createIndex("PRIMARY", Subscription.SUBSCRIPTION, new OrderField[]{Subscription.SUBSCRIPTION.DB_ID}, true);
        public static Index SUBSCRIPTION_SUBSCRIPTION_ID_HEIGHT_IDX = Internal.createIndex("subscription_id_height_idx", Subscription.SUBSCRIPTION, new OrderField[]{Subscription.SUBSCRIPTION.ID, Subscription.SUBSCRIPTION.HEIGHT}, true);
        public static Index SUBSCRIPTION_SUBSCRIPTION_RECIPIENT_ID_HEIGHT_IDX = Internal.createIndex("subscription_recipient_id_height_idx", Subscription.SUBSCRIPTION, new OrderField[]{Subscription.SUBSCRIPTION.RECIPIENT_ID, Subscription.SUBSCRIPTION.HEIGHT}, false);
        public static Index SUBSCRIPTION_SUBSCRIPTION_SENDER_ID_HEIGHT_IDX = Internal.createIndex("subscription_sender_id_height_idx", Subscription.SUBSCRIPTION, new OrderField[]{Subscription.SUBSCRIPTION.SENDER_ID, Subscription.SUBSCRIPTION.HEIGHT}, false);
        public static Index TRADE_PRIMARY = Internal.createIndex("PRIMARY", Trade.TRADE, new OrderField[]{Trade.TRADE.DB_ID}, true);
        public static Index TRADE_TRADE_ASK_BID_IDX = Internal.createIndex("trade_ask_bid_idx", Trade.TRADE, new OrderField[]{Trade.TRADE.ASK_ORDER_ID, Trade.TRADE.BID_ORDER_ID}, true);
        public static Index TRADE_TRADE_ASSET_ID_IDX = Internal.createIndex("trade_asset_id_idx", Trade.TRADE, new OrderField[]{Trade.TRADE.ASSET_ID, Trade.TRADE.HEIGHT}, false);
        public static Index TRADE_TRADE_BUYER_ID_IDX = Internal.createIndex("trade_buyer_id_idx", Trade.TRADE, new OrderField[]{Trade.TRADE.BUYER_ID, Trade.TRADE.HEIGHT}, false);
        public static Index TRADE_TRADE_SELLER_ID_IDX = Internal.createIndex("trade_seller_id_idx", Trade.TRADE, new OrderField[]{Trade.TRADE.SELLER_ID, Trade.TRADE.HEIGHT}, false);
        public static Index TRANSACTION_CONSTRAINT_FF = Internal.createIndex("constraint_ff", Transaction.TRANSACTION, new OrderField[]{Transaction.TRANSACTION.BLOCK_ID}, false);
        public static Index TRANSACTION_PRIMARY = Internal.createIndex("PRIMARY", Transaction.TRANSACTION, new OrderField[]{Transaction.TRANSACTION.DB_ID}, true);
        public static Index TRANSACTION_TRANSACTION_BLOCK_TIMESTAMP_IDX = Internal.createIndex("transaction_block_timestamp_idx", Transaction.TRANSACTION, new OrderField[]{Transaction.TRANSACTION.BLOCK_TIMESTAMP}, false);
        public static Index TRANSACTION_TRANSACTION_FULL_HASH_IDX = Internal.createIndex("transaction_full_hash_idx", Transaction.TRANSACTION, new OrderField[]{Transaction.TRANSACTION.FULL_HASH}, true);
        public static Index TRANSACTION_TRANSACTION_ID_IDX = Internal.createIndex("transaction_id_idx", Transaction.TRANSACTION, new OrderField[]{Transaction.TRANSACTION.ID}, true);
        public static Index TRANSACTION_TRANSACTION_RECIPIENT_ID_AMOUNT_HEIGHT_IDX = Internal.createIndex("transaction_recipient_id_amount_height_idx", Transaction.TRANSACTION, new OrderField[]{Transaction.TRANSACTION.RECIPIENT_ID, Transaction.TRANSACTION.AMOUNT, Transaction.TRANSACTION.HEIGHT}, false);
        public static Index TRANSACTION_TRANSACTION_RECIPIENT_ID_IDX = Internal.createIndex("transaction_recipient_id_idx", Transaction.TRANSACTION, new OrderField[]{Transaction.TRANSACTION.RECIPIENT_ID}, false);
        public static Index TRANSACTION_TRANSACTION_SENDER_ID_IDX = Internal.createIndex("transaction_sender_id_idx", Transaction.TRANSACTION, new OrderField[]{Transaction.TRANSACTION.SENDER_ID}, false);
        public static Index UNCONFIRMED_TRANSACTION_PRIMARY = Internal.createIndex("PRIMARY", UnconfirmedTransaction.UNCONFIRMED_TRANSACTION, new OrderField[]{UnconfirmedTransaction.UNCONFIRMED_TRANSACTION.DB_ID}, true);
        public static Index UNCONFIRMED_TRANSACTION_UNCONFIRMED_TRANSACTION_HEIGHT_FEE_TIMESTAMP_IDX = Internal.createIndex("unconfirmed_transaction_height_fee_timestamp_idx", UnconfirmedTransaction.UNCONFIRMED_TRANSACTION, new OrderField[]{UnconfirmedTransaction.UNCONFIRMED_TRANSACTION.TRANSACTION_HEIGHT, UnconfirmedTransaction.UNCONFIRMED_TRANSACTION.FEE_PER_BYTE, UnconfirmedTransaction.UNCONFIRMED_TRANSACTION.TIMESTAMP}, false);
        public static Index UNCONFIRMED_TRANSACTION_UNCONFIRMED_TRANSACTION_ID_IDX = Internal.createIndex("unconfirmed_transaction_id_idx", UnconfirmedTransaction.UNCONFIRMED_TRANSACTION, new OrderField[]{UnconfirmedTransaction.UNCONFIRMED_TRANSACTION.ID}, true);
    }
}
