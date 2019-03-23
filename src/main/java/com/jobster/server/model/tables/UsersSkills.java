/*
 * This file is generated by jOOQ.
 */
package com.jobster.server.model.tables;


import com.jobster.server.model.Indexes;
import com.jobster.server.model.Jobster;
import com.jobster.server.model.Keys;
import com.jobster.server.model.tables.records.UsersSkillsRecord;

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
public class UsersSkills extends TableImpl<UsersSkillsRecord> {

    private static final long serialVersionUID = 1348328887;

    /**
     * The reference instance of <code>jobster.users_skills</code>
     */
    public static final UsersSkills USERS_SKILLS = new UsersSkills();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsersSkillsRecord> getRecordType() {
        return UsersSkillsRecord.class;
    }

    /**
     * The column <code>jobster.users_skills.id_user_skill</code>.
     */
    public final TableField<UsersSkillsRecord, Integer> ID_USER_SKILL = createField("id_user_skill", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>jobster.users_skills.id_user</code>.
     */
    public final TableField<UsersSkillsRecord, Integer> ID_USER = createField("id_user", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>jobster.users_skills.id_skill</code>.
     */
    public final TableField<UsersSkillsRecord, Integer> ID_SKILL = createField("id_skill", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>jobster.users_skills</code> table reference
     */
    public UsersSkills() {
        this(DSL.name("users_skills"), null);
    }

    /**
     * Create an aliased <code>jobster.users_skills</code> table reference
     */
    public UsersSkills(String alias) {
        this(DSL.name(alias), USERS_SKILLS);
    }

    /**
     * Create an aliased <code>jobster.users_skills</code> table reference
     */
    public UsersSkills(Name alias) {
        this(alias, USERS_SKILLS);
    }

    private UsersSkills(Name alias, Table<UsersSkillsRecord> aliased) {
        this(alias, aliased, null);
    }

    private UsersSkills(Name alias, Table<UsersSkillsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> UsersSkills(Table<O> child, ForeignKey<O, UsersSkillsRecord> key) {
        super(child, key, USERS_SKILLS);
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
        return Arrays.<Index>asList(Indexes.USERS_SKILLS_PRIMARY, Indexes.USERS_SKILLS_SKILL_USER_IDX, Indexes.USERS_SKILLS_USERS_SKILLS_SKILL_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<UsersSkillsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_USERS_SKILLS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UsersSkillsRecord> getPrimaryKey() {
        return Keys.KEY_USERS_SKILLS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UsersSkillsRecord>> getKeys() {
        return Arrays.<UniqueKey<UsersSkillsRecord>>asList(Keys.KEY_USERS_SKILLS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<UsersSkillsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UsersSkillsRecord, ?>>asList(Keys.FK_USERS_SKILLS_USER, Keys.KF_USERS_SKILLS_SKILL);
    }

    public Users users() {
        return new Users(this, Keys.FK_USERS_SKILLS_USER);
    }

    public Skills skills() {
        return new Skills(this, Keys.KF_USERS_SKILLS_SKILL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSkills as(String alias) {
        return new UsersSkills(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSkills as(Name alias) {
        return new UsersSkills(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UsersSkills rename(String name) {
        return new UsersSkills(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UsersSkills rename(Name name) {
        return new UsersSkills(name, null);
    }
}
