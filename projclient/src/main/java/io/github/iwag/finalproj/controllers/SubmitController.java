package io.github.iwag.finalproj.controllers;


import io.github.iwag.finalproj.models.entities.*;
import managers.APIManager;
import managers.CredentialManager;

import java.time.LocalDate;

public class SubmitController {
    private APIManager apiManager;
    private CredentialManager credentialManager;

    public SubmitController(APIManager apiManager, CredentialManager credentialManager) {
        this.apiManager = apiManager;
        this.credentialManager = credentialManager;
    }


    public InterviewResultEntity submit(AnswerCollectionEntity ae) {
        ProfileEntity pe = credentialManager.getPe();
        InterviewResultEntity re = apiManager.submit(ae, credentialManager.getPe().getAuthToken());
        if (re==null) return null;
        System.out.printf("Dear %s %s. Here is your result:\r\n", pe.getUserEntity().getFirstName(), pe.getUserEntity().getLastName());
        System.out.println("Date of Test: " + LocalDate.now().toString() + " Your score: " + re.getScore());
        System.out.printf(" Total number of questions: %d\r\n", re.getQuestions());
        System.out.printf(" Correct responses: %d\r\n",re.getCorrectAnswer());
        System.out.printf(" Wrong responses: %d Skipped responses: %d\r\n", re.getCorrectAnswer(), re.getSkippedAnswer());

        return re;
    }

}
