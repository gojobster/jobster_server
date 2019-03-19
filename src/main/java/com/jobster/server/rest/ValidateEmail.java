package com.jobster.server.rest;

import com.jobster.server.BLL.JobsterException;
import com.jobster.server.BLL.SkillsManagement;
import com.jobster.server.BLL.UserManagement;
import com.jobster.server.DTO.RespuestaWS;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/{validateEmail : (?i)validateEmail}")
public class ValidateEmail {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<String> validateEmail(@FormParam("idUser") int id_usuario){
        RespuestaWS<String> respuestaWS = new RespuestaWS<>();
        try {
            respuestaWS.responseStatus = 200;
            respuestaWS.message = UserManagement.validateEmail(id_usuario);
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
