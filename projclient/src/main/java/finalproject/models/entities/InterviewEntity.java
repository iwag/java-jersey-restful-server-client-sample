package finalproject.models.entities;

import java.util.List;

public class InterviewEntity {

    private Integer interviewId;
    private Integer questions;
    private String topic;
    private Integer duration;

    List<InterviewQuestionEntity> interviewQuestions;

    public InterviewEntity(Integer interviewId, Integer questions, String topic, Integer duration, List<InterviewQuestionEntity> interviewQuestions) {
        this.interviewId = interviewId;
        this.questions = questions;
        this.topic = topic;
        this.duration = duration;
        this.interviewQuestions = interviewQuestions;
    }
}
