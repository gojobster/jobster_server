/*
 * This file is generated by jOOQ.
 */
package com.jobster.server.model.tables.records;


import com.jobster.server.model.tables.OffersSkills;

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
public class OffersSkillsRecord extends UpdatableRecordImpl<OffersSkillsRecord> implements Record3<Integer, Integer, Integer> {

    private static final long serialVersionUID = 914912042;

    /**
     * Setter for <code>jobster.offers_skills.id_offer_skill</code>.
     */
    public void setIdOfferSkill(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>jobster.offers_skills.id_offer_skill</code>.
     */
    public Integer getIdOfferSkill() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>jobster.offers_skills.id_skill</code>.
     */
    public void setIdSkill(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>jobster.offers_skills.id_skill</code>.
     */
    public Integer getIdSkill() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>jobster.offers_skills.id_offer</code>.
     */
    public void setIdOffer(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>jobster.offers_skills.id_offer</code>.
     */
    public Integer getIdOffer() {
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
        return OffersSkills.OFFERS_SKILLS.ID_OFFER_SKILL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return OffersSkills.OFFERS_SKILLS.ID_SKILL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return OffersSkills.OFFERS_SKILLS.ID_OFFER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getIdOfferSkill();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getIdSkill();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getIdOffer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdOfferSkill();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getIdSkill();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getIdOffer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersSkillsRecord value1(Integer value) {
        setIdOfferSkill(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersSkillsRecord value2(Integer value) {
        setIdSkill(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersSkillsRecord value3(Integer value) {
        setIdOffer(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersSkillsRecord values(Integer value1, Integer value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OffersSkillsRecord
     */
    public OffersSkillsRecord() {
        super(OffersSkills.OFFERS_SKILLS);
    }

    /**
     * Create a detached, initialised OffersSkillsRecord
     */
    public OffersSkillsRecord(Integer idOfferSkill, Integer idSkill, Integer idOffer) {
        super(OffersSkills.OFFERS_SKILLS);

        set(0, idOfferSkill);
        set(1, idSkill);
        set(2, idOffer);
    }
}