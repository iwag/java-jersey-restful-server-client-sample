package finalproject.models.interfaces;

import finalproject.models.entities.CredientialEntity;
import finalproject.models.entities.ProfileEntity;
import finalproject.models.entities.UserEntity;
import finalproject.models.requestmodels.CredientialEntityModel;
import finalproject.models.requestmodels.UserRequestModel;
import finalproject.models.responsemodels.CredientialResponseModel;
import finalproject.models.responsemodels.UserResponseModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MapperImplementation {
    public static UserRequestModel convertUserRequestModel(UserEntity ue) {
        return new UserRequestModel(ue.getFirstName(), ue.getLastName(), ue.getCountryLocation(), ue.getUserName(), ue.getPassword());
    }

    public static ProfileEntity convertToProfileEntity(UserResponseModel urm) {
        UserEntity ue = new UserEntity(urm.getFirstname(), urm.getLastname(), urm.getCountry(), urm.getUsername(), "");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);

        LocalTime date = LocalTime.parse(urm.getJoined(), formatter);

        return new ProfileEntity(ue, Integer.valueOf(urm.getUserId()), date, "");
    }

    public static CredientialEntityModel convertToCredientialRequestModel(CredientialEntity credientialEntity) {
        return new CredientialEntityModel();
    }

    public static ProfileEntity convertToProfileEntity(CredientialResponseModel crm) {
        UserEntity ue = new UserEntity(crm.getFirstname(), crm.getLastname(), crm.getCountry(), crm.getUsername(), "");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);

        LocalTime date = LocalTime.parse(crm.getJoined(), formatter);
        return new ProfileEntity(ue, Integer.valueOf(crm.getUserId()), date, crm.getAuthToken());
    }

}
