package io.github.iwag.jerseystarter;

import io.github.iwag.jerseystarter.models.Task;
import io.github.iwag.jerseystarter.repositories.TaskRepository;
import io.github.iwag.jerseystarter.resources.TaskResource;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import org.jvnet.hk2.annotations.Service;

import javax.ws.rs.core.Application;

public class TaskTest extends JerseyTest {

    @Service
    static class TaskRepositoryMock implements TaskRepository {
        public Task[] gets() {
            return new Task[0];
        }

        public Task get(String id) {
            return null;
        }

        public boolean create(Task t) {
            return false;
        }

        public boolean update(String id, Task t) {
            return false;
        }

        public boolean delete(String id) {
            return false;
        }
    }

    @Override
    protected Application configure() {
        return new ResourceConfig(TaskResource.class).register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(TaskRepositoryMock.class).to(TaskRepository.class);
            }
        });
    }


    @Test
    public void testGetTask0Normal() throws Exception {
        Task task = target("task/0").request().get(Task.class);
        Task expected = new Task("0", "sample", 0, "2017/08/10");

        Assert.assertEquals(task, expected);
    }
}
