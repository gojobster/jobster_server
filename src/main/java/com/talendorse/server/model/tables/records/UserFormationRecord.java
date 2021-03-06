/*
 * This file is generated by jOOQ.
 */
package com.talendorse.server.model.tables.records;


import com.talendorse.server.model.tables.UserFormation;

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
public class UserFormationRecord extends UpdatableRecordImpl<UserFormationRecord> implements Record3<Integer, Integer, Integer> {

    private static final long serialVersionUID = 1723959085;

    /**
     * Setter for <code>database.user_formation.id_user_formation</code>.
     */
    public void setIdUserFormation(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>database.user_formation.id_user_formation</code>.
     */
    public Integer getIdUserFormation() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>database.user_formation.id_user</code>.
     */
    public void setIdUser(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>database.user_formation.id_user</code>.
     */
    public Integer getIdUser() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>database.user_formation.id_formation</code>.
     */
    public void setIdFormation(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>database.user_formation.id_formation</code>.
     */
    public Integer getIdFormation() {
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
        return UserFormation.USER_FORMATION.ID_USER_FORMATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return UserFormation.USER_FORMATION.ID_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return UserFormation.USER_FORMATION.ID_FORMATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getIdUserFormation();
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
        return getIdFormation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdUserFormation();
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
        return getIdFormation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFormationRecord value1(Integer value) {
        setIdUserFormation(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFormationRecord value2(Integer value) {
        setIdUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFormationRecord value3(Integer value) {
        setIdFormation(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFormationRecord values(Integer value1, Integer value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserFormationRecord
     */
    public UserFormationRecord() {
        super(UserFormation.USER_FORMATION);
    }

    /**
     * Create a detached, initialised UserFormationRecord
     */
    public UserFormationRecord(Integer idUserFormation, Integer idUser, Integer idFormation) {
        super(UserFormation.USER_FORMATION);

        set(0, idUserFormation);
        set(1, idUser);
        set(2, idFormation);
    }
}
