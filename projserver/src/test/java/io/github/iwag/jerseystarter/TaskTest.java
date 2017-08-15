package io.github.iwag.jerseystarter;

import io.github.iwag.jerseystarter.models.Task;
import io.github.iwag.jerseystarter.resources.TaskResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;

public class TaskTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(TaskResource.class);
    }

    @Test
    public void testGetTask0Normal() throws Exception {
        Task task = target("task/0").request().get(Task.class);
        Task expected = new Task("sample", 0, "2017/08/10");

        Assert.assertEquals(task, expected);
    }
}
