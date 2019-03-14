package com.jobster.server.rest;

import com.jobster.server.BLL.JobsterException;
import com.jobster.server.BLL.SkillsManagement;
import com.jobster.server.DTO.RespuestaWS;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/{addSkill : (?i)addSkill}")
public class AddSkills {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<String> addSkill(
            @FormParam("skill") String skill
    ){
        RespuestaWS<String> respuestaWS = new RespuestaWS<>();
        try {
            respuestaWS.responseStatus = 200;
            respuestaWS.message = SkillsManagement.addSkill(skill);
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
