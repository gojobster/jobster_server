/*
 * This file is generated by jOOQ.
 */
package com.talendorse.server.model.tables;


import com.talendorse.server.model.Database;
import com.talendorse.server.model.Indexes;
import com.talendorse.server.model.Keys;
import com.talendorse.server.model.tables.records.UserLanguageRecord;

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
public class UserLanguage extends TableImpl<UserLanguageRecord> {

    private static final long serialVersionUID = -1530228849;

    /**
     * The reference instance of <code>database.user_language</code>
     */
    public static final UserLanguage USER_LANGUAGE = new UserLanguage();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserLanguageRecord> getRecordType() {
        return UserLanguageRecord.class;
    }

    /**
     * The column <code>database.user_language.id_user_language</code>.
     */
    public final TableField<UserLanguageRecord, Integer> ID_USER_LANGUAGE = createField("id_user_language", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>database.user_language.id_user</code>.
     */
    public final TableField<UserLanguageRecord, Integer> ID_USER = createField("id_user", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>database.user_language.id_language</code>.
     */
    public final TableField<UserLanguageRecord, Integer> ID_LANGUAGE = createField("id_language", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>database.user_language.level</code>.
     */
    public final TableField<UserLanguageRecord, Integer> LEVEL = createField("level", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>database.user_language.date_created</code>.
     */
    public final TableField<UserLanguageRecord, Timestamp> DATE_CREATED = createField("date_created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>database.user_language</code> table reference
     */
    public UserLanguage() {
        this(DSL.name("user_language"), null);
    }

    /**
     * Create an aliased <code>database.user_language</code> table reference
     */
    public UserLanguage(String alias) {
        this(DSL.name(alias), USER_LANGUAGE);
    }

    /**
     * Create an aliased <code>database.user_language</code> table reference
     */
    public UserLanguage(Name alias) {
        this(alias, USER_LANGUAGE);
    }

    private UserLanguage(Name alias, Table<UserLanguageRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserLanguage(Name alias, Table<UserLanguageRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> UserLanguage(Table<O> child, ForeignKey<O, UserLanguageRecord> key) {
        super(child, key, USER_LANGUAGE);
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
        return Arrays.<Index>asList(Indexes.USER_LANGUAGE_PRIMARY, Indexes.USER_LANGUAGE_USER_IDIOM_IDIOM_IDX, Indexes.USER_LANGUAGE_USUARIO_IDIOMA_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<UserLanguageRecord, Integer> getIdentity() {
        return Keys.IDENTITY_USER_LANGUAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UserLanguageRecord> getPrimaryKey() {
        return Keys.KEY_USER_LANGUAGE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UserLanguageRecord>> getKeys() {
        return Arrays.<UniqueKey<UserLanguageRecord>>asList(Keys.KEY_USER_LANGUAGE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<UserLanguageRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserLanguageRecord, ?>>asList(Keys.USER_IDIOM_USER);
    }

    public Users users() {
        return new Users(this, Keys.USER_IDIOM_USER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserLanguage as(String alias) {
        return new UserLanguage(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserLanguage as(Name alias) {
        return new UserLanguage(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserLanguage rename(String name) {
        return new UserLanguage(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserLanguage rename(Name name) {
        return new UserLanguage(name, null);
    }
}
