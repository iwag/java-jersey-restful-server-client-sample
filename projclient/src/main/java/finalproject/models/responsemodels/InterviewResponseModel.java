package finalproject.models.responsemodels;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class InterviewResponseModel {

    private String interviewid;
    private String questions;
    private String topic;
    private String duration;

    List<InterviewQuestionResponseModel> interviewquestions;

    public InterviewResponseModel(String interviewid, String questions, String topic, String duration, List<InterviewQuestionResponseModel> interviewquestions) {
        this.interviewid = interviewid;
        this.questions = questions;
        this.topic = topic;
        this.duration = duration;
        this.interviewquestions = interviewquestions;
    }

    public String getInterviewid() {
        return interviewid;
    }

    public void setInterviewid(String interviewid) {
        this.interviewid = interviewid;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<InterviewQuestionResponseModel> getInterviewquestions() {
        return interviewquestions;
    }

    public void setInterviewquestions(List<InterviewQuestionResponseModel> interviewquestions) {
        this.interviewquestions = interviewquestions;
    }
}
