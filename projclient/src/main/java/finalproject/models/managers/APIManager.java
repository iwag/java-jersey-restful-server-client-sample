package finalproject.models.managers;

import finalproject.models.entities.*;
import finalproject.models.interfaces.InterviewerMapper;
import finalproject.models.interfaces.MapperImplementation;
import finalproject.models.requestmodels.CredientialRequestModel;
import finalproject.models.requestmodels.SubmitRequestModel;
import finalproject.models.requestmodels.UserRequestModel;
import finalproject.models.responsemodels.*;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class APIManager {
    private Client client = ClientBuilder.newClient();


    public ProfileEntity createUser(UserEntity ue) {
        // UserEntity => UserRequestModel
        UserRequestModel userRequestModel = InterviewerMapper.convert(ue, MapperImplementation::convertUserRequestModel);

        // send a request (POST) & get a response
        WebTarget webTarget = client.target("http://localhost:4567").path("/interview/users");

        UserResponseModel userResponseModel = null;
        try {
            Entity<?> entity = Entity.entity(userRequestModel, MediaType.APPLICATION_JSON);
            userResponseModel = webTarget.request(MediaType.APPLICATION_JSON).accept("application/json").post(entity, UserResponseModel.class);
        } catch (BadRequestException e) {
            throw e;
        }

        // UserResponseModel => ProfileEntity
        ProfileEntity pe = InterviewerMapper.convert(userResponseModel, MapperImplementation::convertToProfileEntity);

        // return result(ProfileEntity)
        return pe;
    }

    public ProfileEntity login(CredientialEntity ce) {
        // CredientialEntity => CredientialRequestModel
        CredientialRequestModel requestModel = InterviewerMapper.convertToCredientialRequestModel(ce, MapperImplementation::convertToCredientialRequestModel);

        // send a request (POST) & get a response
        WebTarget webTarget = client.target("http://localhost:4567").path("/interview/login");

        CredientialResponseModel credientialResponseModel = null;
        try {
            Entity<?> entity = Entity.entity(requestModel, MediaType.APPLICATION_JSON);
            credientialResponseModel = webTarget.request(MediaType.APPLICATION_JSON).accept("application/json").post(entity, CredientialResponseModel.class);
        } catch (BadRequestException e) {
            throw e;
        }

        // UserResponseModel => ProfileEntity
        return InterviewerMapper.convertToProfileEntity(credientialResponseModel, MapperImplementation::convertToProfileEntity);
    }

    public InterviewEntity getInterviewer(InterviewSelectionModel model) {
        // InterviewSelectionModel => InterviewSelectionRequestModel
        // send a request (GET) & get a response
        WebTarget webTarget = client.target("http://localhost:4567").path("/interview/topics/" + model.getTopics());

        InterviewResponseModel interviewResponseModel = null;
        try {
            interviewResponseModel = webTarget.request(MediaType.APPLICATION_JSON).accept("application/json").get(InterviewResponseModel.class);
        } catch (BadRequestException e) {
            throw e;
        }
        return InterviewerMapper.convertToInterviewEntity(interviewResponseModel, MapperImplementation::convertToInterviewEntity);
   }

    public InterviewResultEntity submit(AnswerCollectionEntity ace) {
        // AnswerCollectionEntity => SubmitRequestModel
        SubmitRequestModel requestModel = InterviewerMapper.convertToSubmitRequestModel(ace, MapperImplementation::convertToSubmitRequestModel);

        // send a request (POST) & get a response
        WebTarget webTarget = client.target("http://localhost:4567").path("/interview/" + ace.getId());

        SubmitResponseModel submitResponseModel = null;
        try {
            Entity<?> entity = Entity.entity(requestModel, MediaType.APPLICATION_JSON);
            submitResponseModel = webTarget.request(MediaType.APPLICATION_JSON).accept("application/json").post(entity, SubmitResponseModel.class);
        } catch (BadRequestException e) {
            throw e;
        }

        // SubmitResponseModel => InterviewResultEntity
        return InterviewerMapper.convertToInterviewResultEntity(submitResponseModel, MapperImplementation::convertToInterviewResultEntity);
    }

    public HistoryEntity history(Integer userId) {
        // send a request (GET) & get a response
        WebTarget webTarget = client.target("http://localhost:4567").path("/interview/history/user/" + userId);

        HistoryResponseModel historyResponseModel = null;
        try {
            historyResponseModel = webTarget.request(MediaType.APPLICATION_JSON).accept("application/json").get(HistoryResponseModel.class);
        } catch (BadRequestException e) {
            throw e;
        }
        return InterviewerMapper.convertToHistoryEntity(historyResponseModel, MapperImplementation::convertToHistoryEntity);
    }

    public InterviewEntity interview(InterviewSelectionModel interviewSelectionModel) {
        // send a request (GET) & get a response
        WebTarget webTarget = client.target("http://localhost:4567").path("/interview/topic/" + interviewSelectionModel.getTopics());

        InterviewResponseModel interviewResponseModel = null;
        try {
            interviewResponseModel = webTarget.request(MediaType.APPLICATION_JSON).accept("application/json").get(InterviewResponseModel.class);
        } catch (BadRequestException e) {
            throw e;
        }
        return InterviewerMapper.convertToInterviewEntity(interviewResponseModel, MapperImplementation::convertToInterviewEntity);
    }

}
