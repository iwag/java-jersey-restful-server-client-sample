package controllers;

import io.github.iwag.finalproj.controllers.Interviews;
import io.github.iwag.finalproj.models.entities.ProfileEntity;
import io.github.iwag.finalproj.models.entities.UserEntity;
import io.github.iwag.finalproj.models.requestmodels.SubmitAnswerModel;
import io.github.iwag.finalproj.models.requestmodels.SubmitRequestModel;
import io.github.iwag.finalproj.models.responsemodels.ErrorResponseModel;
import io.github.iwag.finalproj.models.responsemodels.SubmitResponseModel;
import io.github.iwag.finalproj.store.Stores;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class TestInterview extends JerseyTest {


    @Override
    protected Application configure() {
        return new ResourceConfig(Interviews.class);
    }


    @Test
    public void testSubmitSuccess() throws Exception {
        ProfileEntity  profileEntity = Stores.userStore.newAuth(new UserEntity("a", "a", "j", "i@g", "a"), 1);
        SubmitRequestModel submitRequestModel = new SubmitRequestModel("1", new LinkedList<SubmitAnswerModel>());
        Entity<?> entity = Entity.entity(submitRequestModel, MediaType.APPLICATION_JSON);
        Response response = target("interview").path("5").request(MediaType.APPLICATION_JSON).header("auth", profileEntity.getAuthToken()).post(entity);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        SubmitResponseModel res = response.readEntity(SubmitResponseModel.class);
        assertEquals("Java", res.getTopic());
    }

    @Test
    public void testSubmitFail() throws Exception {
        ProfileEntity  profileEntity = Stores.userStore.newAuth(new UserEntity("a", "a", "j", "i@g", "a"), 1);
        SubmitRequestModel submitRequestModel = new SubmitRequestModel();
        Entity<?> entity = Entity.entity(submitRequestModel, MediaType.APPLICATION_JSON);
        Response response = target("interview").path("5").request(MediaType.APPLICATION_JSON).header("auth", profileEntity.getAuthToken()).post(entity);
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
        ErrorResponseModel res = response.readEntity(ErrorResponseModel.class);
        assertEquals("400", res.getStatus());
    }

    @Test
    public void testSubmitNonFoundInterview() throws Exception {
        ProfileEntity  profileEntity = Stores.userStore.newAuth(new UserEntity("a", "a", "j", "i@g", "a"), 1);
        SubmitRequestModel submitRequestModel = new SubmitRequestModel("1", Arrays.asList());
        Entity<?> entity = Entity.entity(submitRequestModel, MediaType.APPLICATION_JSON);
        Response response = target("interview").path("5555").request(MediaType.APPLICATION_JSON).header("auth", profileEntity.getAuthToken()).post(entity);
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
        ErrorResponseModel res = response.readEntity(ErrorResponseModel.class);
        assertEquals("404", res.getStatus());
    }


    @Test
    public void testSubmitFailWithoutAuth() throws Exception {
        ProfileEntity  profileEntity = Stores.userStore.newAuth(new UserEntity("a", "a", "j", "i@g", "a"), 1);
        SubmitRequestModel submitRequestModel = new SubmitRequestModel("1", Arrays.asList());
        Entity<?> entity = Entity.entity(submitRequestModel, MediaType.APPLICATION_JSON);
        Response response = target("interview").path("0").request(MediaType.APPLICATION_JSON).header("auth", "invaliddd").post(entity);
        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
        ErrorResponseModel res = response.readEntity(ErrorResponseModel.class);
        assertEquals("401", res.getStatus());
    }

}
