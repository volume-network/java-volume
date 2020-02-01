/*
 * This file is generated by jOOQ.
 */
package vlm.schema.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;
import vlm.schema.tables.Alias;

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
public class AliasRecord extends UpdatableRecordImpl<AliasRecord> implements Record9<Long, Long, Long, String, String, String, Integer, Integer, Boolean> {

    private static final long serialVersionUID = -252723377;

    /**
     * Create a detached AliasRecord
     */
    public AliasRecord() {
        super(Alias.ALIAS);
    }

    /**
     * Create a detached, initialised AliasRecord
     */
    public AliasRecord(Long dbId, Long id, Long accountId, String aliasName, String aliasNameLower, String aliasUri, Integer timestamp, Integer height, Boolean latest) {
        super(Alias.ALIAS);

        set(0, dbId);
        set(1, id);
        set(2, accountId);
        set(3, aliasName);
        set(4, aliasNameLower);
        set(5, aliasUri);
        set(6, timestamp);
        set(7, height);
        set(8, latest);
    }

    /**
     * Getter for <code>DB.alias.db_id</code>.
     */
    public Long getDbId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>DB.alias.db_id</code>.
     */
    public void setDbId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>DB.alias.id</code>.
     */
    public Long getId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>DB.alias.id</code>.
     */
    public void setId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>DB.alias.account_id</code>.
     */
    public Long getAccountId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>DB.alias.account_id</code>.
     */
    public void setAccountId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>DB.alias.alias_name</code>.
     */
    public String getAliasName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>DB.alias.alias_name</code>.
     */
    public void setAliasName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>DB.alias.alias_name_lower</code>.
     */
    public String getAliasNameLower() {
        return (String) get(4);
    }

    /**
     * Setter for <code>DB.alias.alias_name_lower</code>.
     */
    public void setAliasNameLower(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>DB.alias.alias_uri</code>.
     */
    public String getAliasUri() {
        return (String) get(5);
    }

    /**
     * Setter for <code>DB.alias.alias_uri</code>.
     */
    public void setAliasUri(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>DB.alias.timestamp</code>.
     */
    public Integer getTimestamp() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>DB.alias.timestamp</code>.
     */
    public void setTimestamp(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>DB.alias.height</code>.
     */
    public Integer getHeight() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>DB.alias.height</code>.
     */
    public void setHeight(Integer value) {
        set(7, value);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>DB.alias.latest</code>.
     */
    public Boolean getLatest() {
        return (Boolean) get(8);
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * Setter for <code>DB.alias.latest</code>.
     */
    public void setLatest(Boolean value) {
        set(8, value);
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
    public Row9<Long, Long, Long, String, String, String, Integer, Integer, Boolean> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Long, Long, Long, String, String, String, Integer, Integer, Boolean> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Alias.ALIAS.DB_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return Alias.ALIAS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return Alias.ALIAS.ACCOUNT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Alias.ALIAS.ALIAS_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Alias.ALIAS.ALIAS_NAME_LOWER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Alias.ALIAS.ALIAS_URI;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Alias.ALIAS.TIMESTAMP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return Alias.ALIAS.HEIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field9() {
        return Alias.ALIAS.LATEST;
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
        return getAccountId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getAliasName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getAliasNameLower();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getAliasUri();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component9() {
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
        return getAccountId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getAliasName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getAliasNameLower();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getAliasUri();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value9() {
        return getLatest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasRecord value1(Long value) {
        setDbId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasRecord value2(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasRecord value3(Long value) {
        setAccountId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasRecord value4(String value) {
        setAliasName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasRecord value5(String value) {
        setAliasNameLower(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasRecord value6(String value) {
        setAliasUri(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasRecord value7(Integer value) {
        setTimestamp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasRecord value8(Integer value) {
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
    public AliasRecord value9(Boolean value) {
        setLatest(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasRecord values(Long value1, Long value2, Long value3, String value4, String value5, String value6, Integer value7, Integer value8, Boolean value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }
}
