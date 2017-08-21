package io.github.iwag.jerseystarter.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.server.ResourceConfig;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {
    public static final Integer PORT = 8080;

    public static void main(String[] args) throws Exception {
        final Logger logger = LogManager.getLogger();
        final Server server = new Server(Integer.valueOf(PORT));
        final WebAppContext root = new WebAppContext();

        root.setContextPath("/");
        root.setParentLoaderPriority(true);

        final String webappDirLocation = "src/main/webapp/";
        root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        root.setResourceBase(webappDirLocation);

        server.setHandler(root);

        logger.info("start " + server.getURI() + "...");
        server.start();
        server.join();
    }
}
