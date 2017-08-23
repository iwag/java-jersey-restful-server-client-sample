package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.models.entities.ExInterviewEntity;
import io.github.iwag.finalproj.models.entities.ExInterviewQuestionEntity;
import io.github.iwag.finalproj.models.entities.InterviewEntity;
import io.github.iwag.finalproj.models.entities.InterviewQuestionEntity;
import io.github.iwag.finalproj.models.requestmodels.SubmitAnswerModel;
import io.github.iwag.finalproj.models.requestmodels.SubmitRequestModel;
import io.github.iwag.finalproj.models.responsemodels.ErrorResponseModel;
import io.github.iwag.finalproj.models.responsemodels.InterviewQuestionResponseModel;
import io.github.iwag.finalproj.models.responsemodels.InterviewResponseModel;
import io.github.iwag.finalproj.models.responsemodels.SubmitResponseModel;
import io.github.iwag.finalproj.store.Stores;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class Interviews {

    @ExceptionHandler({ OurApplicationException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
            OurApplicationException ex, WebRequest request) {
        return new ResponseEntity<Object>(new ErrorResponseModel(ex.getStatus().toString(), ex.getMessage()), new HttpHeaders(), ex.getStatus());
    }

    public Interviews() {
    }

    @RequestMapping(method = RequestMethod.GET, path = "/interview/topics/{topic}", produces = MediaType.APPLICATION_JSON_VALUE)
    public InterviewResponseModel getJSON(@PathVariable("topic") String topic) {
        ExInterviewEntity ex = Stores.interviewStore.getByTopic(topic);
        if (ex==null) throw new OurApplicationException(HttpStatus.BAD_REQUEST, "bad request");

        List<InterviewQuestionResponseModel> list = new LinkedList<>();
        for (ExInterviewQuestionEntity qe : ex.getInterviewQuestions() ) {
            InterviewQuestionResponseModel qrm = new InterviewQuestionResponseModel(qe.getDescription(), qe.getItem1(), qe.getItem2(), qe.getItem3(), qe.getItem4(), qe.getDifficultyLevel().toString(), qe.getQuestionId().toString());
            list.add(qrm);
        }

        InterviewResponseModel interviewResponseModel = new InterviewResponseModel(ex.getInterviewId().toString(), ex.getQuestions().toString(), ex.getTopic(), ex.getDuration().toString(), list);

        return interviewResponseModel;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/interview/{interviewid}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public SubmitResponseModel getJSON(@PathVariable("interviewid") String sinterviewid, @RequestBody SubmitRequestModel requestModel) {
        String auth = "";
        if (sinterviewid == null || auth == null || !requestModel.validate()) {
            throw new OurApplicationException(HttpStatus.BAD_REQUEST, "bad request");
        }
        // check auth
        if (!Stores.userStore.isAuth(Integer.valueOf(requestModel.getUserId()), auth)) {
            throw new OurApplicationException(HttpStatus.UNAUTHORIZED, "auth failed");
        }

        Integer interviewId = Integer.valueOf(sinterviewid);
        ExInterviewEntity ex= Stores.interviewStore.getByInterviewId(interviewId);
        if (ex==null) {
            throw new OurApplicationException(HttpStatus.NOT_FOUND, "interview not found");
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
