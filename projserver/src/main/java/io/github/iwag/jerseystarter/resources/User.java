package io.github.iwag.jerseystarter.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("users")
public class User {

    @GET
    @Produces({MediaType.TEXT_PLAIN})
//    @Consumes({MediaType.APPLICATION_JSON})
    public String create() {
        return "";
    }

}
