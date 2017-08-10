package finalproject.models.entities;

import java.util.List;
public class AnswerCollectionEntity {
    private List<AnswerEntity> respnonses;
    private Integer id;

    public AnswerCollectionEntity() {

    }


    public AnswerCollectionEntity(List<AnswerEntity> respnonses, Integer id) {
        this.respnonses = respnonses;
        this.id = id;
    }

    public List<AnswerEntity> getRespnonses() {
        return respnonses;
    }

    public void setRespnonses(List<AnswerEntity> respnonses) {
        this.respnonses = respnonses;
    }

    public Integer getId() {
        return id;
    }
}
