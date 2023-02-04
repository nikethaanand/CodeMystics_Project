package codemystics;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserInformation {
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveUser(User user) {
        // Implement logic to save the user information to database
        String result = "User saved : " + user;
        return Response.status(201).entity(result).build();
    }

    @GET
    @Path("/try")
    @Produces("text/plain")
    public Response saveTryUser() {
        // Implement logic to save the user information to database
        String result = "User saved : ";
        return Response.status(201).entity(result).build();
    }
}
