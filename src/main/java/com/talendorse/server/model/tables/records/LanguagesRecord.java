/*
 * This file is generated by jOOQ.
 */
package com.talendorse.server.model.tables.records;


import com.talendorse.server.model.tables.Languages;

import java.sql.Timestamp;

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
public class LanguagesRecord extends UpdatableRecordImpl<LanguagesRecord> implements Record3<Integer, String, Timestamp> {

    private static final long serialVersionUID = -1181198383;

    /**
     * Setter for <code>database.languages.id_language</code>.
     */
    public void setIdLanguage(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>database.languages.id_language</code>.
     */
    public Integer getIdLanguage() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>database.languages.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>database.languages.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>database.languages.date_created</code>.
     */
    public void setDateCreated(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>database.languages.date_created</code>.
     */
    public Timestamp getDateCreated() {
        return (Timestamp) get(2);
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
    public Row3<Integer, String, Timestamp> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, Timestamp> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Languages.LANGUAGES.ID_LANGUAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Languages.LANGUAGES.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Languages.LANGUAGES.DATE_CREATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getIdLanguage();
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
    public Integer value1() {
        return getIdLanguage();
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
    public LanguagesRecord value1(Integer value) {
        setIdLanguage(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LanguagesRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LanguagesRecord value3(Timestamp value) {
        setDateCreated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LanguagesRecord values(Integer value1, String value2, Timestamp value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LanguagesRecord
     */
    public LanguagesRecord() {
        super(Languages.LANGUAGES);
    }

    /**
     * Create a detached, initialised LanguagesRecord
     */
    public LanguagesRecord(Integer idLanguage, String name, Timestamp dateCreated) {
        super(Languages.LANGUAGES);

        set(0, idLanguage);
        set(1, name);
        set(2, dateCreated);
    }
}