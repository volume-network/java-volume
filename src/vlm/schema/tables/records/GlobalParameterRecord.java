/*
 * This file is generated by jOOQ.
 */
package vlm.schema.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;
import vlm.schema.tables.GlobalParameter;

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
public class GlobalParameterRecord extends UpdatableRecordImpl<GlobalParameterRecord> implements Record6<Integer, Long, Long, String, Integer, Boolean> {

    private static final long serialVersionUID = -1593003348;

    /**
     * Create a detached GlobalParameterRecord
     */
    public GlobalParameterRecord() {
        super(GlobalParameter.GLOBAL_PARAMETER);
    }

    /**
     * Create a detached, initialised GlobalParameterRecord
     */
    public GlobalParameterRecord(Integer dbId, Long id, Long transactionId, String value, Integer height, Boolean latest) {
        super(GlobalParameter.GLOBAL_PARAMETER);

        set(0, dbId);
        set(1, id);
        set(2, transactionId);
        set(3, value);
        set(4, height);
        set(5, latest);
    }

    /**
     * Getter for <code>DB.global_parameter.db_id</code>.
     */
    public Integer getDbId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>DB.global_parameter.db_id</code>.
     */
    public void setDbId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>DB.global_parameter.id</code>.
     */
    public Long getId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>DB.global_parameter.id</code>.
     */
    public void setId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>DB.global_parameter.transaction_id</code>.
     */
    public Long getTransactionId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>DB.global_parameter.transaction_id</code>.
     */
    public void setTransactionId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>DB.global_parameter.value</code>.
     */
    public String getValue() {
        return (String) get(3);
    }

    /**
     * Setter for <code>DB.global_parameter.value</code>.
     */
    public void setValue(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>DB.global_parameter.height</code>.
     */
    public Integer getHeight() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>DB.global_parameter.height</code>.
     */
    public void setHeight(Integer value) {
        set(4, value);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>DB.global_parameter.latest</code>.
     */
    public Boolean getLatest() {
        return (Boolean) get(5);
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * Setter for <code>DB.global_parameter.latest</code>.
     */
    public void setLatest(Boolean value) {
        set(5, value);
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
    public Row6<Integer, Long, Long, String, Integer, Boolean> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, Long, Long, String, Integer, Boolean> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return GlobalParameter.GLOBAL_PARAMETER.DB_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return GlobalParameter.GLOBAL_PARAMETER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return GlobalParameter.GLOBAL_PARAMETER.TRANSACTION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return GlobalParameter.GLOBAL_PARAMETER.VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return GlobalParameter.GLOBAL_PARAMETER.HEIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field6() {
        return GlobalParameter.GLOBAL_PARAMETER.LATEST;
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
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getTransactionId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getValue();
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
    public Integer value1() {
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
        return getTransactionId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getValue();
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
    public GlobalParameterRecord value1(Integer value) {
        setDbId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GlobalParameterRecord value2(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GlobalParameterRecord value3(Long value) {
        setTransactionId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GlobalParameterRecord value4(String value) {
        setValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GlobalParameterRecord value5(Integer value) {
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
    public GlobalParameterRecord value6(Boolean value) {
        setLatest(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GlobalParameterRecord values(Integer value1, Long value2, Long value3, String value4, Integer value5, Boolean value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }
}
