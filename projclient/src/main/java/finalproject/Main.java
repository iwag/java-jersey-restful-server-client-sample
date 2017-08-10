package finalproject;


import finalproject.controllers.HistoryController;
import finalproject.controllers.LoginController;
import finalproject.controllers.RegistrationController;
import finalproject.controllers.SubmitController;
import finalproject.models.entities.*;
import finalproject.models.managers.APIManager;

import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws java.lang.Exception {
        APIManager apiManager = new APIManager();
        RegistrationController registrationController = new RegistrationController(apiManager);
        ProfileEntity pe = registrationController.buildUser();
        System.out.println("create user " + pe);

        LoginController loginController = new LoginController(apiManager);
        ProfileEntity pe2 = loginController.login();
        System.out.println("login user " + pe2);

        SubmitController submitController = new SubmitController(apiManager);
        AnswerCollectionEntity ace = new AnswerCollectionEntity(Arrays.asList(new AnswerEntity("20", "aaa")), 5);
        InterviewResultEntity interviewResult = submitController.submit(ace);
        System.out.println("interview result " + interviewResult);

        HistoryController historyController = new HistoryController(apiManager);
        HistoryEntity he = historyController.history(pe2);
        System.out.println("history " + he);


        return ;
    }
}
