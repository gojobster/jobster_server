package com.talendorse.server.rest;

import com.talendorse.server.BLL.OffersManagement;
import com.talendorse.server.BLL.TalendorseException;
import com.talendorse.server.BLL.UserManagement;
import com.talendorse.server.DTO.RespuestaWS;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/{saveOffer : (?i)saveOffer}")
public class EditOffer {
    @Context
    private UriInfo uriInfo;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<String> saveOffer(@Context HttpHeaders httpheaders,
            @FormParam("idOffer") Integer idOffer,
            @FormParam("position") String position,
            @FormParam("summary") String summary,
            @FormParam("jobFunctions") String jobFunctions,
            @FormParam("country") String country,
            @FormParam("city") String city,
            @FormParam("experience") Integer experience,
            @FormParam("stateOffer") Integer stateOffer,
            @FormParam("contractType") Integer contractType,
            @FormParam("workingDayType") Integer workingDayType,
            @FormParam("priority") Integer priority,
            @FormParam("maxSalary") Integer maxSalary,
            @FormParam("minSalary") Integer minSalary,
            @FormParam("reward") Integer reward,
            @FormParam("dateIni") String dateIni,
            @FormParam("dateEnd") String dateEnd){
        RespuestaWS<String> respuestaWS = new RespuestaWS<>();
        int error = -1;
        String errorString = "";
        try {
            String token = httpheaders.getHeaderString("Authorization");
            UserManagement.check_AdminToken(token);

            respuestaWS.responseStatus = 200;
            respuestaWS.message = OffersManagement.saveOffer(idOffer, position, summary, jobFunctions,
                    country, city, experience, stateOffer, workingDayType, priority, maxSalary, minSalary, reward, dateIni, dateEnd);
            respuestaWS.error = "";
            return  respuestaWS;
        } catch (TalendorseException ex) {
            error = ex.getErrorNumber();
            errorString = ex.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        respuestaWS.responseStatus = error;
        respuestaWS.message = null;
        respuestaWS.error = errorString;
        return respuestaWS;
    }
}
