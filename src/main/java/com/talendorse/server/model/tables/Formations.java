/*
 * This file is generated by jOOQ.
 */
package com.talendorse.server.model.tables;


import com.talendorse.server.model.Database;
import com.talendorse.server.model.Indexes;
import com.talendorse.server.model.Keys;
import com.talendorse.server.model.tables.records.FormationsRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class Formations extends TableImpl<FormationsRecord> {

    private static final long serialVersionUID = -10592140;

    /**
     * The reference instance of <code>database.formations</code>
     */
    public static final Formations FORMATIONS = new Formations();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FormationsRecord> getRecordType() {
        return FormationsRecord.class;
    }

    /**
     * The column <code>database.formations.id_formation</code>.
     */
    public final TableField<FormationsRecord, Integer> ID_FORMATION = createField("id_formation", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>database.formations.type_en</code>.
     */
    public final TableField<FormationsRecord, String> TYPE_EN = createField("type_en", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>database.formations.type_es</code>.
     */
    public final TableField<FormationsRecord, String> TYPE_ES = createField("type_es", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>database.formations.type_fr</code>.
     */
    public final TableField<FormationsRecord, String> TYPE_FR = createField("type_fr", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>database.formations.type_it</code>.
     */
    public final TableField<FormationsRecord, String> TYPE_IT = createField("type_it", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>database.formations.type_de</code>.
     */
    public final TableField<FormationsRecord, String> TYPE_DE = createField("type_de", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>database.formations.type_por</code>.
     */
    public final TableField<FormationsRecord, String> TYPE_POR = createField("type_por", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * Create a <code>database.formations</code> table reference
     */
    public Formations() {
        this(DSL.name("formations"), null);
    }

    /**
     * Create an aliased <code>database.formations</code> table reference
     */
    public Formations(String alias) {
        this(DSL.name(alias), FORMATIONS);
    }

    /**
     * Create an aliased <code>database.formations</code> table reference
     */
    public Formations(Name alias) {
        this(alias, FORMATIONS);
    }

    private Formations(Name alias, Table<FormationsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Formations(Name alias, Table<FormationsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Formations(Table<O> child, ForeignKey<O, FormationsRecord> key) {
        super(child, key, FORMATIONS);
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
        return Arrays.<Index>asList(Indexes.FORMATIONS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<FormationsRecord> getPrimaryKey() {
        return Keys.KEY_FORMATIONS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<FormationsRecord>> getKeys() {
        return Arrays.<UniqueKey<FormationsRecord>>asList(Keys.KEY_FORMATIONS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Formations as(String alias) {
        return new Formations(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Formations as(Name alias) {
        return new Formations(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Formations rename(String name) {
        return new Formations(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Formations rename(Name name) {
        return new Formations(name, null);
    }
}