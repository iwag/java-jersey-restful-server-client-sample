package io.github.iwag.finalproj.models.responsemodels;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SubmitResponseModel {
    private String interviewid;
    private String questions;
    private String correct_answer;
    private String wrong_answer;
    private String skipped_answer;
    private String topic;
    private String duration;
    private String score;

    public SubmitResponseModel() {}

    public SubmitResponseModel(String interviewid, String questions, String correct_answer, String wrong_answer, String skipped_answer, String topic, String duration, String score) {
        this.interviewid = interviewid;
        this.questions = questions;
        this.correct_answer = correct_answer;
        this.wrong_answer = wrong_answer;
        this.skipped_answer = skipped_answer;
        this.topic = topic;
        this.duration = duration;
        this.score = score;
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

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String getWrong_answer() {
        return wrong_answer;
    }

    public void setWrong_answer(String wrong_answer) {
        this.wrong_answer = wrong_answer;
    }

    public String getSkipped_answer() {
        return skipped_answer;
    }

    public void setSkipped_answer(String skipped_answer) {
        this.skipped_answer = skipped_answer;
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
}
