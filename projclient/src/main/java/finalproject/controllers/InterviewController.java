package finalproject.controllers;

import finalproject.models.entities.*;
import finalproject.models.managers.APIManager;
import finalproject.models.managers.CredentialManager;

import java.util.LinkedList;
import java.util.Scanner;

public class InterviewController {
    private APIManager apiManager;

    public InterviewController(APIManager apiManager) {
        this.apiManager = apiManager;
    }

    public void interview(InterviewEntity interviewEntity, CredentialManager credentialManager) {

        if (interviewEntity==null) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        LinkedList<AnswerEntity> answerEntities = new LinkedList<>();
        InterviewTimer timer = new InterviewTimer(interviewEntity.getDuration()*60);
        String topic = interviewEntity.getTopic();

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

}
