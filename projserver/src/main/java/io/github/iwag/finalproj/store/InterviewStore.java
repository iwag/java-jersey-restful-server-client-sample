package io.github.iwag.finalproj.store;


import io.github.iwag.finalproj.models.entities.ExInterviewEntity;
import io.github.iwag.finalproj.models.entities.ExInterviewQuestionEntity;

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
            map.put("java", new ExInterviewEntity(5, 2, "Java", 20, list));
        }
        {
            List<ExInterviewQuestionEntity> list = Arrays.asList(new ExInterviewQuestionEntity(
                    "What does SQL stand for",
                    "Standard query language", "Special Query Language","Standard Question Language", "None",
                    1, 20, 4
            ), new ExInterviewQuestionEntity(
                    "when do you use select statement?",
                    "to update data", "to delete data","to get data", "to create data",
                    2, 21, 3
            ));
            map.put("sql", new ExInterviewEntity(5, 2, "Java", 20, list));
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
