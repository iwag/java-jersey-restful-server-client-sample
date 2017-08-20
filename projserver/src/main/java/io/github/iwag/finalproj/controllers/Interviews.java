package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.models.entities.ExInterviewEntity;
import io.github.iwag.finalproj.models.entities.ExInterviewQuestionEntity;
import io.github.iwag.finalproj.models.entities.InterviewEntity;
import io.github.iwag.finalproj.models.entities.InterviewQuestionEntity;
import io.github.iwag.finalproj.models.requestmodels.SubmitAnswerModel;
import io.github.iwag.finalproj.models.requestmodels.SubmitRequestModel;
import io.github.iwag.finalproj.models.responsemodels.InterviewQuestionResponseModel;
import io.github.iwag.finalproj.models.responsemodels.InterviewResponseModel;
import io.github.iwag.finalproj.models.responsemodels.SubmitResponseModel;
import io.github.iwag.finalproj.store.Stores;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Path("interview")
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

    @POST
    @Path("{interviewid}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public SubmitResponseModel getJSON(@PathParam("interviewid") String sinterviewid, @HeaderParam("auth") String auth, SubmitRequestModel requestModel) {
        if (sinterviewid == null || auth == null || !requestModel.validate()) {
            throw new OurApplicationException(Response.Status.BAD_REQUEST.getStatusCode(), "bad request");
        }
        // check auth
        if (!Stores.userStore.isAuth(Integer.valueOf(requestModel.getUserId()), auth)) {
            throw new OurApplicationException(Response.Status.UNAUTHORIZED.getStatusCode(), "auth failed");
        }

        Integer interviewId = Integer.valueOf(sinterviewid);
        ExInterviewEntity ex= Stores.interviewStore.getByInterviewId(interviewId);
        if (ex==null) {
            throw new OurApplicationException(Response.Status.NOT_FOUND.getStatusCode(), "interview not found");
        }

        Integer questions = ex.getQuestions();
        Integer correctAnswer = 0;
        Integer wrongAnswer = 0;
        Integer skippedAnswer = 0;
        String topic = ex.getTopic();
        String duration = ex.getDuration().toString();
        String score = "";

        for (SubmitAnswerModel sa : requestModel.getRespnonses()) {
            boolean res = Stores.interviewStore.correct(interviewId, Integer.valueOf(sa.getQuestionId()), sa.getResponse());
            if (res) {
                correctAnswer += 1;
            } else {
                wrongAnswer += 1;
            }
        }
        skippedAnswer = questions - correctAnswer - wrongAnswer;

        score = "" + correctAnswer + "/" + questions;

        SubmitResponseModel submitResponseModel = new SubmitResponseModel(interviewId.toString(), questions.toString(), correctAnswer.toString(), wrongAnswer.toString(), skippedAnswer.toString(), topic, duration, score);

        Stores.historyStore.addHistory(0, topic, LocalDate.now(), score);

        return submitResponseModel;
    }

}
