package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.models.entities.HistoryEntity;
import io.github.iwag.finalproj.models.entities.HistoryEntryEntity;
import io.github.iwag.finalproj.models.entities.ProfileEntity;
import managers.APIManager;
import managers.CredentialManager;

public class HistoryController {
    private APIManager apiManager;
    private CredentialManager credentialManager;


    public HistoryController(APIManager apiManager, CredentialManager credentialManager) {
        this.apiManager = apiManager;
        this.credentialManager = credentialManager;
    }

    public HistoryEntity history(ProfileEntity pe) {

        HistoryEntity hi = apiManager.history(pe.getUserId(), credentialManager.getPe().getAuthToken());

        for (HistoryEntryEntity he : hi.getList()) {
            System.out.println(he.getTopic() + " Interview");
            System.out.println(he.getDate());
            System.out.println("Score: "+he.getScore());
            System.out.println("=================");
        }

        return hi;
    }
}
