package finalproject.controllers;

import finalproject.interfaces.StringValidatePredicator;
import finalproject.models.entities.AnswerCollectionEntity;
import finalproject.models.entities.CredientialEntity;
import finalproject.models.entities.InterviewResultEntity;
import finalproject.models.entities.ProfileEntity;
import finalproject.models.managers.APIManager;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class SubmitController {
    private APIManager apiManager;

    public SubmitController(APIManager apiManager) {
        this.apiManager = apiManager;
    }


    public InterviewResultEntity submit(ProfileEntity pe, AnswerCollectionEntity ae) {
        InterviewResultEntity re = apiManager.submit(ae);

        System.out.printf("Dear %s %s. Here is your result:\n", pe.getUserEntity().getFirstName(), pe.getUserEntity().getLastName());
        System.out.println("Date of Test: " + LocalDate.now().toString() + " Your score: " + re.getScore());
        System.out.printf(" Total number of questions: %d\n", re.getQuestions());
        System.out.printf(" Correct responses: %d\n",re.getCorrectAnswer());
        System.out.printf(" Wrong responses: %d Skipped responses: %d The level of\n", re.getCorrectAnswer(), re.getSkippedAnswer());

        return re;
    }

}
