package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.models.entities.ExInterviewEntity;
import io.github.iwag.finalproj.models.requestmodels.SubmitAnswerModel;
import io.github.iwag.finalproj.models.requestmodels.SubmitRequestModel;
import io.github.iwag.finalproj.models.responsemodels.InterviewQuestionResponseModel;
import io.github.iwag.finalproj.models.responsemodels.InterviewResponseModel;
import io.github.iwag.finalproj.models.responsemodels.SubmitResponseModel;
import io.github.iwag.finalproj.store.Stores;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Path("interview")
public class InterviewResults {
    public InterviewResults() {
    }

    @POST
    @Path("{interviewid}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @HeaderParam("auth")
    public SubmitResponseModel getJSON(@PathParam("interviewid") String sinterviewid, @HeaderParam("auth") String auth, SubmitRequestModel requestModel) {
        // check auth
        if(!Stores.userStore.isAuth(Integer.valueOf(requestModel.getUserId()), auth)) {
            throw new BadRequestException();
        }

        Integer interviewId = Integer.valueOf(sinterviewid);
        ExInterviewEntity ex= Stores.interviewStore.getByInterviewId(interviewId);
        if (ex==null) throw new BadRequestException();

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
