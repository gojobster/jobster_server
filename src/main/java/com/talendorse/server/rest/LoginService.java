package com.talendorse.server.rest;

import com.talendorse.server.BLL.TalendorseException;
import com.talendorse.server.BLL.UserManagement;
import com.talendorse.server.DTO.RespuestaWS;
import com.talendorse.server.DTO.RespuestaWSLogin;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

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
        } catch (TalendorseException ex) {
            respuesta.responseStatus = ex.getErrorNumber();
            respuesta.message = null;
            respuesta.error = ex.getMessage();
            return respuesta;
        }
    }
}
