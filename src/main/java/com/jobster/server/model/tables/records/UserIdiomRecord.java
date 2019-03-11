/*
 * This file is generated by jOOQ.
 */
package com.jobster.server.model.tables.records;


import com.jobster.server.model.tables.UserIdiom;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class UserIdiomRecord extends UpdatableRecordImpl<UserIdiomRecord> implements Record3<Integer, Integer, Integer> {

    private static final long serialVersionUID = -1000680724;

    /**
     * Setter for <code>jobster.user_idiom.id_user_idiom</code>.
     */
    public void setIdUserIdiom(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>jobster.user_idiom.id_user_idiom</code>.
     */
    public Integer getIdUserIdiom() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>jobster.user_idiom.id_user</code>.
     */
    public void setIdUser(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>jobster.user_idiom.id_user</code>.
     */
    public Integer getIdUser() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>jobster.user_idiom.id_idiom</code>.
     */
    public void setIdIdiom(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>jobster.user_idiom.id_idiom</code>.
     */
    public Integer getIdIdiom() {
        return (Integer) get(2);
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
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return UserIdiom.USER_IDIOM.ID_USER_IDIOM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return UserIdiom.USER_IDIOM.ID_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return UserIdiom.USER_IDIOM.ID_IDIOM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getIdUserIdiom();
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
    public Integer component3() {
        return getIdIdiom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdUserIdiom();
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
    public Integer value3() {
        return getIdIdiom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserIdiomRecord value1(Integer value) {
        setIdUserIdiom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserIdiomRecord value2(Integer value) {
        setIdUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserIdiomRecord value3(Integer value) {
        setIdIdiom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserIdiomRecord values(Integer value1, Integer value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserIdiomRecord
     */
    public UserIdiomRecord() {
        super(UserIdiom.USER_IDIOM);
    }

    /**
     * Create a detached, initialised UserIdiomRecord
     */
    public UserIdiomRecord(Integer idUserIdiom, Integer idUser, Integer idIdiom) {
        super(UserIdiom.USER_IDIOM);

        set(0, idUserIdiom);
        set(1, idUser);
        set(2, idIdiom);
    }
}