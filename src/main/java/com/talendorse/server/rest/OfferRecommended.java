package com.talendorse.server.rest;

import com.talendorse.server.BLL.TalendorseException;
import com.talendorse.server.BLL.RecomendationsManagement;
import com.talendorse.server.DTO.RespuestaWS;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/{addRecommendations : (?i)addRecommendations}")
public class OfferRecommended {

    @Context
    private UriInfo uriInfo;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<String> addRecommendations(
            @FormParam("idOffer") int id_offer,
            @FormParam("idUser") int id_user,
            @FormParam("email") String email
    ){
        RespuestaWS<String> respuestaWS = new RespuestaWS<>();
        try {
            respuestaWS.responseStatus = 200;
            respuestaWS.message = RecomendationsManagement.sendRecomendatioToCandidate(uriInfo.getBaseUri().toString(), id_user, id_offer, email);
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
