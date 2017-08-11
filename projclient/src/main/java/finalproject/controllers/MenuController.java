package finalproject.controllers;

import finalproject.models.entities.*;
import finalproject.models.managers.CredentialManager;
import finalproject.models.managers.APIManager;

import java.util.LinkedList;
import java.util.Scanner;

public class MenuController {
    public static boolean mainMenu(APIManager apiManager, CredentialManager credentialManager) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Welcome to the Mock-up Interview:");
            System.out.println("* Login if you have already registered [Press L] ");
            System.out.println("* Register if you are the first time user [Press R] ");
            System.out.println("* Terminate the application [Press T]");
            String key = scanner.next();
            if (key.startsWith("L")) {
                if (login(apiManager, credentialManager)) {
                    break;
                }
            } else if (key.startsWith("R")) {
                registration(apiManager, credentialManager);
            } else if (key.startsWith("T")) {
                System.out.println("terminate");
                return true;
            }

        } while (true);
        return false;
    }

    public static void interviewMenu(APIManager apiManager, CredentialManager credentialManager) {
        Scanner scanner = new Scanner(System.in);
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
                interview("Java", apiManager, credentialManager);
            } else if (key.startsWith("S")) {
                interview("SQL", apiManager, credentialManager);
            } else if (key.startsWith("H")) {
                history(apiManager, credentialManager);
            }

        } while (true);
    }

    private static void history(APIManager apiManager, CredentialManager credentialManager) {
        if (credentialManager.getPe() == null) {
            System.out.println("You have to login. Thank you");
            return ;
        }
        HistoryController historyController = new HistoryController(apiManager);
        HistoryEntity he = historyController.history(credentialManager.getPe());
        System.err.print(he);
    }

    private static void interview(String topic, APIManager apiManager, CredentialManager credentialManager) {
        if (credentialManager.getPe() == null) {
            System.out.println("You have to login. Thank you");
            return ;
        }

        QuestionController questionController = new QuestionController(apiManager);
        InterviewEntity interviewEntity = questionController.getQuestions(topic);
        Scanner scanner = new Scanner(System.in);
        LinkedList<AnswerEntity> answerEntities = new LinkedList<>();
        InterviewTimer timer = new InterviewTimer(interviewEntity.getDuration()*60);

        if (interviewEntity==null) {
            return;
        }

        System.out.println("Welcome to " + topic + " interview Questions. ");
        System.out.println("You will be shown " + interviewEntity.getQuestions() + " Java questions. ");
        System.out.println("* When ready, write start to begin the interview");
        timer.start();
        int i =0;
        for (InterviewQuestionEntity qe : interviewEntity.getInterviewQuestions()) {
            if (timer.left() < 300) {
                System.out.println("You have " + (timer.left()/60) + " min");
            }
            if (timer.left() < 0) {
                break;
            }

            i++;
            System.out.println("Question" + i + " " + qe.getDescription());
            System.out.println("1)" + qe.getItem1());
            System.out.println("2)" + qe.getItem2());
            System.out.println("3)" + qe.getItem3());
            System.out.println("4)" + qe.getItem4());
            String key = "";
            do {
                System.out.println("Enter your answer or enter S to skip. You cannot come back to a skipped or answered question.");
                key = scanner.next();
            } while (!key.startsWith("1") && !key.startsWith("2") && !key.startsWith("3") && !key.startsWith("4") && !key.startsWith("S"));
            if (key.startsWith("S")) {
                continue;
            } else {
                AnswerEntity ae = new AnswerEntity(qe.getQuestionId().toString(), Integer.valueOf(key).toString());
                answerEntities.add(ae);
            }
        }

        // commit answers
        SubmitController submitController = new SubmitController(apiManager);
        AnswerCollectionEntity answerCollection = new AnswerCollectionEntity(answerEntities, interviewEntity.getInterviewId(), credentialManager.getPe().getUserId());
        InterviewResultEntity res = submitController.submit(credentialManager.getPe(), answerCollection);
        System.out.println(res);
    }

    private static boolean login(APIManager apiManager, CredentialManager credentialManager) {
        LoginController loginController = new LoginController(apiManager);
        ProfileEntity pe = loginController.login();
        if (pe!=null) {
            credentialManager.setPe(pe);
            System.err.println("login user " + pe);
            return true;
        } else {
            System.out.println("failed to login");
            return false;
        }
    }

    private static void registration(APIManager apiManager, CredentialManager credentialManager) {
        if (credentialManager.getPe() !=null)
            System.out.println("you're already logged in");

        RegistrationController registrationController = new RegistrationController(apiManager);
        ProfileEntity pe = registrationController.buildUser();
        if (pe!=null) {
            System.err.println("create user " + pe);
        } else {
            System.out.println("failed a registration");
        }
    }


}
