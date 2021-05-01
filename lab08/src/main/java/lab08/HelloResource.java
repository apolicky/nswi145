package lab08;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello Jersey";
    }
}