package com.talendorse.server.rest;

import com.talendorse.server.BLL.TalendorseException;
import com.talendorse.server.BLL.OffersManagement;
import com.talendorse.server.DTO.RespuestaWS;
import com.talendorse.server.DTO.RespuestaWSOffer;
import com.talendorse.server.util.Util;
import org.jooq.tools.json.JSONParser;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.*;

import org.json.*;

@Path("/{getAllFilteredOffers : (?i)getAllFilteredOffers}")
public class GetAllFilteredOffers {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<List<RespuestaWSOffer>> getAllFilteredOffers(
            @Context HttpHeaders httpheaders,
            @FormParam("keyword") String keyword,
            @FormParam("salary") int salary,
            @FormParam("experience") int experience,
            @FormParam("positions") String positions,
            @FormParam("cities") String cities,
            @FormParam("pageSize") int pageSize,
            @FormParam("numPage") int numPage,
            @FormParam("order") String order){
        RespuestaWS<List<RespuestaWSOffer>> respuestaWS = new RespuestaWS<>();
        try {
            //Util.check_token(httpheaders);
            JSONArray tmpCities = new JSONArray(cities);
            JSONArray tmpPositions = new JSONArray(positions);
            List<String> citiesList = new ArrayList<>();
            List<String> positionsList = new ArrayList<>();
            for (Object city: tmpCities) {
                citiesList.add(city.toString());
            }
            for (Object position: tmpPositions) {
                positionsList.add(position.toString());
            }

            respuestaWS.responseStatus = 200;
            respuestaWS.message = OffersManagement.getAllFilteredOffers(keyword,salary,experience,positionsList,citiesList, pageSize, numPage, order);
            respuestaWS.error = "";
            return  respuestaWS;
        } catch (TalendorseException ex) {
            respuestaWS.responseStatus = ex.getErrorNumber();
            respuestaWS.message = null;
            respuestaWS.error = ex.getMessage();
            return respuestaWS;
        }
    }
}