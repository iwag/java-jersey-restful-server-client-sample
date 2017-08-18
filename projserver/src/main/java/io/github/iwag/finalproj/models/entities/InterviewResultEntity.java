package io.github.iwag.finalproj.models.entities;

public class InterviewResultEntity {

    private Integer interviewId;
    private Integer questions;
    private Integer correctAnswer;
    private Integer wrongAnswer;
    private Integer skippedAnswer;
    private String topic;
    private String duration;
    private String score;

    public InterviewResultEntity(Integer interviewId, Integer questions, Integer correctAnswer, Integer wrongAnswer, Integer skippedAnswer, String topic, String duration, String score) {
        this.interviewId = interviewId;
        this.questions = questions;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
        this.skippedAnswer = skippedAnswer;
        this.topic = topic;
        this.duration = duration;
        this.score = score;
    }

    public Integer getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(Integer interviewId) {
        this.interviewId = interviewId;
    }

    public Integer getQuestions() {
        return questions;
    }

    public void setQuestions(Integer questions) {
        this.questions = questions;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Integer getWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer(Integer wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }

    public Integer getSkippedAnswer() {
        return skippedAnswer;
    }

    public void setSkippedAnswer(Integer skippedAnswer) {
        this.skippedAnswer = skippedAnswer;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "InterviewResultEntity{" +
                "interviewId=" + interviewId +
                ", questions=" + questions +
                ", correctAnswer=" + correctAnswer +
                ", wrongAnswer=" + wrongAnswer +
                ", skippedAnswer=" + skippedAnswer +
                ", topic='" + topic + '\'' +
                ", duration='" + duration + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
