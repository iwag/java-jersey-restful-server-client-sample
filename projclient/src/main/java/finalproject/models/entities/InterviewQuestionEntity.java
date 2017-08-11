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

    @Override
    public String toString() {
        return "InterviewQuestionEntity{" +
                "description='" + description + '\'' +
                ", item1='" + item1 + '\'' +
                ", item2='" + item2 + '\'' +
                ", item3='" + item3 + '\'' +
                ", item4='" + item4 + '\'' +
                ", difficultyLevel=" + difficultyLevel +
                ", questionId=" + questionId +
                '}';
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public String getItem1() {
        return item1;
    }

    public String getItem2() {
        return item2;
    }

    public String getItem3() {
        return item3;
    }

    public String getItem4() {
        return item4;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }
}
