package com.talendorse.server.POCO;

import com.talendorse.server.model.tables.records.CompaniesRecord;
import com.talendorse.server.model.tables.records.OffersRecord;
import com.talendorse.server.util.Fechas;
import com.talendorse.server.util.Util;

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
    public Integer tipo_jornadaInt;
    public String tipo_contrato;
    public Integer tipo_contratoInt;
    public Integer hours;
    public Integer state;
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
    public Integer time_from_start;
    public Integer time_to_end;
    public String date_start_string;
    public String date_end_string;

    public Offer(OffersRecord offer, CompaniesRecord company, int applications) {
        this.idOffer = offer.getIdOffer();
        this.idCompany = offer.getIdCompany();
        this.position = offer.getPosition();
        this.summary = offer.getSummary();
        this.experience_years = offer.getExperience();
        this.job_functions = offer.getJobFunctions();
        this.people_in_charge = offer.getPeopleInCharge();

        this.state = offer.getState();
        this.tipo_contratoInt = offer.getTipoContrato();
        this.tipo_contrato = Util.getContractTypeString(offer.getTipoContrato());
        this.tipo_jornadaInt = offer.getTipoJornada();
        this.tipo_jornada = Util.getJornadaTypeString(offer.getTipoJornada());

        this.hours = offer.getHours();
        this.salary_min = offer.getSalaryMin();
        this.salary_max = offer.getSalaryMax();
        this.reward = offer.getReward();
        this.proprity = offer.getPriority();
        this.displayed = 15;    //TODO: obtener de la oferta;
        this.applications = applications;
        this.city = offer.getCity();
        this.country = offer.getCountry();
        this.date_ini = offer.getDateInit();
        this.date_end = offer.getDateEnd();
        this.time_from_start = Fechas.daysFromNow(offer.getDateInit());
        this.time_to_end = Fechas.daysFromNow(offer.getDateEnd());
        this.date_start_string = Fechas.getDateStringFromTimeStamp(offer.getDateInit());
        this.date_end_string = Fechas.getDateStringFromTimeStamp(offer.getDateEnd());

        this.idCompany = company.getIdCompany();
        this.nameCompany = company.getName();
        this.path_image_company = company.getPathImg();
    }
}
