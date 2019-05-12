package com.talendorse.server.rest;

import com.talendorse.server.BLL.TalendorseException;
import com.talendorse.server.BLL.UserManagement;
import com.talendorse.server.DTO.RespuestaWS;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/{email : (?i)email}")
public class SendEmails {
    @POST
    @Path("/{activation_es}")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<String> validateEmail(@FormParam("token") String token){
        RespuestaWS<String> respuestaWS = new RespuestaWS<>();
        try {
            respuestaWS.responseStatus = 200;
            respuestaWS.message = UserManagement.validateEmail(token);
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
