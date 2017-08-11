package finalproject.store;

import finalproject.models.entities.ExInterviewEntity;
import finalproject.models.entities.ExInterviewQuestionEntity;
import finalproject.models.responsemodels.InterviewQuestionResponseModel;
import finalproject.models.responsemodels.InterviewResponseModel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewStore {

    private static Map<String, ExInterviewEntity> map;

    public InterviewStore() {
        map = new HashMap<>();
        {
            List<ExInterviewQuestionEntity> list = Arrays.asList(new ExInterviewQuestionEntity(
                    "What the southern neighbour of the United States? ",
                    "Canada", "Alaska","Mexico", "Panama",
                    1, 20, 1
            ), new ExInterviewQuestionEntity(
                    "What the capital of Mexico? ",
                    "Mexico", "Indiana","Havana", "Mexico City",
                    2, 21, 3
            ));
            map.put("Java", new ExInterviewEntity(5, 2, "Java", 20, list));
        }
    }

    public ExInterviewEntity getByInterviewId(Integer id) {
        for (ExInterviewEntity ex:map.values()) {
            if (ex.getInterviewId() == id ) {
                return ex;
            }
        }
        return null;
    }

    private ExInterviewQuestionEntity getByInterviewIdAndQuestionId(Integer interviewId, Integer questionId) {
        ExInterviewEntity ex = getByInterviewId(interviewId);
        for (ExInterviewQuestionEntity qe : ex.getInterviewQuestions()) {
            if (qe.getQuestionId() == questionId) {
                return qe;
            }
        }
        return null;
    }

    public boolean correct(Integer interviewId, Integer questionId, String response) {
        ExInterviewQuestionEntity qe = getByInterviewIdAndQuestionId(interviewId, questionId);
        return qe.correct(response);
    }

    public ExInterviewEntity getByTopic(String topic) {
        return map.get(topic);
    }
}
