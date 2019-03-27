package com.jobster.server.rest;

import com.jobster.server.BLL.JobsterException;
import com.jobster.server.BLL.UserManagement;
import com.jobster.server.DTO.RespuestaWS;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/{register_temp : (?i)register_temp}")
public class UserRegistration_temp {
    @Context
    private UriInfo uriInfo;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<String> register_temp(
            @FormParam("name") String name,
            @FormParam("surname") String surname,
            @FormParam("password") String password,
            @FormParam("gender") String gender,
            @FormParam("email") String email){
        RespuestaWS<String> respuestaWS = new RespuestaWS<>();
        try {
            respuestaWS.responseStatus = 200;
            respuestaWS.message = UserManagement.insertarUsuario_temp(name, surname, password, gender, email, uriInfo.getBaseUri().toString());
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
