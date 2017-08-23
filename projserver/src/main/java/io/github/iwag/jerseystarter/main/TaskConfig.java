package io.github.iwag.jerseystarter.main;

import io.github.iwag.jerseystarter.repositories.TaskRepositoryInMem;
import io.github.iwag.jerseystarter.repositories.TaskRepository;

import org.glassfish.hk2.api.*;
import org.glassfish.hk2.utilities.BuilderHelper;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class TaskConfig extends ResourceConfig {

    @Inject
    public TaskConfig(ServiceLocator locator) {
        DynamicConfigurationService dcs = locator.getService(DynamicConfigurationService.class);
        DynamicConfiguration config = dcs.createDynamicConfiguration();

        config.bind(BuilderHelper.link(TaskRepositoryInMem.class).to(TaskRepository.class).build());

        config.commit();

        packages(true, getClass().getPackage().getName());
    }
}
