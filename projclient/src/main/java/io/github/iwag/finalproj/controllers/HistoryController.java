package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.models.entities.HistoryEntity;
import io.github.iwag.finalproj.models.entities.HistoryEntryEntity;
import io.github.iwag.finalproj.models.entities.ProfileEntity;
import managers.APIManager;

public class HistoryController {
    private APIManager apiManager;

    public HistoryController(APIManager apiManager) {
        this.apiManager = apiManager;
    }

    public HistoryEntity history(ProfileEntity pe) {

        HistoryEntity hi = apiManager.history(pe.getUserId());

        for (HistoryEntryEntity he : hi.getList()) {
            System.out.println(he.getTopic() + " Interview");
            System.out.println(he.getDate());
            System.out.println("Score: "+he.getScore());
            System.out.println("=================");
        }

        return hi;
    }
}
