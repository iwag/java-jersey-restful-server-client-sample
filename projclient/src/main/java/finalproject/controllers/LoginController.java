package finalproject.controllers;

import finalproject.interfaces.StringValidatePredicator;
import finalproject.models.entities.CredientialEntity;
import finalproject.models.entities.ProfileEntity;
import finalproject.models.entities.UserEntity;
import finalproject.models.managers.APIManager;
import finalproject.models.responsemodels.CredientialResponseModel;

import java.util.regex.Pattern;

public class LoginController extends BaseController {
    private APIManager apiManager;

    public LoginController(APIManager apiManager) {
        this.apiManager = apiManager;
    }


    public ProfileEntity login() {

        String userName = "gami@example.com";
        String password = "iwakami";

        Pattern p = Pattern.compile("^[0-9a-zA-Z_\\-]+@[.0-9a-zA-Z_\\-]+$");
        StringValidatePredicator stringValidatePredicator = new StringValidatePredicator();
        stringValidatePredicator.evaluate(userName, p);

        CredientialEntity credientialEntity = new CredientialEntity(userName, password);

        ProfileEntity pe = apiManager.login(credientialEntity);

        return pe;
    }

}
