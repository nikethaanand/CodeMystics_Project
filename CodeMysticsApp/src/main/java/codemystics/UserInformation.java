package codemystics;

import java.time.Instant;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mongodb.Create;
import mongodb.DataModel;

@Path("/user")
public class UserInformation {
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
        create.insertRecord((DataModel) householdInformation,"house");
        String result = "User saved : " + user;
        return Response.status(201).entity(result).build();
    }
}
