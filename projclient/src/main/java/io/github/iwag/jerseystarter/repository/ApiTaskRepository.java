package io.github.iwag.jerseystarter.repository;

import io.github.iwag.jerseystarter.models.Task;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ApiTaskRepository implements TaskRepository {
    private final String baseUrl = "http://localhost:8080";
    private final Client client;

    public ApiTaskRepository(Client client) {
        // create client instance
        this.client = client;
    }

    @Override
    public Task[] gets() {
        // Write API requesting code
        return new Task[0];
    }

    @Override
    public Task get(String id) {
        // make web target by url
        WebTarget webTarget = client.target(baseUrl).path("/task/" + id);

        Response res = null;
        // request by GET method without body
        res = webTarget.request(MediaType.TEXT_PLAIN).accept("application/json").get();
        // check response. Now we're checking only status code.
        if (res.getStatus() != Response.Status.OK.getStatusCode()) {
            return null;
        }
        // translate response body into Task class
        Task task = res.readEntity(Task.class);

        return task;
    }

    @Override
    public boolean create(Task t) {
        WebTarget webTarget = client.target(baseUrl).path("/task");

        Response res = null;
        Entity<?> entity = Entity.entity(t, MediaType.APPLICATION_JSON); // convert class to accept by jersey
        res = webTarget.request(MediaType.APPLICATION_JSON).accept("application/json").put(entity);
        // check if getting correct status code (ACCEPTED)
        if (res.getStatus() != Response.Status.ACCEPTED.getStatusCode()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(String id, Task t) {
        // Write API requesting code
        return true;
    }

    @Override
    public boolean delete(String id) {
        // Write API requesting code
        return true;
    }
}
