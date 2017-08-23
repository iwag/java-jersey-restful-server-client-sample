package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.models.entities.*;
import managers.APIManager;
import managers.CredentialManager;

import java.util.Scanner;

public class InterviewSelectionController {
    private APIManager apiManager;

    public InterviewSelectionController(APIManager apiManager) {
        this.apiManager = apiManager;
    }

    public InterviewEntity interview(CredentialManager credentialManager) {

        Scanner scanner = new Scanner(System.in);
        InterviewEntity ie = null;
        do {
            System.out.println("Welcome to the Mock-up Interview:");
            System.out.println("* Start an interview in Java [Press J]");
            System.out.println("* Start an interview in SQL[Press S]");
            System.out.println("* See the history of past interviews [Press H] * Return to Main Menu [Press M]            ");
            String key = scanner.next();
            if (key.startsWith("M")) {
                System.out.println("return");
                break;
            } else if (key.startsWith("J")) {
                ie = interview("Java", apiManager, credentialManager);
            } else if (key.startsWith("S")) {
                ie = interview("SQL", apiManager, credentialManager);
            } else if (key.startsWith("H")) {
                history(apiManager, credentialManager);
            }

        } while (ie == null);
        return ie;
    }
    private static void history(APIManager apiManager, CredentialManager credentialManager) {
        if (credentialManager.getPe() == null) {
            System.out.println("You have to login. Thank you");
            return ;
        }
        HistoryController historyController = new HistoryController(apiManager, credentialManager);
        HistoryEntity he = historyController.history(credentialManager.getPe());
        System.err.print(he);
    }

    private static InterviewEntity interview(String topic, APIManager apiManager, CredentialManager credentialManager) {
        if (credentialManager.getPe() == null) {
            System.out.println("You have to login. Thank you");
            return null;
        }

        InterviewSelectionModel selection = new InterviewSelectionModel(topic);
        InterviewEntity interviewEntity =  apiManager.getInterviewer(selection);

        return interviewEntity;
    }

}
