package io.github.iwag.jerseystarter.resources;

import io.github.iwag.jerseystarter.models.Task;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("task")
public class TaskResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Task[] gets() {
        return new Task[]{new Task("0", "sample", 0, "2017/08/10")};
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Task get(@PathParam("id") String id) {
        return new Task(id, "sample", 0, "2017/08/10");
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        // write deleting code
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @POST
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") String id, Task t) {
        System.out.println(id + " " + t);
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
