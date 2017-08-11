package finalproject.controllers;

import finalproject.models.entities.CredientialEntity;
import finalproject.models.entities.ExUserEntity;
import finalproject.models.entities.ProfileEntity;
import finalproject.models.entities.UserEntity;
import finalproject.models.requestmodels.CredientialRequestModel;
import finalproject.models.requestmodels.UserRequestModel;
import finalproject.models.responsemodels.CredientialResponseModel;
import finalproject.models.responsemodels.UserResponseModel;
import finalproject.store.Stores;

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
