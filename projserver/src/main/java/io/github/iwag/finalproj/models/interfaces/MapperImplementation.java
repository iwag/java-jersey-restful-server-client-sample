package io.github.iwag.finalproj.models.interfaces;

import io.github.iwag.finalproj.models.entities.*;
import io.github.iwag.finalproj.models.entities.InterviewEntity;
import io.github.iwag.finalproj.models.requestmodels.CredientialRequestModel;
import io.github.iwag.finalproj.models.requestmodels.SubmitAnswerModel;
import io.github.iwag.finalproj.models.requestmodels.SubmitRequestModel;
import io.github.iwag.finalproj.models.requestmodels.UserRequestModel;
import io.github.iwag.finalproj.models.responsemodels.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class MapperImplementation {
    public static UserRequestModel convertUserRequestModel(UserEntity ue) {
        return new UserRequestModel(ue.getFirstName(), ue.getLastName(), ue.getCountryLocation(), ue.getUserName(), ue.getPassword());
    }

    public static ProfileEntity convertToProfileEntity(UserResponseModel urm) {
        UserEntity ue = new UserEntity(urm.getFirstname(), urm.getLastname(), urm.getCountry(), urm.getUsername(), "");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);

        LocalDate date = LocalDate.parse(urm.getJoined(), formatter);

        return new ProfileEntity(ue, Integer.valueOf(urm.getUserId()), date, "");
    }

    public static CredientialRequestModel convertToCredientialRequestModel(CredientialEntity credientialEntity) {
        return new CredientialRequestModel();
    }

    public static ProfileEntity convertToProfileEntity(CredientialResponseModel crm) {
        UserEntity ue = new UserEntity(crm.getFirstname(), crm.getLastname(), crm.getCountry(), crm.getUsername(), "");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);

        LocalDate date = LocalDate.parse(crm.getJoined(), formatter);
        return new ProfileEntity(ue, Integer.valueOf(crm.getUserId()), date, crm.getAuthtoken());
    }

    public static SubmitRequestModel convertToSubmitRequestModel(AnswerCollectionEntity ace) {

        List<SubmitAnswerModel> list = new LinkedList<>();
        for (AnswerEntity a : ace) {
            SubmitAnswerModel b = new SubmitAnswerModel(a.getQuestionId(), a.getResponse());
            list.add(b);
        }
        return new SubmitRequestModel(ace.getInterviewId().toString(), list);
    }

    public static InterviewResultEntity convertToInterviewResultEntity(SubmitResponseModel submitResponseModel) {
        return new InterviewResultEntity(
                Integer.valueOf(submitResponseModel.getInterviewid()),
                Integer.valueOf(submitResponseModel.getQuestions()),
                Integer.valueOf(submitResponseModel.getCorrect_answer()),
                Integer.valueOf(submitResponseModel.getWrong_answer()),
                Integer.valueOf(submitResponseModel.getSkipped_answer()),
                submitResponseModel.getTopic(),
                submitResponseModel.getDuration(),
                submitResponseModel.getScore()
        );
    }

    public static HistoryEntity convertToHistoryEntity(HistoryResponseModel historyResponseModel) {
        List<HistoryEntryEntity> list = new LinkedList<>();
        for (HistoryEntryResponseModel a : historyResponseModel) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);

            LocalDate date = LocalDate.parse(a.getDate(), formatter);
            HistoryEntryEntity b = new HistoryEntryEntity(a.getTopic(), date, a.getScore());
            list.add(b);
        }

        return new HistoryEntity(list);
    }

    public static InterviewEntity convertToInterviewEntity(InterviewResponseModel interviewResponseModel) {

        List<InterviewQuestionEntity> list = new LinkedList<>();
        for (InterviewQuestionResponseModel a : interviewResponseModel) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);

            InterviewQuestionEntity b = new InterviewQuestionEntity(a.getDescription(), a.getItem1(), a.getItem2(), a.getItem3(), a.getItem4(),
                    Integer.valueOf(a.getDifficultyLevel()), Integer.valueOf(a.getQuestionid()));
            list.add(b);
        }

        return new InterviewEntity(Integer.valueOf(interviewResponseModel.getInterviewid()),
                Integer.valueOf(interviewResponseModel.getQuestions()),
                interviewResponseModel.getTopic(),
                Integer.valueOf(interviewResponseModel.getDuration()),
                list);
    }
}
