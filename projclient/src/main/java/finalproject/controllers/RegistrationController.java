package finalproject.controllers;

import finalproject.interfaces.StringValidatePredicator;
import finalproject.models.entities.ProfileEntity;
import finalproject.models.entities.UserEntity;
import finalproject.models.managers.APIManager;

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
//        String firstName = scanner.next();
//        String lastName = scanner.next();
//        String countryLocation = scanner.next();
//        String userName = scanner.next();
//        String password = scanner.next();
        String firstName = "takuya";
        String lastName = "iwakami";
        String countryLocation = "japan";
        String userName = "gami@example.com";
        String password = "iwakami";

        Pattern p = Pattern.compile("^[0-9a-zA-Z_\\-]+@[.0-9a-zA-Z_\\-]+$");
        StringValidatePredicator stringValidatePredicator = new StringValidatePredicator();
        stringValidatePredicator.evaluate(firstName, p);

        UserEntity userEntity = new UserEntity(firstName, lastName, countryLocation, userName, password);

        ProfileEntity pe = apiManager.createUser(userEntity);

        return pe;
    }
}
