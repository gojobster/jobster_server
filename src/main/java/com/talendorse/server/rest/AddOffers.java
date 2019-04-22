package com.talendorse.server.rest;

import com.talendorse.server.BLL.TalendorseException;
import com.talendorse.server.BLL.OffersManagement;
import com.talendorse.server.DTO.RespuestaWS;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/{addOffer : (?i)addOffer}")
public class AddOffers {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<String> addOffer(
        @FormParam("position") String position,
        @FormParam("summary") String summary,
        @FormParam("experience") int experience,
        @FormParam("job_functions") String job_functions,
        @FormParam("date_init") String date_init,
        @FormParam("date_end") String date_end
    ){
        RespuestaWS<String> respuestaWS = new RespuestaWS<>();
        try {
            respuestaWS.responseStatus = 200;
            respuestaWS.message = OffersManagement.addOffer(position, summary, experience, job_functions, date_init, date_end);
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
