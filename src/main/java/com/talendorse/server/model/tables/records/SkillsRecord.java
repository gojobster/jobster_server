/*
 * This file is generated by jOOQ.
 */
package com.talendorse.server.model.tables.records;


import com.talendorse.server.model.tables.Skills;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class SkillsRecord extends UpdatableRecordImpl<SkillsRecord> implements Record4<Integer, String, Timestamp, Integer> {

    private static final long serialVersionUID = -349848238;

    /**
     * Setter for <code>database.skills.id_skill</code>.
     */
    public void setIdSkill(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>database.skills.id_skill</code>.
     */
    public Integer getIdSkill() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>database.skills.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>database.skills.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>database.skills.date_created</code>.
     */
    public void setDateCreated(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>database.skills.date_created</code>.
     */
    public Timestamp getDateCreated() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>database.skills.num_validations</code>.
     */
    public void setNumValidations(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>database.skills.num_validations</code>.
     */
    public Integer getNumValidations() {
        return (Integer) get(3);
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, Timestamp, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, Timestamp, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Skills.SKILLS.ID_SKILL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Skills.SKILLS.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Skills.SKILLS.DATE_CREATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Skills.SKILLS.NUM_VALIDATIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getIdSkill();
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
    public Timestamp component3() {
        return getDateCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getNumValidations();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdSkill();
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
    public Timestamp value3() {
        return getDateCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getNumValidations();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SkillsRecord value1(Integer value) {
        setIdSkill(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SkillsRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SkillsRecord value3(Timestamp value) {
        setDateCreated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SkillsRecord value4(Integer value) {
        setNumValidations(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SkillsRecord values(Integer value1, String value2, Timestamp value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SkillsRecord
     */
    public SkillsRecord() {
        super(Skills.SKILLS);
    }

    /**
     * Create a detached, initialised SkillsRecord
     */
    public SkillsRecord(Integer idSkill, String name, Timestamp dateCreated, Integer numValidations) {
        super(Skills.SKILLS);

        set(0, idSkill);
        set(1, name);
        set(2, dateCreated);
        set(3, numValidations);
    }
}
