package io.github.iwag.finalproj.models.requestmodels;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SubmitAnswerModel {
    private String questionId;
    private String response;

    public SubmitAnswerModel() {
    }

    public SubmitAnswerModel(String questionId, String response) {
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
