/*
 * This file is generated by jOOQ.
 */
package com.jobster.server.model.tables.records;


import com.jobster.server.model.tables.Users;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record21;
import org.jooq.Row21;
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
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record21<Integer, String, String, String, String, Timestamp, String, String, String, String, String, Integer, String, String, String, Timestamp, String, Integer, String, Timestamp, Timestamp> {

    private static final long serialVersionUID = 142883858;

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

    /**
     * Setter for <code>jobster.users.picture_url</code>.
     */
    public void setPictureUrl(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>jobster.users.picture_url</code>.
     */
    public String getPictureUrl() {
        return (String) get(9);
    }

    /**
     * Setter for <code>jobster.users.apikey</code>.
     */
    public void setApikey(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>jobster.users.apikey</code>.
     */
    public String getApikey() {
        return (String) get(10);
    }

    /**
     * Setter for <code>jobster.users.verified_email</code>.
     */
    public void setVerifiedEmail(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>jobster.users.verified_email</code>.
     */
    public Integer getVerifiedEmail() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>jobster.users.user_name</code>.
     */
    public void setUserName(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>jobster.users.user_name</code>.
     */
    public String getUserName() {
        return (String) get(12);
    }

    /**
     * Setter for <code>jobster.users.password</code>.
     */
    public void setPassword(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>jobster.users.password</code>.
     */
    public String getPassword() {
        return (String) get(13);
    }

    /**
     * Setter for <code>jobster.users.salt</code>.
     */
    public void setSalt(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>jobster.users.salt</code>.
     */
    public String getSalt() {
        return (String) get(14);
    }

    /**
     * Setter for <code>jobster.users.last_connection</code>.
     */
    public void setLastConnection(Timestamp value) {
        set(15, value);
    }

    /**
     * Getter for <code>jobster.users.last_connection</code>.
     */
    public Timestamp getLastConnection() {
        return (Timestamp) get(15);
    }

    /**
     * Setter for <code>jobster.users.phone_number</code>.
     */
    public void setPhoneNumber(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>jobster.users.phone_number</code>.
     */
    public String getPhoneNumber() {
        return (String) get(16);
    }

    /**
     * Setter for <code>jobster.users.verified_phone_number</code>.
     */
    public void setVerifiedPhoneNumber(Integer value) {
        set(17, value);
    }

    /**
     * Getter for <code>jobster.users.verified_phone_number</code>.
     */
    public Integer getVerifiedPhoneNumber() {
        return (Integer) get(17);
    }

    /**
     * Setter for <code>jobster.users.idiom</code>.
     */
    public void setIdiom(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>jobster.users.idiom</code>.
     */
    public String getIdiom() {
        return (String) get(18);
    }

    /**
     * Setter for <code>jobster.users.date_created</code>.
     */
    public void setDateCreated(Timestamp value) {
        set(19, value);
    }

    /**
     * Getter for <code>jobster.users.date_created</code>.
     */
    public Timestamp getDateCreated() {
        return (Timestamp) get(19);
    }

    /**
     * Setter for <code>jobster.users.date_modification</code>.
     */
    public void setDateModification(Timestamp value) {
        set(20, value);
    }

    /**
     * Getter for <code>jobster.users.date_modification</code>.
     */
    public Timestamp getDateModification() {
        return (Timestamp) get(20);
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
    // Record21 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row21<Integer, String, String, String, String, Timestamp, String, String, String, String, String, Integer, String, String, String, Timestamp, String, Integer, String, Timestamp, Timestamp> fieldsRow() {
        return (Row21) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row21<Integer, String, String, String, String, Timestamp, String, String, String, String, String, Integer, String, String, String, Timestamp, String, Integer, String, Timestamp, Timestamp> valuesRow() {
        return (Row21) super.valuesRow();
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
    public Field<String> field10() {
        return Users.USERS.PICTURE_URL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return Users.USERS.APIKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field12() {
        return Users.USERS.VERIFIED_EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return Users.USERS.USER_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field14() {
        return Users.USERS.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return Users.USERS.SALT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field16() {
        return Users.USERS.LAST_CONNECTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field17() {
        return Users.USERS.PHONE_NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field18() {
        return Users.USERS.VERIFIED_PHONE_NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field19() {
        return Users.USERS.IDIOM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field20() {
        return Users.USERS.DATE_CREATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field21() {
        return Users.USERS.DATE_MODIFICATION;
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
    public String component10() {
        return getPictureUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getApikey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component12() {
        return getVerifiedEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getUserName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component14() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component15() {
        return getSalt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component16() {
        return getLastConnection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component17() {
        return getPhoneNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component18() {
        return getVerifiedPhoneNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component19() {
        return getIdiom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component20() {
        return getDateCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component21() {
        return getDateModification();
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
    public String value10() {
        return getPictureUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getApikey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value12() {
        return getVerifiedEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getUserName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value14() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getSalt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value16() {
        return getLastConnection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value17() {
        return getPhoneNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value18() {
        return getVerifiedPhoneNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value19() {
        return getIdiom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value20() {
        return getDateCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value21() {
        return getDateModification();
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
    public UsersRecord value10(String value) {
        setPictureUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value11(String value) {
        setApikey(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value12(Integer value) {
        setVerifiedEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value13(String value) {
        setUserName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value14(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value15(String value) {
        setSalt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value16(Timestamp value) {
        setLastConnection(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value17(String value) {
        setPhoneNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value18(Integer value) {
        setVerifiedPhoneNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value19(String value) {
        setIdiom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value20(Timestamp value) {
        setDateCreated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value21(Timestamp value) {
        setDateModification(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord values(Integer value1, String value2, String value3, String value4, String value5, Timestamp value6, String value7, String value8, String value9, String value10, String value11, Integer value12, String value13, String value14, String value15, Timestamp value16, String value17, Integer value18, String value19, Timestamp value20, Timestamp value21) {
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
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        value21(value21);
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
    public UsersRecord(Integer idUser, String name, String surrname, String email, String currentPosition, Timestamp dateBirthday, String gender, String sector, String headline, String pictureUrl, String apikey, Integer verifiedEmail, String userName, String password, String salt, Timestamp lastConnection, String phoneNumber, Integer verifiedPhoneNumber, String idiom, Timestamp dateCreated, Timestamp dateModification) {
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
        set(9, pictureUrl);
        set(10, apikey);
        set(11, verifiedEmail);
        set(12, userName);
        set(13, password);
        set(14, salt);
        set(15, lastConnection);
        set(16, phoneNumber);
        set(17, verifiedPhoneNumber);
        set(18, idiom);
        set(19, dateCreated);
        set(20, dateModification);
    }
}
