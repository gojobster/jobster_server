package com.talendorse.server.POCO;

import com.talendorse.server.model.tables.records.CompaniesRecord;

import java.math.BigDecimal;

public class Company {
    public int idCompany;
    public String name;
    public String description;
    public String pathImg;
    public String website;
    public String phone;
    public String email;
    public String adress;
    public String city;
    public String country;
    public BigDecimal latitude;
    public BigDecimal longitude;

    public Company(CompaniesRecord company, String country) {
        this.idCompany = company.getIdCompany();
        this.name = company.getName();
        this.description = company.getDescription();
        this.pathImg = company.getPathImg();
        this.website = company.getWebsite();
        this.phone = company.getPhone();
        this.email = company.getEmail();
        this.adress = company.getAdress();
        this.city = company.getCity();
        this.latitude = company.getLatitude();
        this.longitude = company.getLongitude();
        this.country = country;
    }
}
