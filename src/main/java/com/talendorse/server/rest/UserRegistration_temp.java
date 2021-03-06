package com.talendorse.server.rest;

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
            String urlPlatform = uriInfo.getBaseUri().toString().replace("ws/","");
            respuestaWS.responseStatus = 200;
            respuestaWS.message = UserManagement.insertarUsuario_temp(name, surname, password, gender, email, urlPlatform);
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
