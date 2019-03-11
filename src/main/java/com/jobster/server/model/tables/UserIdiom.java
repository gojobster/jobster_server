/*
 * This file is generated by jOOQ.
 */
package com.jobster.server.model.tables;


import com.jobster.server.model.Indexes;
import com.jobster.server.model.Jobster;
import com.jobster.server.model.Keys;
import com.jobster.server.model.tables.records.UserIdiomRecord;

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
public class UserIdiom extends TableImpl<UserIdiomRecord> {

    private static final long serialVersionUID = -1545799098;

    /**
     * The reference instance of <code>jobster.user_idiom</code>
     */
    public static final UserIdiom USER_IDIOM = new UserIdiom();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserIdiomRecord> getRecordType() {
        return UserIdiomRecord.class;
    }

    /**
     * The column <code>jobster.user_idiom.id_user_idiom</code>.
     */
    public final TableField<UserIdiomRecord, Integer> ID_USER_IDIOM = createField("id_user_idiom", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>jobster.user_idiom.id_user</code>.
     */
    public final TableField<UserIdiomRecord, Integer> ID_USER = createField("id_user", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>jobster.user_idiom.id_idiom</code>.
     */
    public final TableField<UserIdiomRecord, Integer> ID_IDIOM = createField("id_idiom", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>jobster.user_idiom</code> table reference
     */
    public UserIdiom() {
        this(DSL.name("user_idiom"), null);
    }

    /**
     * Create an aliased <code>jobster.user_idiom</code> table reference
     */
    public UserIdiom(String alias) {
        this(DSL.name(alias), USER_IDIOM);
    }

    /**
     * Create an aliased <code>jobster.user_idiom</code> table reference
     */
    public UserIdiom(Name alias) {
        this(alias, USER_IDIOM);
    }

    private UserIdiom(Name alias, Table<UserIdiomRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserIdiom(Name alias, Table<UserIdiomRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> UserIdiom(Table<O> child, ForeignKey<O, UserIdiomRecord> key) {
        super(child, key, USER_IDIOM);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Jobster.JOBSTER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.USER_IDIOM_PRIMARY, Indexes.USER_IDIOM_USER_IDIOM_IDIOM_IDX, Indexes.USER_IDIOM_USUARIO_IDIOMA_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<UserIdiomRecord, Integer> getIdentity() {
        return Keys.IDENTITY_USER_IDIOM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UserIdiomRecord> getPrimaryKey() {
        return Keys.KEY_USER_IDIOM_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UserIdiomRecord>> getKeys() {
        return Arrays.<UniqueKey<UserIdiomRecord>>asList(Keys.KEY_USER_IDIOM_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<UserIdiomRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserIdiomRecord, ?>>asList(Keys.USER_IDIOM_USER, Keys.USER_IDIOM_IDIOM);
    }

    public Users users() {
        return new Users(this, Keys.USER_IDIOM_USER);
    }

    public Idioms idioms() {
        return new Idioms(this, Keys.USER_IDIOM_IDIOM);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserIdiom as(String alias) {
        return new UserIdiom(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserIdiom as(Name alias) {
        return new UserIdiom(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserIdiom rename(String name) {
        return new UserIdiom(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserIdiom rename(Name name) {
        return new UserIdiom(name, null);
    }
}
