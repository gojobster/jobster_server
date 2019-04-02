package com.jobster.server.DTO;

public class RespuestaWSOfferCity {
    public String name;
    public int num_instances;
    public String id;

    public RespuestaWSOfferCity(String name, int num_instances) {
        this.name = name;
        this.num_instances = num_instances;
        this.id = "city_" + name.trim().toLowerCase().replaceAll("\\s+","_");
    }
}