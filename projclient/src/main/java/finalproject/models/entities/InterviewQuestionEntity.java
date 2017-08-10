package finalproject.models.entities;

public class InterviewQuestionEntity {
    private String description;
    private String item1;
    private String item2;
    private String item3;
    private String item4;
    private Integer difficultyLevel;
    private Integer questionId;

    public InterviewQuestionEntity(String description, String item1, String item2, String item3, String item4, Integer difficultyLevel, Integer questionId) {
        this.description = description;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.difficultyLevel = difficultyLevel;
        this.questionId = questionId;
    }
}
