package com.jobster.server.rest;

import com.jobster.server.BLL.JobsterException;
import com.jobster.server.BLL.OffersManagement;
import com.jobster.server.DTO.RespuestaWS;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/{addOffer : (?i)addOffer}")
public class OffersService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<String> addOffer(
        @FormParam("position") String position,
        @FormParam("summary") String summary,
        @FormParam("experience") String experience,
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
        } catch (JobsterException ex) {
            respuestaWS.responseStatus = ex.getErrorNumber();
            respuestaWS.message = null;
            respuestaWS.error = ex.getMessage();
            return respuestaWS;
        }

    }

}
