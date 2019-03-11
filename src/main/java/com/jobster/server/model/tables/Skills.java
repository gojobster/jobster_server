/*
 * This file is generated by jOOQ.
 */
package com.jobster.server.model.tables;


import com.jobster.server.model.Indexes;
import com.jobster.server.model.Jobster;
import com.jobster.server.model.Keys;
import com.jobster.server.model.tables.records.SkillsRecord;

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
public class Skills extends TableImpl<SkillsRecord> {

    private static final long serialVersionUID = 2112486690;

    /**
     * The reference instance of <code>jobster.skills</code>
     */
    public static final Skills SKILLS = new Skills();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SkillsRecord> getRecordType() {
        return SkillsRecord.class;
    }

    /**
     * The column <code>jobster.skills.id_skill</code>.
     */
    public final TableField<SkillsRecord, Integer> ID_SKILL = createField("id_skill", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>jobster.skills.name</code>.
     */
    public final TableField<SkillsRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>jobster.skills.date_created</code>.
     */
    public final TableField<SkillsRecord, Timestamp> DATE_CREATED = createField("date_created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>jobster.skills</code> table reference
     */
    public Skills() {
        this(DSL.name("skills"), null);
    }

    /**
     * Create an aliased <code>jobster.skills</code> table reference
     */
    public Skills(String alias) {
        this(DSL.name(alias), SKILLS);
    }

    /**
     * Create an aliased <code>jobster.skills</code> table reference
     */
    public Skills(Name alias) {
        this(alias, SKILLS);
    }

    private Skills(Name alias, Table<SkillsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Skills(Name alias, Table<SkillsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Skills(Table<O> child, ForeignKey<O, SkillsRecord> key) {
        super(child, key, SKILLS);
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
        return Arrays.<Index>asList(Indexes.SKILLS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<SkillsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SKILLS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SkillsRecord> getPrimaryKey() {
        return Keys.KEY_SKILLS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SkillsRecord>> getKeys() {
        return Arrays.<UniqueKey<SkillsRecord>>asList(Keys.KEY_SKILLS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Skills as(String alias) {
        return new Skills(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Skills as(Name alias) {
        return new Skills(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Skills rename(String name) {
        return new Skills(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Skills rename(Name name) {
        return new Skills(name, null);
    }
}
