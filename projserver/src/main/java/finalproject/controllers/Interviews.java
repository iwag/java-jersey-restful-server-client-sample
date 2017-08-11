package finalproject.controllers;

import finalproject.models.entities.ExInterviewEntity;
import finalproject.models.entities.ExInterviewQuestionEntity;
import finalproject.models.entities.InterviewEntity;
import finalproject.models.entities.InterviewQuestionEntity;
import finalproject.models.responsemodels.InterviewQuestionResponseModel;
import finalproject.models.responsemodels.InterviewResponseModel;
import finalproject.store.Stores;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Path("topics")
public class Interviews {

    public Interviews() {
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{topic}")
    public InterviewResponseModel getJSON(@PathParam("topic") String topic) {
        ExInterviewEntity ex = Stores.interviewStore.getByTopic(topic);
        if (ex==null) throw new BadRequestException();

        List<InterviewQuestionResponseModel> list = new LinkedList<>();
        for (ExInterviewQuestionEntity qe : ex.getInterviewQuestions() ) {
            InterviewQuestionResponseModel qrm = new InterviewQuestionResponseModel(qe.getDescription(), qe.getItem1(), qe.getItem2(), qe.getItem3(), qe.getItem4(), qe.getDifficultyLevel().toString(), qe.getQuestionId().toString());
            list.add(qrm);
        }

        InterviewResponseModel interviewResponseModel = new InterviewResponseModel(ex.getInterviewId().toString(), ex.getQuestions().toString(), ex.getTopic(), ex.getDuration().toString(), list);


        return interviewResponseModel;
    }
}
