package com.talendorse.server.DTO;

import java.util.ArrayList;
import java.util.List;

public class RespuestaWSOfferFilters {
    public int min_salary;
    public int max_salary;
    public int max_experience;
    public List<String> list_studies;
    public List<RespuestaWSOfferCity> list_cities;// = new ArrayList<RespuestaWSOfferCity>();

    public RespuestaWSOfferFilters(Integer min_salary, Integer max_salary, Integer max_experience, List<String> list_studies, List<RespuestaWSOfferCity> list_cities) {
        this.min_salary = min_salary;
        this.max_salary = max_salary;
        this.max_experience = max_experience;
        this.list_studies = list_studies;
        this.list_cities = list_cities;
    }

    public RespuestaWSOfferFilters() {
        this.min_salary = 0;
        this.max_salary = 0;
        this.max_experience = 0;
        this.list_studies = new ArrayList<>();
        this.list_cities = new ArrayList<>();
    }
}