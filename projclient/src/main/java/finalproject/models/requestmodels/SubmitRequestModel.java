package finalproject.models.requestmodels;

import finalproject.models.entities.AnswerEntity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class SubmitRequestModel {
    private List<SubmitAnswerModel> respnonses;

    public SubmitRequestModel() {

    }

    public SubmitRequestModel(List<SubmitAnswerModel> respnonses) {
        this.respnonses = respnonses;
    }

    public List<SubmitAnswerModel> getRespnonses() {
        return respnonses;
    }

    public void setRespnonses(List<SubmitAnswerModel> respnonses) {
        this.respnonses = respnonses;
    }
}
