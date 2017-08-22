package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.models.entities.CredientialEntity;
import io.github.iwag.finalproj.models.entities.ExUserEntity;
import io.github.iwag.finalproj.models.entities.ProfileEntity;
import io.github.iwag.finalproj.models.entities.UserEntity;
import io.github.iwag.finalproj.models.requestmodels.CredientialRequestModel;
import io.github.iwag.finalproj.models.requestmodels.UserRequestModel;
import io.github.iwag.finalproj.models.responsemodels.CredientialResponseModel;
import io.github.iwag.finalproj.models.responsemodels.ErrorResponseModel;
import io.github.iwag.finalproj.models.responsemodels.UserResponseModel;
import io.github.iwag.finalproj.store.Stores;
import io.github.iwag.finalproj.store.UserStore;
import io.github.iwag.finalproj.store.UserStoreInMemory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class User {

    UserStore userStore;

    final Logger logger = LogManager.getLogger(getClass());

    public User() {
        this.userStore = new UserStoreInMemory();
    }

    @ExceptionHandler({ OurApplicationException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
            OurApplicationException ex, WebRequest request) {
        return new ResponseEntity<Object>(new ErrorResponseModel(ex.getStatus().toString(), ex.getMessage()), new HttpHeaders(), ex.getStatus());
    }

    @RequestMapping(path = "/users/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CredientialResponseModel login(@RequestBody CredientialRequestModel crm) {
        if (!crm.validate()) {
            logger.info("password invalid " + crm);
            throw new OurApplicationException(HttpStatus.BAD_REQUEST, "bad request");
        }

        LocalDate date = LocalDate.now();
        ProfileEntity pe = userStore.loginUser(crm.getUsername(), crm.getPassword(), date, UUID.randomUUID().toString());
        if (pe == null) throw new OurApplicationException(HttpStatus.UNAUTHORIZED, "login failed");
        return new CredientialResponseModel(pe.getUserEntity().getFirstName(), pe.getUserEntity().getLastName(), pe.getUserEntity().getUserName(), pe.getUserId().toString(), pe.getUserEntity().getCountryLocation(), pe.getDate().toString(), pe.getAuthToken());
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseModel create(@RequestBody UserRequestModel ur) {
        if (!ur.validate()) {
            logger.info("bad invalid" + ur);
            throw new OurApplicationException(HttpStatus.BAD_REQUEST, "bad request");
        }

        ExUserEntity eue = userStore.addUser(new UserEntity(ur.getFirstname(), ur.getLastname(), ur.getCountry(), ur.getUsername(), ur.getPassword()));
        logger.debug("UserEntity from MySQL "+eue);
        return new UserResponseModel(eue.getFirstName(), eue.getLastName(), eue.getUserId().toString(),
                ur.getUsername(), eue.getCountryLocation(), "14 July 2017", "");
    }


}
