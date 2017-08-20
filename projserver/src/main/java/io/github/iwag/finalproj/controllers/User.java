package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.models.entities.CredientialEntity;
import io.github.iwag.finalproj.models.entities.ExUserEntity;
import io.github.iwag.finalproj.models.entities.ProfileEntity;
import io.github.iwag.finalproj.models.entities.UserEntity;
import io.github.iwag.finalproj.models.requestmodels.CredientialRequestModel;
import io.github.iwag.finalproj.models.requestmodels.UserRequestModel;
import io.github.iwag.finalproj.models.responsemodels.CredientialResponseModel;
import io.github.iwag.finalproj.models.responsemodels.UserResponseModel;
import io.github.iwag.finalproj.store.MySQLUserStore;
import io.github.iwag.finalproj.store.Stores;
import io.github.iwag.finalproj.store.UserStore;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Path("users")
public class User {
    @Inject
    UserStore userStore;

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public UserResponseModel create(UserRequestModel ur) {
        if (!ur.validate()) {
            System.err.println("password invalid" + ur);
            throw new OurApplicationException(Response.Status.BAD_REQUEST.getStatusCode(), "input invalid");
        }

        ExUserEntity eue = userStore.addUser(new UserEntity(ur.getFirstname(), ur.getLastname(), ur.getCountry(), ur.getUsername(), ur.getPassword()));
        System.err.println("UserEntity from MySQL "+eue);
        return new UserResponseModel(eue.getFirstName(), eue.getLastName(), eue.getUserId().toString(),
                ur.getUsername(), eue.getCountryLocation(), "14 July 2017", "");
    }

    @POST
    @Path("login")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public CredientialResponseModel login(CredientialRequestModel crm) {
        if (!crm.validate()) {
            System.err.println("password invalid " + crm);
            throw new OurApplicationException(Response.Status.BAD_REQUEST.getStatusCode(), "password invalid");
        }

        LocalDate date = LocalDate.now();
        ProfileEntity pe = userStore.loginUser(crm.getUsername(), crm.getPassword(), date, UUID.randomUUID().toString());
        if (pe == null) throw new OurApplicationException(Response.Status.UNAUTHORIZED.getStatusCode(), "login failed");
        return new CredientialResponseModel(pe.getUserEntity().getFirstName(), pe.getUserEntity().getLastName(), pe.getUserEntity().getUserName(), pe.getUserId().toString(), pe.getUserEntity().getCountryLocation(), pe.getDate().toString(), pe.getAuthToken());
    }
}
