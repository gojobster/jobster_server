//package com.jobster.server.rest;
//
//        import com.jobster.server.BLL.JobsterException;
//        import com.jobster.server.BLL.OffersManagement;
//        import com.jobster.server.DTO.RespuestaWS;
//        import com.jobster.server.DTO.RespuestaWSOfferCity;
//        import com.jobster.server.DTO.RespuestaWSOfferFilters;
//
//        import javax.ws.rs.POST;
//        import javax.ws.rs.Path;
//        import javax.ws.rs.Produces;
//        import javax.ws.rs.core.MediaType;
//        import java.util.List;
//
//@Path("/{getAllFilters : (?i)getAllFilters}")
//public class GetAllFilters {
//
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public RespuestaWS<RespuestaWSOfferFilters> getAllFilters() {
//        RespuestaWS<RespuestaWSOfferFilters> respuestaWS = new RespuestaWS<>();
//        try {
//            respuestaWS.responseStatus = 200;
//            respuestaWS.message = OffersManagement.getAllOffersFilters();
//            respuestaWS.error = "";
//            return  respuestaWS;
//        } catch (JobsterException ex) {
//            respuestaWS.responseStatus = ex.getErrorNumber();
//            respuestaWS.message = null;
//            respuestaWS.error = ex.getMessage();
//            return respuestaWS;
//        }
//    }
//}