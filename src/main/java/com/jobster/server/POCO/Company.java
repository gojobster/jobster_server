package com.jobster.server.POCO;

import com.jobster.server.model.tables.records.CompaniesRecord;

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
        this.country = country;
    }
}
