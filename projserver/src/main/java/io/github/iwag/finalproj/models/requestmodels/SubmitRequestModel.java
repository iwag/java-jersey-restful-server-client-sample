package io.github.iwag.finalproj.models.requestmodels;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class SubmitRequestModel {
    private String userId;
    private List<SubmitAnswerModel> responses;

    public SubmitRequestModel() {
    }

    public SubmitRequestModel(String userId, List<SubmitAnswerModel> responses) {
        this.userId = userId;
        this.responses = responses;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<SubmitAnswerModel> getResponses() {
        return responses;
    }

    public void setResponses(List<SubmitAnswerModel> responses) {
        this.responses = responses;
    }

    public boolean validate() {
        return userId !=null;
    }

    @Override
    public String toString() {
        return "SubmitRequestModel{" +
                "userId='" + userId + '\'' +
                ", responses=" + responses +
                '}';
    }
}
