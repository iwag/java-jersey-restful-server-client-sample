package io.github.iwag.jerseystarter;

import io.github.iwag.jerseystarter.models.Task;
import io.github.iwag.jerseystarter.repository.ApiTaskRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TaskTest extends Mockito {

    static Client mockClient(Response.Status status, Task t) {
        Response mockRes = Mockito.mock(Response.class);
        if (t != null)
            // set expected response
            Mockito.when(mockRes.readEntity(Task.class)).thenReturn(t);

        final Builder mockBuilder = Mockito.mock(Builder.class);
        // set returned status code here
        Mockito.when(mockRes.getStatus()).thenReturn(status.getStatusCode());
        Mockito.when(mockBuilder.accept(Mockito.anyString())).thenReturn(mockBuilder);
        // for now set t in all methods
        Mockito.when(mockBuilder.get()).thenReturn(mockRes);
        Mockito.when(mockBuilder.post(Mockito.any())).thenReturn(mockRes);
        Mockito.when(mockBuilder.put(Mockito.any())).thenReturn(mockRes);

        final WebTarget mockTarget = Mockito.mock(WebTarget.class);
        Mockito.when(mockTarget.request(Mockito.anyString())) // if you specify, use MediaType.APPLICATION_JSON
                .thenReturn(mockBuilder);
        Mockito.when(mockTarget.path(Mockito.anyString())).thenReturn(
                mockTarget);

        final Client client = Mockito.mock(Client.class);
        Mockito.when(client.target(Mockito.anyString())).thenReturn(
                mockTarget);
        return  client;
    }

    @Test
    public void testGetTask0_OK() {
        Task expected = new Task();
        Client clientMock = mockClient(Response.Status.OK, expected);
        Task t = new ApiTaskRepository(clientMock).get("0");
        Assert.assertEquals(t, expected);
    }

    @Test
    public void testGetTask0_NotFound() {
        Client clientMock = mockClient(Response.Status.NOT_FOUND, new Task());
        Task t = new ApiTaskRepository(clientMock).get("0");
        Assert.assertNull(t);
    }

    @Test
    public void testCreate_OK() {
        Client clientMock = mockClient(Response.Status.ACCEPTED, null);
        boolean success = new ApiTaskRepository(clientMock).create(new Task(null, "test", 0, "2017/08/15"));
        Assert.assertTrue(success);
    }

    @Test
    public void testCreate_BadRequest() {
        Client clientMock = mockClient(Response.Status.BAD_REQUEST, null);
        boolean success = new ApiTaskRepository(clientMock).create(new Task(null, "test", 0, "2017/08/15"));
        Assert.assertFalse(success);
    }
}
