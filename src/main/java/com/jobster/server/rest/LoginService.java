package com.jobster.server.rest;

import com.jobster.server.BLL.JobsterException;
import com.jobster.server.BLL.UserManagement;
import com.jobster.server.DTO.RespuestaWS;
import com.jobster.server.DTO.RespuestaWSLogin;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/{login : (?i)login}")
public class LoginService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<RespuestaWSLogin> autentificarUsuario(
            @FormParam("username") String username,
            @FormParam("password") String password) {
        RespuestaWS<RespuestaWSLogin> respuesta = new RespuestaWS<>();
        try {
            respuesta.responseStatus = 0;
            respuesta.message = UserManagement.Login(username, password);
            respuesta.error = "";
            return respuesta;
        } catch (JobsterException ex) {
            respuesta.responseStatus = ex.getErrorNumber();
            respuesta.message = null;
            respuesta.error = ex.getMessage();
            return respuesta;
        }
    }
}
