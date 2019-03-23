/*
 * This file is generated by jOOQ.
 */
package com.jobster.server.model.tables.records;


import com.jobster.server.model.tables.Offers;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record18;
import org.jooq.Row18;
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
public class OffersRecord extends UpdatableRecordImpl<OffersRecord> implements Record18<Integer, Integer, String, String, Integer, String, String, String, Integer, Integer, Integer, Integer, Integer, Integer, Timestamp, Timestamp, Timestamp, Integer> {

    private static final long serialVersionUID = -774957922;

    /**
     * Setter for <code>jobster.offers.id_offer</code>.
     */
    public void setIdOffer(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>jobster.offers.id_offer</code>.
     */
    public Integer getIdOffer() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>jobster.offers.id_company</code>.
     */
    public void setIdCompany(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>jobster.offers.id_company</code>.
     */
    public Integer getIdCompany() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>jobster.offers.position</code>.
     */
    public void setPosition(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>jobster.offers.position</code>.
     */
    public String getPosition() {
        return (String) get(2);
    }

    /**
     * Setter for <code>jobster.offers.summary</code>.
     */
    public void setSummary(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>jobster.offers.summary</code>.
     */
    public String getSummary() {
        return (String) get(3);
    }

    /**
     * Setter for <code>jobster.offers.experience</code>.
     */
    public void setExperience(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>jobster.offers.experience</code>.
     */
    public Integer getExperience() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>jobster.offers.job_functions</code>.
     */
    public void setJobFunctions(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>jobster.offers.job_functions</code>.
     */
    public String getJobFunctions() {
        return (String) get(5);
    }

    /**
     * Setter for <code>jobster.offers.city</code>.
     */
    public void setCity(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>jobster.offers.city</code>.
     */
    public String getCity() {
        return (String) get(6);
    }

    /**
     * Setter for <code>jobster.offers.country</code>.
     */
    public void setCountry(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>jobster.offers.country</code>.
     */
    public String getCountry() {
        return (String) get(7);
    }

    /**
     * Setter for <code>jobster.offers.tipo_jornada</code>. Tipo de oferta: temporal, media jornada, jornada completa
Tipo de jornada:
1 -  por horas             
2 -  media jornada      
3 -  jornada completa 
     */
    public void setTipoJornada(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>jobster.offers.tipo_jornada</code>. Tipo de oferta: temporal, media jornada, jornada completa
Tipo de jornada:
1 -  por horas             
2 -  media jornada      
3 -  jornada completa 
     */
    public Integer getTipoJornada() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>jobster.offers.tipo_contrato</code>. Tipo de contrato:
 - tiempo parcial      1
 - tiempo indefinido 2
     */
    public void setTipoContrato(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>jobster.offers.tipo_contrato</code>. Tipo de contrato:
 - tiempo parcial      1
 - tiempo indefinido 2
     */
    public Integer getTipoContrato() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>jobster.offers.hours</code>.
     */
    public void setHours(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>jobster.offers.hours</code>.
     */
    public Integer getHours() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>jobster.offers.salary_min</code>.
     */
    public void setSalaryMin(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>jobster.offers.salary_min</code>.
     */
    public Integer getSalaryMin() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>jobster.offers.salary_max</code>.
     */
    public void setSalaryMax(Integer value) {
        set(12, value);
    }

    /**
     * Getter for <code>jobster.offers.salary_max</code>.
     */
    public Integer getSalaryMax() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>jobster.offers.reward</code>.
     */
    public void setReward(Integer value) {
        set(13, value);
    }

    /**
     * Getter for <code>jobster.offers.reward</code>.
     */
    public Integer getReward() {
        return (Integer) get(13);
    }

    /**
     * Setter for <code>jobster.offers.date_init</code>.
     */
    public void setDateInit(Timestamp value) {
        set(14, value);
    }

    /**
     * Getter for <code>jobster.offers.date_init</code>.
     */
    public Timestamp getDateInit() {
        return (Timestamp) get(14);
    }

    /**
     * Setter for <code>jobster.offers.date_created</code>.
     */
    public void setDateCreated(Timestamp value) {
        set(15, value);
    }

    /**
     * Getter for <code>jobster.offers.date_created</code>.
     */
    public Timestamp getDateCreated() {
        return (Timestamp) get(15);
    }

    /**
     * Setter for <code>jobster.offers.date_end</code>.
     */
    public void setDateEnd(Timestamp value) {
        set(16, value);
    }

    /**
     * Getter for <code>jobster.offers.date_end</code>.
     */
    public Timestamp getDateEnd() {
        return (Timestamp) get(16);
    }

    /**
     * Setter for <code>jobster.offers.people_in_charge</code>.
     */
    public void setPeopleInCharge(Integer value) {
        set(17, value);
    }

    /**
     * Getter for <code>jobster.offers.people_in_charge</code>.
     */
    public Integer getPeopleInCharge() {
        return (Integer) get(17);
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
    // Record18 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<Integer, Integer, String, String, Integer, String, String, String, Integer, Integer, Integer, Integer, Integer, Integer, Timestamp, Timestamp, Timestamp, Integer> fieldsRow() {
        return (Row18) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<Integer, Integer, String, String, Integer, String, String, String, Integer, Integer, Integer, Integer, Integer, Integer, Timestamp, Timestamp, Timestamp, Integer> valuesRow() {
        return (Row18) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Offers.OFFERS.ID_OFFER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Offers.OFFERS.ID_COMPANY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Offers.OFFERS.POSITION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Offers.OFFERS.SUMMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Offers.OFFERS.EXPERIENCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Offers.OFFERS.JOB_FUNCTIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Offers.OFFERS.CITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Offers.OFFERS.COUNTRY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return Offers.OFFERS.TIPO_JORNADA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field10() {
        return Offers.OFFERS.TIPO_CONTRATO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field11() {
        return Offers.OFFERS.HOURS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field12() {
        return Offers.OFFERS.SALARY_MIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field13() {
        return Offers.OFFERS.SALARY_MAX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field14() {
        return Offers.OFFERS.REWARD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field15() {
        return Offers.OFFERS.DATE_INIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field16() {
        return Offers.OFFERS.DATE_CREATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field17() {
        return Offers.OFFERS.DATE_END;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field18() {
        return Offers.OFFERS.PEOPLE_IN_CHARGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getIdOffer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getIdCompany();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getPosition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getSummary();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getExperience();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getJobFunctions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getCity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getCountry();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component9() {
        return getTipoJornada();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component10() {
        return getTipoContrato();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component11() {
        return getHours();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component12() {
        return getSalaryMin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component13() {
        return getSalaryMax();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component14() {
        return getReward();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component15() {
        return getDateInit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component16() {
        return getDateCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component17() {
        return getDateEnd();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component18() {
        return getPeopleInCharge();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdOffer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getIdCompany();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPosition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getSummary();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getExperience();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getJobFunctions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getCity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getCountry();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getTipoJornada();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value10() {
        return getTipoContrato();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value11() {
        return getHours();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value12() {
        return getSalaryMin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value13() {
        return getSalaryMax();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value14() {
        return getReward();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value15() {
        return getDateInit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value16() {
        return getDateCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value17() {
        return getDateEnd();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value18() {
        return getPeopleInCharge();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value1(Integer value) {
        setIdOffer(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value2(Integer value) {
        setIdCompany(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value3(String value) {
        setPosition(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value4(String value) {
        setSummary(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value5(Integer value) {
        setExperience(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value6(String value) {
        setJobFunctions(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value7(String value) {
        setCity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value8(String value) {
        setCountry(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value9(Integer value) {
        setTipoJornada(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value10(Integer value) {
        setTipoContrato(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value11(Integer value) {
        setHours(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value12(Integer value) {
        setSalaryMin(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value13(Integer value) {
        setSalaryMax(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value14(Integer value) {
        setReward(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value15(Timestamp value) {
        setDateInit(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value16(Timestamp value) {
        setDateCreated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value17(Timestamp value) {
        setDateEnd(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord value18(Integer value) {
        setPeopleInCharge(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffersRecord values(Integer value1, Integer value2, String value3, String value4, Integer value5, String value6, String value7, String value8, Integer value9, Integer value10, Integer value11, Integer value12, Integer value13, Integer value14, Timestamp value15, Timestamp value16, Timestamp value17, Integer value18) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OffersRecord
     */
    public OffersRecord() {
        super(Offers.OFFERS);
    }

    /**
     * Create a detached, initialised OffersRecord
     */
    public OffersRecord(Integer idOffer, Integer idCompany, String position, String summary, Integer experience, String jobFunctions, String city, String country, Integer tipoJornada, Integer tipoContrato, Integer hours, Integer salaryMin, Integer salaryMax, Integer reward, Timestamp dateInit, Timestamp dateCreated, Timestamp dateEnd, Integer peopleInCharge) {
        super(Offers.OFFERS);

        set(0, idOffer);
        set(1, idCompany);
        set(2, position);
        set(3, summary);
        set(4, experience);
        set(5, jobFunctions);
        set(6, city);
        set(7, country);
        set(8, tipoJornada);
        set(9, tipoContrato);
        set(10, hours);
        set(11, salaryMin);
        set(12, salaryMax);
        set(13, reward);
        set(14, dateInit);
        set(15, dateCreated);
        set(16, dateEnd);
        set(17, peopleInCharge);
    }
}
