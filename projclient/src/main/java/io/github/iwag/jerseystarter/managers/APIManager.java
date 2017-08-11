package io.github.iwag.jerseystarter.managers;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class APIManager {
    private static String baseUrl = "http://localhost:8080";

    public static String getUser() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(baseUrl).path("/users");

        String res = null;
        try {
            res = webTarget.request(MediaType.TEXT_PLAIN).accept("application/json").get(String.class);
        } catch (BadRequestException e) {
            throw e;
        }

        return res;
    }
}
