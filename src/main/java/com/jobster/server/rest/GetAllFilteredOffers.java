package com.jobster.server.rest;

import com.jobster.server.BLL.JobsterException;
import com.jobster.server.BLL.OffersManagement;
import com.jobster.server.DTO.RespuestaWS;
import com.jobster.server.DTO.RespuestaWSOffer;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/{getAllFilteredOffers : (?i)getAllFilteredOffers}")
public class GetAllFilteredOffers {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<List<RespuestaWSOffer>> getAllFilteredOffers(
            @FormParam("keyword") String keyword,
            @FormParam("salary") int salary,
            @FormParam("experience") int experience,
            @FormParam("positions") List<String> positions,
            @FormParam("cities") List<String> cities){
        RespuestaWS<List<RespuestaWSOffer>> respuestaWS = new RespuestaWS<>();
        try {
            respuestaWS.responseStatus = 200;
            respuestaWS.message = OffersManagement.getAllFilteredOffers(keyword,salary,experience,positions,cities);
            respuestaWS.error = "";
            return  respuestaWS;
        } catch (JobsterException ex) {
            respuestaWS.responseStatus = ex.getErrorNumber();
            respuestaWS.message = null;
            respuestaWS.error = ex.getMessage();
            return respuestaWS;
        }
    }
}