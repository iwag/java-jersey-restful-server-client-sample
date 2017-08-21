package io.github.iwag.finalproj.main;


import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

import io.github.iwag.finalproj.store.MySQLUserStore;
import io.github.iwag.finalproj.store.UserStore;
import org.glassfish.hk2.api.DynamicConfiguration;
import org.glassfish.hk2.api.DynamicConfigurationService;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.BuilderHelper;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class OurConfig extends ResourceConfig {

    @Inject
    public OurConfig(ServiceLocator locator) {
        DynamicConfigurationService dcs = locator.getService(DynamicConfigurationService.class);
        DynamicConfiguration config = dcs.createDynamicConfiguration();

        config.bind(BuilderHelper.link(MySQLUserStore.class).to(UserStore.class).build());

        config.commit();

        packages(true, getClass().getPackage().getName());
    }
}
