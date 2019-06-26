package com.talendorse.server.rest;

import com.talendorse.server.BLL.TalendorseException;
import com.talendorse.server.BLL.OffersManagement;
import com.talendorse.server.DTO.RespuestaWS;
import com.talendorse.server.DTO.RespuestaWSOffer;
import com.talendorse.server.util.Util;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/{getAllFilteredOffers : (?i)getAllFilteredOffers}")
public class GetAllFilteredOffers {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<List<RespuestaWSOffer>> getAllFilteredOffers(
            @Context HttpHeaders httpheaders,
            @FormParam("keyword") String keyword,
            @FormParam("salary") int salary,
            @FormParam("experience") int experience,
            @FormParam("positions") List<String> positions,
            @FormParam("cities") List<String> cities,
            @FormParam("pageSize") int pageSize,
            @FormParam("numPage") int numPage){
        RespuestaWS<List<RespuestaWSOffer>> respuestaWS = new RespuestaWS<>();
        try {
            Util.check_token(httpheaders);
            respuestaWS.responseStatus = 200;
            respuestaWS.message = OffersManagement.getAllFilteredOffers(keyword,salary,experience,positions,cities, pageSize, numPage);
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