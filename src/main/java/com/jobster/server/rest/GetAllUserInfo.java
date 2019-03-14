package com.jobster.server.rest;

import com.jobster.server.BLL.JobsterException;
import com.jobster.server.BLL.SkillsManagement;
import com.jobster.server.BLL.UserManagement;
import com.jobster.server.DTO.RespuestaWS;
import com.jobster.server.DTO.RespuestaWSAllInfoUser;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
        } catch (JobsterException ex) {
            respuestaWS.responseStatus = ex.getErrorNumber();
            respuestaWS.message = null;
            respuestaWS.error = ex.getMessage();
            return respuestaWS;
        }
    }
}