package org.dibas;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @POST
    @Path("/info")
    /*public Response responseMsg(@FormParam("fname") String fname,   @FormParam("lname") String lname ) {

        String output = "This all the info about "+fname +" "+lname;
        return Response.status(200).entity(output).build();

    }*/
    public Response responseMsg(MultivaluedMap<String, String> parameters) {
        String output = " Form parameters :\n";
        for (String key : parameters.keySet()) {
            output += key + " : " + parameters.getFirst(key) +"\n";
        }
        return Response.status(Response.Status.OK).entity(output).build();
    }


}
