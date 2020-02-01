/*
 * This file is generated by jOOQ.
 */
package vlm.schema.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.UpdatableRecordImpl;
import vlm.schema.tables.Trade;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.10.5"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class TradeRecord extends UpdatableRecordImpl<TradeRecord> implements Record13<Long, Long, Long, Long, Long, Integer, Integer, Long, Long, Long, Long, Integer, Integer> {

    private static final long serialVersionUID = -554073269;

    /**
     * Create a detached TradeRecord
     */
    public TradeRecord() {
        super(Trade.TRADE);
    }

    /**
     * Create a detached, initialised TradeRecord
     */
    public TradeRecord(Long dbId, Long assetId, Long blockId, Long askOrderId, Long bidOrderId, Integer askOrderHeight, Integer bidOrderHeight, Long sellerId, Long buyerId, Long quantity, Long price, Integer timestamp, Integer height) {
        super(Trade.TRADE);

        set(0, dbId);
        set(1, assetId);
        set(2, blockId);
        set(3, askOrderId);
        set(4, bidOrderId);
        set(5, askOrderHeight);
        set(6, bidOrderHeight);
        set(7, sellerId);
        set(8, buyerId);
        set(9, quantity);
        set(10, price);
        set(11, timestamp);
        set(12, height);
    }

    /**
     * Getter for <code>DB.trade.db_id</code>.
     */
    public Long getDbId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>DB.trade.db_id</code>.
     */
    public void setDbId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>DB.trade.asset_id</code>.
     */
    public Long getAssetId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>DB.trade.asset_id</code>.
     */
    public void setAssetId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>DB.trade.block_id</code>.
     */
    public Long getBlockId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>DB.trade.block_id</code>.
     */
    public void setBlockId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>DB.trade.ask_order_id</code>.
     */
    public Long getAskOrderId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>DB.trade.ask_order_id</code>.
     */
    public void setAskOrderId(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>DB.trade.bid_order_id</code>.
     */
    public Long getBidOrderId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>DB.trade.bid_order_id</code>.
     */
    public void setBidOrderId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>DB.trade.ask_order_height</code>.
     */
    public Integer getAskOrderHeight() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>DB.trade.ask_order_height</code>.
     */
    public void setAskOrderHeight(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>DB.trade.bid_order_height</code>.
     */
    public Integer getBidOrderHeight() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>DB.trade.bid_order_height</code>.
     */
    public void setBidOrderHeight(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>DB.trade.seller_id</code>.
     */
    public Long getSellerId() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>DB.trade.seller_id</code>.
     */
    public void setSellerId(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>DB.trade.buyer_id</code>.
     */
    public Long getBuyerId() {
        return (Long) get(8);
    }

    /**
     * Setter for <code>DB.trade.buyer_id</code>.
     */
    public void setBuyerId(Long value) {
        set(8, value);
    }

    /**
     * Getter for <code>DB.trade.quantity</code>.
     */
    public Long getQuantity() {
        return (Long) get(9);
    }

    /**
     * Setter for <code>DB.trade.quantity</code>.
     */
    public void setQuantity(Long value) {
        set(9, value);
    }

    /**
     * Getter for <code>DB.trade.price</code>.
     */
    public Long getPrice() {
        return (Long) get(10);
    }

    /**
     * Setter for <code>DB.trade.price</code>.
     */
    public void setPrice(Long value) {
        set(10, value);
    }

    /**
     * Getter for <code>DB.trade.timestamp</code>.
     */
    public Integer getTimestamp() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>DB.trade.timestamp</code>.
     */
    public void setTimestamp(Integer value) {
        set(11, value);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>DB.trade.height</code>.
     */
    public Integer getHeight() {
        return (Integer) get(12);
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    /**
     * Setter for <code>DB.trade.height</code>.
     */
    public void setHeight(Integer value) {
        set(12, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<Long, Long, Long, Long, Long, Integer, Integer, Long, Long, Long, Long, Integer, Integer> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<Long, Long, Long, Long, Long, Integer, Integer, Long, Long, Long, Long, Integer, Integer> valuesRow() {
        return (Row13) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Trade.TRADE.DB_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return Trade.TRADE.ASSET_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return Trade.TRADE.BLOCK_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field4() {
        return Trade.TRADE.ASK_ORDER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return Trade.TRADE.BID_ORDER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Trade.TRADE.ASK_ORDER_HEIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Trade.TRADE.BID_ORDER_HEIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return Trade.TRADE.SELLER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field9() {
        return Trade.TRADE.BUYER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field10() {
        return Trade.TRADE.QUANTITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field11() {
        return Trade.TRADE.PRICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field12() {
        return Trade.TRADE.TIMESTAMP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field13() {
        return Trade.TRADE.HEIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getDbId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getAssetId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getBlockId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component4() {
        return getAskOrderId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component5() {
        return getBidOrderId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getAskOrderHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getBidOrderHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component8() {
        return getSellerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component9() {
        return getBuyerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component10() {
        return getQuantity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component11() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component12() {
        return getTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component13() {
        return getHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getDbId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getAssetId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getBlockId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value4() {
        return getAskOrderId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getBidOrderId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getAskOrderHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getBidOrderHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getSellerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value9() {
        return getBuyerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value10() {
        return getQuantity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value11() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value12() {
        return getTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value13() {
        return getHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TradeRecord value1(Long value) {
        setDbId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TradeRecord value2(Long value) {
        setAssetId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TradeRecord value3(Long value) {
        setBlockId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TradeRecord value4(Long value) {
        setAskOrderId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TradeRecord value5(Long value) {
        setBidOrderId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TradeRecord value6(Integer value) {
        setAskOrderHeight(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TradeRecord value7(Integer value) {
        setBidOrderHeight(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TradeRecord value8(Long value) {
        setSellerId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TradeRecord value9(Long value) {
        setBuyerId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TradeRecord value10(Long value) {
        setQuantity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TradeRecord value11(Long value) {
        setPrice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TradeRecord value12(Integer value) {
        setTimestamp(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public TradeRecord value13(Integer value) {
        setHeight(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TradeRecord values(Long value1, Long value2, Long value3, Long value4, Long value5, Integer value6, Integer value7, Long value8, Long value9, Long value10, Long value11, Integer value12, Integer value13) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        return this;
    }
}
