package finalproject.views;


import finalproject.controllers.*;
import finalproject.models.entities.*;
import finalproject.models.managers.APIManager;
import finalproject.models.managers.CredentialManager;

import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws java.lang.Exception {
        APIManager apiManager = new APIManager();
        CredentialManager credentialManager = new CredentialManager();

        while (true) {
            boolean t = MenuController.mainMenu(apiManager, credentialManager);
            if (t) break;
            MenuController.interviewMenu(apiManager, credentialManager);
        }

        return ;
    }
}
