package finalproject.models.entities;

public class ExInterviewQuestionEntity extends InterviewQuestionEntity {
    private Integer answerNo;

    public ExInterviewQuestionEntity(String description, String item1, String item2, String item3, String item4, Integer difficultyLevel, Integer questionId, Integer answerNo) {
        super(description, item1, item2, item3, item4, difficultyLevel, questionId);
        this.answerNo = answerNo;
    }

    public Integer getAnswerNo() {
        return answerNo;
    }

    public boolean correct(String ans) {
        if (ans.equals(getItem1()) && answerNo == 1) {
            return true;
        } else if (ans.equals(getItem2()) && answerNo == 2) {
            return true;
        } else if (ans.equals(getItem3()) && answerNo == 3) {
            return true;
        } else if (ans.equals(getItem4()) && answerNo == 4) {
            return true;
        } else {
            return false;
        }
    }
}
