/*
 * This file is generated by jOOQ.
 */
package vlm.schema.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;
import vlm.schema.tables.PoolMiner;

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
public class PoolMinerRecord extends UpdatableRecordImpl<PoolMinerRecord> implements Record7<Integer, Long, Long, Integer, Integer, Long, Long> {

    private static final long serialVersionUID = 1357944708;

    /**
     * Create a detached PoolMinerRecord
     */
    public PoolMinerRecord() {
        super(PoolMiner.POOL_MINER);
    }

    /**
     * Create a detached, initialised PoolMinerRecord
     */
    public PoolMinerRecord(Integer dbId, Long accountId, Long poolId, Integer status, Integer height, Long cTime, Long mTime) {
        super(PoolMiner.POOL_MINER);

        set(0, dbId);
        set(1, accountId);
        set(2, poolId);
        set(3, status);
        set(4, height);
        set(5, cTime);
        set(6, mTime);
    }

    /**
     * Getter for <code>DB.pool_miner.db_id</code>.
     */
    public Integer getDbId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>DB.pool_miner.db_id</code>.
     */
    public void setDbId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>DB.pool_miner.account_id</code>. miner account id
     */
    public Long getAccountId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>DB.pool_miner.account_id</code>. miner account id
     */
    public void setAccountId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>DB.pool_miner.pool_id</code>. pool account id
     */
    public Long getPoolId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>DB.pool_miner.pool_id</code>. pool account id
     */
    public void setPoolId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>DB.pool_miner.status</code>. state 0-enable 1- delete
     */
    public Integer getStatus() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>DB.pool_miner.status</code>. state 0-enable 1- delete
     */
    public void setStatus(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>DB.pool_miner.height</code>.
     */
    public Integer getHeight() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>DB.pool_miner.height</code>.
     */
    public void setHeight(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>DB.pool_miner.c_time</code>.
     */
    public Long getCTime() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>DB.pool_miner.c_time</code>.
     */
    public void setCTime(Long value) {
        set(5, value);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>DB.pool_miner.m_time</code>.
     */
    public Long getMTime() {
        return (Long) get(6);
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * Setter for <code>DB.pool_miner.m_time</code>.
     */
    public void setMTime(Long value) {
        set(6, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, Long, Long, Integer, Integer, Long, Long> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, Long, Long, Integer, Integer, Long, Long> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return PoolMiner.POOL_MINER.DB_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return PoolMiner.POOL_MINER.ACCOUNT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return PoolMiner.POOL_MINER.POOL_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return PoolMiner.POOL_MINER.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return PoolMiner.POOL_MINER.HEIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field6() {
        return PoolMiner.POOL_MINER.C_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field7() {
        return PoolMiner.POOL_MINER.M_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getDbId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getAccountId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getPoolId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getStatus();
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
    public Long component6() {
        return getCTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component7() {
        return getMTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getDbId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getAccountId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getPoolId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getStatus();
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
    public Long value6() {
        return getCTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value7() {
        return getMTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PoolMinerRecord value1(Integer value) {
        setDbId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PoolMinerRecord value2(Long value) {
        setAccountId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PoolMinerRecord value3(Long value) {
        setPoolId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PoolMinerRecord value4(Integer value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PoolMinerRecord value5(Integer value) {
        setHeight(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PoolMinerRecord value6(Long value) {
        setCTime(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public PoolMinerRecord value7(Long value) {
        setMTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PoolMinerRecord values(Integer value1, Long value2, Long value3, Integer value4, Integer value5, Long value6, Long value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }
}
