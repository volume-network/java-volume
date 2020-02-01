/*
 * This file is generated by jOOQ.
 */
package vlm.schema.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;
import vlm.schema.tables.AliasOffer;

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
public class AliasOfferRecord extends UpdatableRecordImpl<AliasOfferRecord> implements Record6<Long, Long, Long, Long, Integer, Boolean> {

    private static final long serialVersionUID = 998867890;

    /**
     * Create a detached AliasOfferRecord
     */
    public AliasOfferRecord() {
        super(AliasOffer.ALIAS_OFFER);
    }

    /**
     * Create a detached, initialised AliasOfferRecord
     */
    public AliasOfferRecord(Long dbId, Long id, Long price, Long buyerId, Integer height, Boolean latest) {
        super(AliasOffer.ALIAS_OFFER);

        set(0, dbId);
        set(1, id);
        set(2, price);
        set(3, buyerId);
        set(4, height);
        set(5, latest);
    }

    /**
     * Getter for <code>DB.alias_offer.db_id</code>.
     */
    public Long getDbId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>DB.alias_offer.db_id</code>.
     */
    public void setDbId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>DB.alias_offer.id</code>.
     */
    public Long getId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>DB.alias_offer.id</code>.
     */
    public void setId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>DB.alias_offer.price</code>.
     */
    public Long getPrice() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>DB.alias_offer.price</code>.
     */
    public void setPrice(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>DB.alias_offer.buyer_id</code>.
     */
    public Long getBuyerId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>DB.alias_offer.buyer_id</code>.
     */
    public void setBuyerId(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>DB.alias_offer.height</code>.
     */
    public Integer getHeight() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>DB.alias_offer.height</code>.
     */
    public void setHeight(Integer value) {
        set(4, value);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>DB.alias_offer.latest</code>.
     */
    public Boolean getLatest() {
        return (Boolean) get(5);
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * Setter for <code>DB.alias_offer.latest</code>.
     */
    public void setLatest(Boolean value) {
        set(5, value);
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
    public Row6<Long, Long, Long, Long, Integer, Boolean> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, Long, Long, Long, Integer, Boolean> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return AliasOffer.ALIAS_OFFER.DB_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return AliasOffer.ALIAS_OFFER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return AliasOffer.ALIAS_OFFER.PRICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field4() {
        return AliasOffer.ALIAS_OFFER.BUYER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return AliasOffer.ALIAS_OFFER.HEIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field6() {
        return AliasOffer.ALIAS_OFFER.LATEST;
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
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component4() {
        return getBuyerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component6() {
        return getLatest();
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
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value4() {
        return getBuyerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value6() {
        return getLatest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasOfferRecord value1(Long value) {
        setDbId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasOfferRecord value2(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasOfferRecord value3(Long value) {
        setPrice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasOfferRecord value4(Long value) {
        setBuyerId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasOfferRecord value5(Integer value) {
        setHeight(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasOfferRecord value6(Boolean value) {
        setLatest(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasOfferRecord values(Long value1, Long value2, Long value3, Long value4, Integer value5, Boolean value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }
}
