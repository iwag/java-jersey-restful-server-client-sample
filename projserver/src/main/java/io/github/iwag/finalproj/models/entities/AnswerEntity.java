package io.github.iwag.finalproj.models.entities;

public class AnswerEntity {
    private String questionId;
    private String response;

    public AnswerEntity(String questionId, String response) {
        this.questionId = questionId;
        this.response = response;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
