/*
 * This file is generated by jOOQ.
 */
package com.talendorse.server.model.tables.records;


import com.talendorse.server.model.tables.Tokens;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TokensRecord extends UpdatableRecordImpl<TokensRecord> implements Record5<Integer, Integer, String, Timestamp, Timestamp> {

    private static final long serialVersionUID = -1970048846;

    /**
     * Setter for <code>database.tokens.id_tokens</code>.
     */
    public void setIdTokens(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>database.tokens.id_tokens</code>.
     */
    public Integer getIdTokens() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>database.tokens.id_user</code>.
     */
    public void setIdUser(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>database.tokens.id_user</code>.
     */
    public Integer getIdUser() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>database.tokens.token</code>.
     */
    public void setToken(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>database.tokens.token</code>.
     */
    public String getToken() {
        return (String) get(2);
    }

    /**
     * Setter for <code>database.tokens.expiration_date</code>.
     */
    public void setExpirationDate(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>database.tokens.expiration_date</code>.
     */
    public Timestamp getExpirationDate() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>database.tokens.creation_date</code>.
     */
    public void setCreationDate(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>database.tokens.creation_date</code>.
     */
    public Timestamp getCreationDate() {
        return (Timestamp) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, Integer, String, Timestamp, Timestamp> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, Integer, String, Timestamp, Timestamp> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Tokens.TOKENS.ID_TOKENS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Tokens.TOKENS.ID_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Tokens.TOKENS.TOKEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return Tokens.TOKENS.EXPIRATION_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Tokens.TOKENS.CREATION_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getIdTokens();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getIdUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getToken();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getExpirationDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getCreationDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdTokens();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getIdUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getToken();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getExpirationDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getCreationDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TokensRecord value1(Integer value) {
        setIdTokens(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TokensRecord value2(Integer value) {
        setIdUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TokensRecord value3(String value) {
        setToken(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TokensRecord value4(Timestamp value) {
        setExpirationDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TokensRecord value5(Timestamp value) {
        setCreationDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TokensRecord values(Integer value1, Integer value2, String value3, Timestamp value4, Timestamp value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TokensRecord
     */
    public TokensRecord() {
        super(Tokens.TOKENS);
    }

    /**
     * Create a detached, initialised TokensRecord
     */
    public TokensRecord(Integer idTokens, Integer idUser, String token, Timestamp expirationDate, Timestamp creationDate) {
        super(Tokens.TOKENS);

        set(0, idTokens);
        set(1, idUser);
        set(2, token);
        set(3, expirationDate);
        set(4, creationDate);
    }
}
