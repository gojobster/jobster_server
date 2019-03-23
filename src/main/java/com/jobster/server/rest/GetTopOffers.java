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

@Path("/{getTopOffers : (?i)getTopOffers}")
public class GetTopOffers {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<List<RespuestaWSOffer>> getTopOffers(){
        RespuestaWS<List<RespuestaWSOffer>> respuestaWS = new RespuestaWS<>();
        try {
            respuestaWS.responseStatus = 200;
            respuestaWS.message = OffersManagement.getTopOffers();
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