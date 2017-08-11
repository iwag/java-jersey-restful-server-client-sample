package finalproject.models.entities;

import java.util.List;

public class ExInterviewEntity {
    private Integer interviewId;
    private Integer questions;
    private String topic;
    private Integer duration;

    private List<ExInterviewQuestionEntity> interviewQuestions;

    public ExInterviewEntity(Integer interviewId, Integer questions, String topic, Integer duration, List<ExInterviewQuestionEntity> interviewQuestions) {
        this.interviewId = interviewId;
        this.questions = questions;
        this.topic = topic;
        this.duration = duration;
        this.interviewQuestions = interviewQuestions;
    }

    public Integer getInterviewId() {
        return interviewId;
    }

    public Integer getQuestions() {
        return questions;
    }

    public String getTopic() {
        return topic;
    }

    public Integer getDuration() {
        return duration;
    }

    public List<ExInterviewQuestionEntity> getInterviewQuestions() {
        return interviewQuestions;
    }
}
