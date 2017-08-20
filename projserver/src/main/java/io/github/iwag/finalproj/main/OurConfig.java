package io.github.iwag.finalproj.main;


import javax.ws.rs.ApplicationPath;

import io.github.iwag.finalproj.store.MySQLUserStore;
import io.github.iwag.finalproj.store.UserStore;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class OurConfig extends ResourceConfig {

    public OurConfig() {
        packages(this.getClass().getPackage().getName());

        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(MySQLUserStore.class).to(UserStore.class);
            }
        });
    }
}