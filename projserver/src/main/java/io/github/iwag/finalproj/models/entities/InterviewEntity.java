package io.github.iwag.finalproj.models.entities;

import java.util.List;

public class InterviewEntity {

    private Integer interviewId;
    private Integer questions;
    private String topic;
    private Integer duration;

    private List<InterviewQuestionEntity> interviewQuestions;

    public InterviewEntity(Integer interviewId, Integer questions, String topic, Integer duration, List<InterviewQuestionEntity> interviewQuestions) {
        this.interviewId = interviewId;
        this.questions = questions;
        this.topic = topic;
        this.duration = duration;
        this.interviewQuestions = interviewQuestions;
    }

    @Override
    public String toString() {
        return "InterviewEntity{" +
                "interviewId=" + interviewId +
                ", questions=" + questions +
                ", topic='" + topic + '\'' +
                ", duration=" + duration +
                ", interviewQuestions=" + interviewQuestions +
                '}';
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

    public List<InterviewQuestionEntity> getInterviewQuestions() {
        return interviewQuestions;
    }
}
