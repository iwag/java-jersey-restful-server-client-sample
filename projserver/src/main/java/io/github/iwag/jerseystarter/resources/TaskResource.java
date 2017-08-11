package io.github.iwag.jerseystarter.resources;

import io.github.iwag.jerseystarter.Task;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("task")
public class TaskResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Task create() {
        return new Task("sample", 0, "2017/08/10");
    }

}
