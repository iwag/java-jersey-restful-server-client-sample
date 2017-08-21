package io.github.iwag.jerseystarter.main;

import io.github.iwag.jerseystarter.repositories.TaskRepositoryInMem;
import io.github.iwag.jerseystarter.repositories.TaskRepository;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class TaskConfig extends ResourceConfig {

    public TaskConfig() {
        packages(this.getClass().getPackage().getName());

        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(TaskRepositoryInMem.class).to(TaskRepository.class);
            }
        });
    }
}
