package finalproject.controllers;

import finalproject.interfaces.StringValidatePredicator;
import finalproject.models.entities.CredientialEntity;
import finalproject.models.entities.HistoryEntity;
import finalproject.models.entities.ProfileEntity;
import finalproject.models.managers.APIManager;

import java.util.regex.Pattern;

public class HistoryController {
    private APIManager apiManager;

    public HistoryController(APIManager apiManager) {
        this.apiManager = apiManager;
    }

    public HistoryEntity history(ProfileEntity pe) {

        return apiManager.history(pe.getUserId());
    }
}
