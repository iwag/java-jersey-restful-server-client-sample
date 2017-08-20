package io.github.iwag.finalproj.models.requestmodels;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class SubmitRequestModel {
    private String userId;
    private List<SubmitAnswerModel> respnonses;

    public SubmitRequestModel() {
    }

    public SubmitRequestModel(String userId, List<SubmitAnswerModel> respnonses) {
        this.userId = userId;
        this.respnonses = respnonses;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<SubmitAnswerModel> getRespnonses() {
        return respnonses;
    }

    public void setRespnonses(List<SubmitAnswerModel> respnonses) {
        this.respnonses = respnonses;
    }

    public boolean validate() {
        return userId !=null;
    }

    @Override
    public String toString() {
        return "SubmitRequestModel{" +
                "userId='" + userId + '\'' +
                ", respnonses=" + respnonses +
                '}';
    }
}
