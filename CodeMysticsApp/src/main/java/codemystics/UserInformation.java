package codemystics;

import mongodb.Create;
import mongodb.DataModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

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

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveUser() throws Exception {
        User dataUser = new User("ab123", "Ambika", "Kabra", "kabraambika19@gmail.com");
        Create create = new Create();
        create.insertRecord(dataUser,"user");
        String result = "User saved : " + dataUser;
        return Response.status(201).entity(result).build();
    }

    @POST
    @Path("save/household")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveUserHouseholdBill(User user) throws Exception {
        HouseholdInformation householdInformation = new HouseholdInformation(user.getUserId(), 500, 2,
                new Date());
        Create create = new Create();
        create.insertRecord( householdInformation,"house");
        String result = "User saved : " + user;
        return Response.status(201).entity(result).build();
    }
}
