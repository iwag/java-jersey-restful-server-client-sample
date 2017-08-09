package finalproject.controllers;

import finalproject.interfaces.StringValidatePredicator;
import finalproject.models.entities.UserEntity;

import java.util.regex.Pattern;

public class RegistrationController {
    /**
     *
     */
    public static UserEntity buildUser() {
//        Scanner scanner = new Scanner(System.in);
//        String firstName = scanner.next();
//        String lastName = scanner.next();
//        String countryLocation = scanner.next();
//        String userName = scanner.next();
//        String password = scanner.next();
//        Scanner scanner = new Scanner(System.in);
        String firstName = "takuya";
        String lastName = "iwakami";
        String countryLocation = "japan";
        String userName = "gami";
        String password = "iwakami";

        Pattern p = Pattern.compile("^[0-9a-zA-Z_\\-]+@[.0-9a-zA-Z_\\-]+$");
        StringValidatePredicator stringValidatePredicator = new StringValidatePredicator();
        stringValidatePredicator.evaluate(firstName, p);

        UserEntity userEntity = new UserEntity(firstName, lastName, countryLocation, userName, password);

        return userEntity;
    }
}
