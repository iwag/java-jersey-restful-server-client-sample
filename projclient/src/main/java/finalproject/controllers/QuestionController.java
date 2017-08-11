package finalproject.controllers;

import finalproject.models.entities.AnswerEntity;
import finalproject.models.entities.InterviewEntity;
import finalproject.models.entities.InterviewSelectionModel;
import finalproject.models.entities.Question;
import finalproject.models.managers.APIManager;

public class QuestionController {
    private APIManager apiManager;

    public QuestionController(APIManager apiManager) {
        this.apiManager = apiManager;
    }
    public InterviewEntity getQuestions(String topic) {
        InterviewSelectionModel selection = new InterviewSelectionModel(topic);
        return apiManager.getInterviewer(selection);
    }

    AnswerEntity collectResponse() {
        return null;
    }
}
