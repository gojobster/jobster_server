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

@Path("/{register : (?i)register}")
public class UserRegistration {
    @Context
    private UriInfo uriInfo;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<String> registrarUsuario(
            @FormParam("email") String email,
            @FormParam("password") String password,
            @FormParam("name") String name,
            @FormParam("surname") String surname,
            @FormParam("birthday") String birthday,
            @FormParam("gender") String gender,
            @FormParam("salt") String salt,
            @FormParam("idioma") String idioma,
            @FormParam("telefono") String telefono) {
        RespuestaWS<String> respuestaWS = new RespuestaWS<>();
        try {
            respuestaWS.responseStatus = 200;
            respuestaWS.message = UserManagement.InsertarUsuario(email, password, name, surname, birthday, gender, salt, idioma, telefono, uriInfo.getBaseUri().toString());
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
