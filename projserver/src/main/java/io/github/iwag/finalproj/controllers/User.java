package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.models.entities.ExUserEntity;
import io.github.iwag.finalproj.models.entities.ProfileEntity;
import io.github.iwag.finalproj.models.entities.UserEntity;
import io.github.iwag.finalproj.models.requestmodels.CredientialRequestModel;
import io.github.iwag.finalproj.models.requestmodels.UserRequestModel;
import io.github.iwag.finalproj.models.responsemodels.CredientialResponseModel;
import io.github.iwag.finalproj.models.responsemodels.ErrorResponseModel;
import io.github.iwag.finalproj.models.responsemodels.UserResponseModel;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

@RestController
public class User  extends BaseController  {

    private final UserStoreInMemory userStore;

    final Logger logger = LogManager.getLogger(getClass());

    public User() {
        this.userStore = new UserStoreInMemory();
    }

    @RequestMapping(path = "/users/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CredientialResponseModel login(@RequestBody CredientialRequestModel crm) {
        if (!crm.validate()) {
            logger.info("invalid request" + crm);
            throw new OurApplicationException(HttpStatus.BAD_REQUEST, "invalid request");
        }

        LocalDate date = LocalDate.now();
        ProfileEntity pe = userStore.loginUser(crm.getUsername(), crm.getPassword(), date, UUID.randomUUID().toString());
        if (pe == null) { 
            logger.info("login failed" + crm);
			throw new OurApplicationException(HttpStatus.UNAUTHORIZED, "login failed");
		}

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);

        String dateStr = date.format(formatter);
        return new CredientialResponseModel(pe.getUserEntity().getFirstName(), pe.getUserEntity().getLastName(), pe.getUserId().toString(), pe.getUserEntity().getUserName(), pe.getUserEntity().getCountryLocation(), dateStr, pe.getAuthToken());
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseModel create(@RequestBody UserRequestModel ur) {
        if (!ur.validate()) {
            logger.info("invalid request" + ur);
            throw new OurApplicationException(HttpStatus.BAD_REQUEST, "invalid request");
        }

        ExUserEntity eue = userStore.addUser(new UserEntity(ur.getFirstname(), ur.getLastname(), ur.getCountry(), ur.getUsername(), ur.getPassword()));
        if (eue == null) throw new OurApplicationException(HttpStatus.BAD_REQUEST, "already has");
        logger.info("UserEntity from MySQL "+eue);
        return new UserResponseModel(eue.getFirstName(), eue.getLastName(), eue.getUserId().toString(),
                ur.getUsername(), eue.getCountryLocation(), "14 July 2017", "");
    }


}
