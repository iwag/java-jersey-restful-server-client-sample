package io.github.iwag.finalproj.models.interfaces;

import io.github.iwag.finalproj.models.entities.*;
import io.github.iwag.finalproj.models.entities.InterviewEntity;
import io.github.iwag.finalproj.models.requestmodels.CredientialRequestModel;
import io.github.iwag.finalproj.models.requestmodels.SubmitRequestModel;
import io.github.iwag.finalproj.models.requestmodels.UserRequestModel;
import io.github.iwag.finalproj.models.responsemodels.*;

public class InterviewerMapper {

    public static UserRequestModel convert(UserEntity ue, MapFunction<UserEntity, UserRequestModel> mapper) {
        return mapper.convert(ue);
    }

    public static ProfileEntity convert(UserResponseModel ue, MapFunction<UserResponseModel, ProfileEntity> mapper) {
        return mapper.convert(ue);
    }

    public static CredientialRequestModel convertToCredientialRequestModel(CredientialEntity ce, MapFunction<CredientialEntity, CredientialRequestModel> mapper) {
        return mapper.convert(ce);
    }

    public static ProfileEntity convertToProfileEntity(CredientialResponseModel ue, MapFunction<CredientialResponseModel, ProfileEntity> mapper) {
        return mapper.convert(ue);
    }

    public static SubmitRequestModel convertToSubmitRequestModel(AnswerCollectionEntity ace, MapFunction<AnswerCollectionEntity, SubmitRequestModel> mapper) {
        return mapper.convert(ace);
    }

    public static InterviewResultEntity convertToInterviewResultEntity(SubmitResponseModel submitResponseModel, MapFunction<SubmitResponseModel, InterviewResultEntity> mapper) {
        return mapper.convert(submitResponseModel);
    }

    public static HistoryEntity convertToHistoryEntity(HistoryResponseModel historyResponseModel, MapFunction<HistoryResponseModel, HistoryEntity> mapper) {
        return mapper.convert(historyResponseModel);
    }

    public static InterviewEntity convertToInterviewEntity(InterviewResponseModel interviewResponseModel, MapFunction<InterviewResponseModel, InterviewEntity> mapper) {
        return mapper.convert(interviewResponseModel);

    }
}
