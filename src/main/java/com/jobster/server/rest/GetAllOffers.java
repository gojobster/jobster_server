package com.jobster.server.rest;

        import com.jobster.server.BLL.JobsterException;
        import com.jobster.server.BLL.OffersManagement;
        import com.jobster.server.BLL.UserManagement;
        import com.jobster.server.DTO.RespuestaWS;
        import com.jobster.server.DTO.RespuestaWSOffer;
        import com.jobster.server.DTO.RespuestaWSUser;

        import javax.ws.rs.FormParam;
        import javax.ws.rs.POST;
        import javax.ws.rs.Path;
        import javax.ws.rs.Produces;
        import javax.ws.rs.core.MediaType;
        import java.util.List;

@Path("/{getAllOffers : (?i)getAllOffers}")
public class GetAllOffers {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS<List<RespuestaWSOffer>> getAllOffers(
            @FormParam("filter_keyword") String keyword,
            @FormParam("filter_city") String city){
        RespuestaWS<List<RespuestaWSOffer>> respuestaWS = new RespuestaWS<>();
        try {
            respuestaWS.responseStatus = 200;
            respuestaWS.message = OffersManagement.getAllOffers(keyword, city);
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