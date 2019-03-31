package com.jobster.server.POCO;

import com.jobster.server.model.tables.records.CompaniesRecord;
import com.jobster.server.model.tables.records.OffersRecord;
import com.jobster.server.util.Util;
import org.joda.time.DateTime;

import java.sql.Timestamp;

public class Offer {
    public int idOffer;
    public int idCompany;
    public String nameCompany;
    public String path_image_company;
    public String position;
    public String summary;
    public Integer experience_years;
    public String job_functions;
    public Integer people_in_charge;
    public String tipo_jornada;
    public String tipo_contrato;
    public Integer hours;
    public Integer salary_min;
    public Integer salary_max;
    public Integer reward;
    public Integer proprity;
    public Integer displayed;
    public Integer applications;
    public String city;
    public String country;
    public Timestamp date_ini;
    public Timestamp date_end;

    public Offer(OffersRecord offer, CompaniesRecord company) {
        this.idCompany = offer.getIdCompany();
        this.position = offer.getPosition();
        this.summary = offer.getSummary();
        this.experience_years = offer.getExperience();
        this.job_functions = offer.getJobFunctions();
        this.people_in_charge = offer.getPeopleInCharge();

        this.tipo_contrato = Util.getContractTypeString(offer.getTipoContrato());
        this.tipo_jornada = Util.getJornadaTypeString(offer.getTipoJornada());

        this.hours = offer.getHours();
        this.salary_min = offer.getSalaryMin();
        this.salary_max = offer.getSalaryMax();
        this.reward = offer.getReward();
        this.proprity = offer.getPriority();
        this.displayed = 15;    //TODO: obtener de la oferta;
        this.applications = 5;  //TODO: obtener de la oferta;
        this.city = offer.getCity();
        this.country = offer.getCountry();
        this.date_ini = offer.getDateInit();
        this.date_end = offer.getDateEnd();

        this.idCompany = company.getIdCompany();
        this.nameCompany = company.getName();
        this.path_image_company = company.getPathImg();
    }
}
