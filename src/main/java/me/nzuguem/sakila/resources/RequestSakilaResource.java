package me.nzuguem.sakila.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import me.nzuguem.sakila.services.RequestSakilaService;
import org.jboss.resteasy.reactive.RestPath;

@Path("/")
public class RequestSakilaResource {
    
    private final RequestSakilaService requestSakilaService;

    public RequestSakilaResource(RequestSakilaService requestSakilaService) {
        this.requestSakilaService = requestSakilaService;
    }

    @GET
    @Path("{prompt}")
    @Produces(MediaType.TEXT_PLAIN)
    public String request(@RestPath String prompt) {
        
        try {
            return this.requestSakilaService.request(prompt);
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage(), exception);
        }
        
    }
}
