package com.talendorse.server.rest;

import com.talendorse.server.BLL.TalendorseException;
import com.talendorse.server.BLL.EndorsementManagement;
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
            @FormParam("id_endorser") Integer id_endorser,
            @FormParam("id_offer") Integer id_offer,
            @FormParam("name") String nameCandidate,
            @FormParam("endorserCandidateRelation") Integer endorserCandidateRelation,
            @FormParam("description") String description,
            @FormParam("email_candidate") String email_candidate) {
        RespuestaWS<String> respuestaWS = new RespuestaWS<>();
        try {
            respuestaWS.responseStatus = 200;
            respuestaWS.message = EndorsementManagement.sendRecomendatioToCandidate(id_endorser, id_offer, email_candidate, nameCandidate, endorserCandidateRelation, description);
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
