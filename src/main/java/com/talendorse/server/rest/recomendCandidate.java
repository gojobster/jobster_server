package com.talendorse.server.rest;

import com.talendorse.server.BLL.RecomendationsManagement;
import com.talendorse.server.BLL.TalendorseException;
import com.talendorse.server.BLL.UserManagement;
import com.talendorse.server.DTO.RespuestaWS;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/{recomend : (?i)recomend}")
public class recomendCandidate {
    @Context
    private UriInfo uriInfo;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<String> validateEmail(
            @FormParam("id_endorser") Integer id_endorser,
            @FormParam("id_offer") Integer id_offer,
            @FormParam("email_candidate") String email_candidate){
        RespuestaWS<String> respuestaWS = new RespuestaWS<>();
        try {
            String urlPlatform = uriInfo.getBaseUri().toString().replace("ws/","");
            respuestaWS.responseStatus = 200;
            respuestaWS.message = RecomendationsManagement.sendRecomendatioToCandidate(urlPlatform, id_endorser, id_offer, email_candidate);
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
