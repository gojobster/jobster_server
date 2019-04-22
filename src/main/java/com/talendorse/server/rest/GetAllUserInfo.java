package com.talendorse.server.rest;

import com.talendorse.server.BLL.TalendorseException;
import com.talendorse.server.BLL.UserManagement;
import com.talendorse.server.DTO.RespuestaWS;
import com.talendorse.server.DTO.RespuestaWSAllInfoUser;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/{getAllInfoUser : (?i)getAllInfoUser}")
public class GetAllUserInfo {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<RespuestaWSAllInfoUser> getAllInfoUser(
            @FormParam("idUser") int idUser
    ){
        RespuestaWS<RespuestaWSAllInfoUser> respuestaWS = new RespuestaWS<>();
        try {
            respuestaWS.responseStatus = 200;
            respuestaWS.message = UserManagement.getAllInfoUser(idUser);
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