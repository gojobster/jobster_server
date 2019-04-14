package com.jobster.server.rest;

import com.jobster.server.BLL.JobsterException;
import com.jobster.server.BLL.UserManagement;
import com.jobster.server.DTO.RespuestaWS;
import com.jobster.server.DTO.RespuestaWSUser;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/{getAllUsers : (?i)getAllUsers}")
public class GetAllUsers {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<List<RespuestaWSUser>> getAllUsers(@Context HttpHeaders httpheaders) {
        String token = httpheaders.getHeaderString("Authorization");
        RespuestaWS<List<RespuestaWSUser>> respuestaWS = new RespuestaWS<>();
        try {
            UserManagement.check_token(token);
            respuestaWS.responseStatus = 200;
            respuestaWS.message = UserManagement.getAllUsers();
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