package com.talendorse.server.rest;

        import com.talendorse.server.BLL.TalendorseException;
        import com.talendorse.server.BLL.OffersManagement;
        import com.talendorse.server.DTO.RespuestaWS;
        import com.talendorse.server.DTO.RespuestaWSOfferFilters;

        import javax.ws.rs.POST;
        import javax.ws.rs.Path;
        import javax.ws.rs.Produces;
        import javax.ws.rs.core.MediaType;

@Path("/{getAllFilters : (?i)getAllFilters}")
public class GetAllFilters {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<RespuestaWSOfferFilters> getAllFilters() {
        RespuestaWS<RespuestaWSOfferFilters> respuestaWS = new RespuestaWS<>();
        try {
            respuestaWS.responseStatus = 200;
            respuestaWS.message = OffersManagement.getAllOffersFilters("");
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