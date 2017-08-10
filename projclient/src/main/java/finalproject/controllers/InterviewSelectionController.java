package finalproject.controllers;

import finalproject.models.entities.HistoryEntity;
import finalproject.models.entities.InterviewEntity;
import finalproject.models.entities.InterviewSelectionModel;
import finalproject.models.entities.ProfileEntity;
import finalproject.models.managers.APIManager;

import java.util.Scanner;

public class InterviewSelectionController {
    private APIManager apiManager;

    public InterviewSelectionController(APIManager apiManager) {
        this.apiManager = apiManager;
    }

    public InterviewEntity history() {

        Scanner scanner = new Scanner(System.in);
//        String topic = scanner.next();
        String topic = "Java";

        InterviewSelectionModel selectionModel = new InterviewSelectionModel(topic);
        return apiManager.interview(selectionModel);
    }
}
