package finalproject.models.responsemodels;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InterviewQuestionResponseModel {
private String description;
    private String item1;
    private String item2;
    private String item3;
    private String item4;
    private String difficultyLevel;
    private String questionid;

    public InterviewQuestionResponseModel(String description, String item1, String item2, String item3, String item4, String difficultyLevel, String questionid) {
        this.description = description;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.difficultyLevel = difficultyLevel;
        this.questionid = questionid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getItem3() {
        return item3;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }

    public String getItem4() {
        return item4;
    }

    public void setItem4(String item4) {
        this.item4 = item4;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }
}
