package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.interfaces.StringValidatePredicator;
import io.github.iwag.finalproj.models.entities.CredientialEntity;
import io.github.iwag.finalproj.models.entities.HistoryEntity;
import io.github.iwag.finalproj.models.entities.HistoryEntryEntity;
import io.github.iwag.finalproj.models.entities.ProfileEntity;
import io.github.iwag.finalproj.models.managers.APIManager;

import java.util.regex.Pattern;

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
