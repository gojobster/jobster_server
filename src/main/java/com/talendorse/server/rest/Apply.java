package com.talendorse.server.rest;

import com.talendorse.server.BLL.EndorsementManagement;
import com.talendorse.server.BLL.TalendorseException;
import com.talendorse.server.BLL.UserManagement;
import com.talendorse.server.DTO.RespuestaWS;
import com.talendorse.server.types.TalendorseErrorType;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/{apply : (?i)apply}")
public class Apply {
    @Context
    private UriInfo uriInfo;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<String> apply(
            @FormParam("token") String token,
            @FormParam("id_candidate") Integer id_candidate,
            @FormParam("id_offer") Integer id_offer,
            @FormParam("code") String code){
        RespuestaWS<String> respuestaWS = new RespuestaWS<>();
        try {
            int idTokenUser = UserManagement.GetUserIdfromToken(token);

            if(idTokenUser != id_candidate) throw new TalendorseException(TalendorseErrorType.BAD_ACCESS);

            respuestaWS.responseStatus = 200;
            respuestaWS.message = EndorsementManagement.applyCandidate(id_candidate, id_offer, code);
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
