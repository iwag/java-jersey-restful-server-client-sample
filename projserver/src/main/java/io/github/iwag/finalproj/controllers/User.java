package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.models.entities.CredientialEntity;
import io.github.iwag.finalproj.models.entities.ExUserEntity;
import io.github.iwag.finalproj.models.entities.ProfileEntity;
import io.github.iwag.finalproj.models.entities.UserEntity;
import io.github.iwag.finalproj.models.requestmodels.CredientialRequestModel;
import io.github.iwag.finalproj.models.requestmodels.UserRequestModel;
import io.github.iwag.finalproj.models.responsemodels.CredientialResponseModel;
import io.github.iwag.finalproj.models.responsemodels.UserResponseModel;
import io.github.iwag.finalproj.store.Stores;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Path("users")
public class User {

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public UserResponseModel create(UserRequestModel ur) {
        if (!ur.validate()) throw new BadRequestException();

        ExUserEntity eue = Stores.userStore.addUser(new UserEntity(ur.getFirstname(), ur.getLastname(), ur.getCountry(), ur.getUsername(), ur.getPassword()));
        return new UserResponseModel(eue.getFirstName(), eue.getLastName(), eue.getUserId().toString(),
                ur.getUsername(), eue.getCountryLocation(), "14 July 2017", "");
    }

}
