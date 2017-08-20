package controllers;

import io.github.iwag.finalproj.controllers.User;
import io.github.iwag.finalproj.models.entities.ExUserEntity;
import io.github.iwag.finalproj.models.entities.ProfileEntity;
import io.github.iwag.finalproj.models.entities.UserEntity;
import io.github.iwag.finalproj.models.requestmodels.CredientialRequestModel;
import io.github.iwag.finalproj.models.requestmodels.UserRequestModel;
import io.github.iwag.finalproj.models.responsemodels.CredientialResponseModel;
import io.github.iwag.finalproj.models.responsemodels.ErrorResponseModel;
import io.github.iwag.finalproj.models.responsemodels.UserResponseModel;
import io.github.iwag.finalproj.store.UserStore;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.jvnet.hk2.annotations.Service;


import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestUser extends JerseyTest {

    @Service
    static class TestUserStore implements UserStore {
        static UserEntity userEntity = null;

        public TestUserStore() {
        }

        @Override
        public ExUserEntity addUser(UserEntity ue) {
            if (ue == null) return null;
            userEntity = ue;
            ExUserEntity ex = new ExUserEntity(ue.getFirstName(), ue.getLastName(), ue.getCountryLocation(), ue.getUserName(), ue.getPassword(), 1);
            return ex;
        }

        @Override
        public ProfileEntity loginUser(String username, String password, LocalDate date, String auth) {
            if (userEntity == null) return null;
            return new ProfileEntity(userEntity, 1, LocalDate.now(), "aaaa");
        }
    }

    @Override
    protected Application configure() {
        return new ResourceConfig(User.class).register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(TestUserStore.class).to(UserStore.class);
            }
        });
    }

    @Test
    public void testCreateAndLoginUserSuccess() throws Exception {
        UserRequestModel urm = new UserRequestModel("ta", "iw", "ja", "iw@gm", "hello");
        Entity<?> entity = Entity.entity(urm, MediaType.APPLICATION_JSON);
        Response response = target("users").request(MediaType.APPLICATION_JSON).post(entity);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        UserResponseModel res = response.readEntity(UserResponseModel.class);
        assertEquals(res.getFirstname(), "ta");
        assertEquals(res.getLastname(), "iw");

        CredientialRequestModel crm = new CredientialRequestModel("iw@gm", "hello");
        Entity<?> entity2 = Entity.entity(crm, MediaType.APPLICATION_JSON);
        Response response2 = target("users").path("login").request().post(entity2);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        CredientialResponseModel res2 = response2.readEntity(CredientialResponseModel.class);
        assertEquals(res2.getFirstname(), "ta");
        assertEquals(res2.getAuthtoken(), "aaaa");
    }

    @Test
    public void testCreateUserFail() throws Exception {
        UserRequestModel urm = new UserRequestModel();
        Entity<?> entity = Entity.entity(urm, MediaType.APPLICATION_JSON_TYPE);
        Response response = target("users").request().post(entity);
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
        ErrorResponseModel res = response.readEntity(ErrorResponseModel.class);
        assertEquals("400", res.getStatus());
    }

    @Test
    public void testLoginFail() throws Exception {
        CredientialRequestModel crm = new CredientialRequestModel("iw@gm", "hello");
        Entity<?> entity = Entity.entity(crm, MediaType.APPLICATION_JSON_TYPE);
        Response response = target("users").path("login").request().post(entity);
        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
        ErrorResponseModel res = response.readEntity(ErrorResponseModel.class);
        assertEquals("401", res.getStatus());
    }

}