package io.github.iwag.jerseystarter.resources;

import io.github.iwag.jerseystarter.models.Task;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("task")
public class TaskResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Task get() {
        return new Task("sample", 0, "2017/08/10");
    }

    @DELETE
    public Response delete() {
        // write deleting code
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(Task t) {
        System.out.println(t);
        // write deleting code
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Task t) {
        System.out.println(t);
        // write creating code
        return Response.status(Response.Status.ACCEPTED).build();
    }

}
