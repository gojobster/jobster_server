/*
 * This file is generated by jOOQ.
 */
package com.talendorse.server.model.tables;


import com.talendorse.server.model.Database;
import com.talendorse.server.model.Indexes;
import com.talendorse.server.model.Keys;
import com.talendorse.server.model.tables.records.UsersRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Users extends TableImpl<UsersRecord> {

    private static final long serialVersionUID = 1899486316;

    /**
     * The reference instance of <code>database.users</code>
     */
    public static final Users USERS = new Users();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsersRecord> getRecordType() {
        return UsersRecord.class;
    }

    /**
     * The column <code>database.users.id_user</code>.
     */
    public final TableField<UsersRecord, Integer> ID_USER = createField("id_user", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>database.users.role</code>.
     */
    public final TableField<UsersRecord, Integer> ROLE = createField("role", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>database.users.id_linkedin</code>. - Endorser: 0
- Company: 1
- Admin: 2
     */
    public final TableField<UsersRecord, String> ID_LINKEDIN = createField("id_linkedin", org.jooq.impl.SQLDataType.VARCHAR(90), this, "- Endorser: 0\n- Company: 1\n- Admin: 2");

    /**
     * The column <code>database.users.token_linkedin</code>.
     */
    public final TableField<UsersRecord, String> TOKEN_LINKEDIN = createField("token_linkedin", org.jooq.impl.SQLDataType.VARCHAR(999).nullable(false), this, "");

    /**
     * The column <code>database.users.name</code>.
     */
    public final TableField<UsersRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>database.users.surname</code>.
     */
    public final TableField<UsersRecord, String> SURNAME = createField("surname", org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>database.users.email</code>.
     */
    public final TableField<UsersRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>database.users.current_position</code>.
     */
    public final TableField<UsersRecord, String> CURRENT_POSITION = createField("current_position", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>database.users.date_birthday</code>.
     */
    public final TableField<UsersRecord, Timestamp> DATE_BIRTHDAY = createField("date_birthday", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>database.users.gender</code>.
     */
    public final TableField<UsersRecord, String> GENDER = createField("gender", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>database.users.sector</code>.
     */
    public final TableField<UsersRecord, String> SECTOR = createField("sector", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>database.users.headline</code>.
     */
    public final TableField<UsersRecord, String> HEADLINE = createField("headline", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>database.users.picture_url</code>.
     */
    public final TableField<UsersRecord, String> PICTURE_URL = createField("picture_url", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>database.users.thumb_url</code>.
     */
    public final TableField<UsersRecord, String> THUMB_URL = createField("thumb_url", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>database.users.verified_email</code>.
     */
    public final TableField<UsersRecord, Integer> VERIFIED_EMAIL = createField("verified_email", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>database.users.user_name</code>.
     */
    public final TableField<UsersRecord, String> USER_NAME = createField("user_name", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>database.users.password</code>.
     */
    public final TableField<UsersRecord, String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>database.users.salt</code>.
     */
    public final TableField<UsersRecord, String> SALT = createField("salt", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>database.users.last_connection</code>.
     */
    public final TableField<UsersRecord, Timestamp> LAST_CONNECTION = createField("last_connection", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>database.users.phone_number</code>.
     */
    public final TableField<UsersRecord, String> PHONE_NUMBER = createField("phone_number", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>database.users.verified_phone_number</code>.
     */
    public final TableField<UsersRecord, Integer> VERIFIED_PHONE_NUMBER = createField("verified_phone_number", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>database.users.language</code>.
     */
    public final TableField<UsersRecord, String> LANGUAGE = createField("language", org.jooq.impl.SQLDataType.VARCHAR(45).defaultValue(org.jooq.impl.DSL.inline("en", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>database.users.validation_token</code>.
     */
    public final TableField<UsersRecord, String> VALIDATION_TOKEN = createField("validation_token", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>database.users.date_created</code>.
     */
    public final TableField<UsersRecord, Timestamp> DATE_CREATED = createField("date_created", org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>database.users.date_modification</code>.
     */
    public final TableField<UsersRecord, Timestamp> DATE_MODIFICATION = createField("date_modification", org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>database.users</code> table reference
     */
    public Users() {
        this(DSL.name("users"), null);
    }

    /**
     * Create an aliased <code>database.users</code> table reference
     */
    public Users(String alias) {
        this(DSL.name(alias), USERS);
    }

    /**
     * Create an aliased <code>database.users</code> table reference
     */
    public Users(Name alias) {
        this(alias, USERS);
    }

    private Users(Name alias, Table<UsersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Users(Name alias, Table<UsersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Users(Table<O> child, ForeignKey<O, UsersRecord> key) {
        super(child, key, USERS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Database.DATABASE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.USERS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<UsersRecord, Integer> getIdentity() {
        return Keys.IDENTITY_USERS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UsersRecord> getPrimaryKey() {
        return Keys.KEY_USERS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UsersRecord>> getKeys() {
        return Arrays.<UniqueKey<UsersRecord>>asList(Keys.KEY_USERS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Users as(String alias) {
        return new Users(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Users as(Name alias) {
        return new Users(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Users rename(String name) {
        return new Users(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Users rename(Name name) {
        return new Users(name, null);
    }
}
