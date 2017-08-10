package finalproject.controllers;

import finalproject.interfaces.StringValidatePredicator;
import finalproject.models.entities.AnswerCollectionEntity;
import finalproject.models.entities.CredientialEntity;
import finalproject.models.entities.InterviewResultEntity;
import finalproject.models.entities.ProfileEntity;
import finalproject.models.managers.APIManager;

import java.util.regex.Pattern;

public class SubmitController {
    private APIManager apiManager;

    public SubmitController(APIManager apiManager) {
        this.apiManager = apiManager;
    }


    public InterviewResultEntity submit(AnswerCollectionEntity ae) {
        InterviewResultEntity pe = apiManager.submit(ae);

        return pe;
    }

}
