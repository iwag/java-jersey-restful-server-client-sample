package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.models.entities.*;
import managers.CredentialManager;
import managers.APIManager;

import java.util.Scanner;

public class MenuController {
    public static boolean mainMenu(APIManager apiManager, CredentialManager credentialManager) {
        Scanner scanner = new Scanner(System.in);
        LoginController loginController = new LoginController(apiManager);
        RegistrationController registrationController = new RegistrationController(apiManager);
        InterviewSelectionController interviewSelectionController = new InterviewSelectionController(apiManager);
        InterviewController interviewController = new InterviewController(apiManager);

        do {
            System.out.println("Welcome to the Mock-up Interview:");
            System.out.println("* Login if you have already registered [Press L] ");
            System.out.println("* Register if you are the first time user [Press R] ");
            System.out.println("* Terminate the application [Press T]");
            String key = scanner.next();
            if (key.startsWith("L")) {
                ProfileEntity pe = loginController.login();
                if (pe !=null) {
                    credentialManager.setPe(pe);
                    break;
                } else {
                    System.out.println("failed to login");
                }
            } else if (key.startsWith("R")) {
                ProfileEntity pe = registrationController.buildUser();
                if (pe!=null) {
                    System.err.println("create user " + pe);
                } else {
                    System.out.println("failed a registration");
                }
            } else if (key.startsWith("T")) {
                System.out.println("terminate");
                return true;
            }

        } while (true);

        do {
            InterviewEntity ie = interviewSelectionController.interview(credentialManager);
            if (ie != null) {
                interviewController.interview(ie, credentialManager);
            } else {
                break;
            }
        } while (true);

        return false;
    }

}
