package io.github.iwag.finalproj.views;


import io.github.iwag.finalproj.controllers.*;
import io.github.iwag.finalproj.models.entities.*;
import io.github.iwag.finalproj.models.managers.APIManager;
import io.github.iwag.finalproj.models.managers.CredentialManager;

import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws java.lang.Exception {
        APIManager apiManager = new APIManager();
        CredentialManager credentialManager = new CredentialManager();

        while (true) {
            boolean t = MenuController.mainMenu(apiManager, credentialManager);
            if (t) break;
        }

        return ;
    }
}
