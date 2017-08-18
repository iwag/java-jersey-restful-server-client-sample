package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.interfaces.StringValidatePredicator;
import io.github.iwag.finalproj.models.entities.ProfileEntity;
import io.github.iwag.finalproj.models.entities.UserEntity;
import io.github.iwag.finalproj.models.managers.APIManager;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegistrationController {
    private APIManager apiManager;

    public RegistrationController(APIManager apiManager) {
        this.apiManager = apiManager;
    }

    /**
     *
     */
    public ProfileEntity buildUser() {
        Scanner scanner = new Scanner(System.in);

       System.out.println("Registration:");
        System.out.println("* Firstname:");
        String firstName = scanner.next();
        System.out.println("* Lastname");
        String lastName = scanner.next();
        System.out.println("* Country of Location:");
        String countryLocation = scanner.next();
        System.out.println("* Username:");
        String userName = scanner.next();
        System.out.println("* Password:");
        String password = scanner.next();
//        String firstName = "takuya";
//        String lastName = "iwakami";
//        String countryLocation = "japan";
//        String userName = "gami@example.com";
//        String password = "iwakami";

        Pattern p = Pattern.compile("^[0-9a-zA-Z_\\-]+@[.0-9a-zA-Z_\\-]+$");
        StringValidatePredicator stringValidatePredicator = new StringValidatePredicator();
        if (stringValidatePredicator.evaluate(userName, p) == false) {
            return null;
        }

        UserEntity userEntity = new UserEntity(firstName, lastName, countryLocation, userName, password);

        ProfileEntity pe = apiManager.createUser(userEntity);

        return pe;
    }
}
