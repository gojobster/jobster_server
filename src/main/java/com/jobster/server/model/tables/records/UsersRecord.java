/*
 * This file is generated by jOOQ.
 */
package com.jobster.server.model.tables.records;


import com.jobster.server.model.tables.Users;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record9<Integer, String, String, String, String, Timestamp, String, String, String> {

    private static final long serialVersionUID = 672011065;

    /**
     * Setter for <code>jobster.users.id_user</code>.
     */
    public void setIdUser(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>jobster.users.id_user</code>.
     */
    public Integer getIdUser() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>jobster.users.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>jobster.users.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>jobster.users.surrname</code>.
     */
    public void setSurrname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>jobster.users.surrname</code>.
     */
    public String getSurrname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>jobster.users.email</code>.
     */
    public void setEmail(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>jobster.users.email</code>.
     */
    public String getEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>jobster.users.current_position</code>.
     */
    public void setCurrentPosition(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>jobster.users.current_position</code>.
     */
    public String getCurrentPosition() {
        return (String) get(4);
    }

    /**
     * Setter for <code>jobster.users.date_birthday</code>.
     */
    public void setDateBirthday(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>jobster.users.date_birthday</code>.
     */
    public Timestamp getDateBirthday() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>jobster.users.gender</code>.
     */
    public void setGender(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>jobster.users.gender</code>.
     */
    public String getGender() {
        return (String) get(6);
    }

    /**
     * Setter for <code>jobster.users.sector</code>.
     */
    public void setSector(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>jobster.users.sector</code>.
     */
    public String getSector() {
        return (String) get(7);
    }

    /**
     * Setter for <code>jobster.users.headline</code>.
     */
    public void setHeadline(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>jobster.users.headline</code>.
     */
    public String getHeadline() {
        return (String) get(8);
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
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, String, String, String, String, Timestamp, String, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, String, String, String, String, Timestamp, String, String, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Users.USERS.ID_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Users.USERS.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Users.USERS.SURRNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Users.USERS.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Users.USERS.CURRENT_POSITION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return Users.USERS.DATE_BIRTHDAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Users.USERS.GENDER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Users.USERS.SECTOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Users.USERS.HEADLINE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getIdUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getSurrname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getCurrentPosition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
        return getDateBirthday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getGender();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getSector();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getHeadline();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getSurrname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getCurrentPosition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getDateBirthday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getGender();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getSector();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getHeadline();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value1(Integer value) {
        setIdUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value3(String value) {
        setSurrname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value4(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value5(String value) {
        setCurrentPosition(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value6(Timestamp value) {
        setDateBirthday(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value7(String value) {
        setGender(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value8(String value) {
        setSector(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value9(String value) {
        setHeadline(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord values(Integer value1, String value2, String value3, String value4, String value5, Timestamp value6, String value7, String value8, String value9) {
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

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(Integer idUser, String name, String surrname, String email, String currentPosition, Timestamp dateBirthday, String gender, String sector, String headline) {
        super(Users.USERS);

        set(0, idUser);
        set(1, name);
        set(2, surrname);
        set(3, email);
        set(4, currentPosition);
        set(5, dateBirthday);
        set(6, gender);
        set(7, sector);
        set(8, headline);
    }
}
