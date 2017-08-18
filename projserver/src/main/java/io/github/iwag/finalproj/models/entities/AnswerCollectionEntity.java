package io.github.iwag.finalproj.models.entities;

import java.util.Iterator;
import java.util.List;

public class AnswerCollectionEntity implements Iterable<AnswerEntity> {
    private List<AnswerEntity> respnonses;
    private Integer interviewId;
    private Integer userId;

    public AnswerCollectionEntity() {

    }


    public AnswerCollectionEntity(List<AnswerEntity> respnonses, Integer interviewId, Integer userId) {
        this.respnonses = respnonses;
        this.interviewId = interviewId;
        this.userId = userId;
    }

    public void setRespnonses(List<AnswerEntity> respnonses) {
        this.respnonses = respnonses;
    }

    public Integer getInterviewId() {
        return interviewId;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public Iterator<AnswerEntity> iterator() {
        return respnonses.iterator();
    }
}
