package managers;

import io.github.iwag.finalproj.models.entities.*;
import io.github.iwag.finalproj.models.interfaces.InterviewerMapper;
import io.github.iwag.finalproj.models.interfaces.MapperImplementation;
import io.github.iwag.finalproj.models.requestmodels.CredientialRequestModel;
import io.github.iwag.finalproj.models.requestmodels.SubmitRequestModel;
import io.github.iwag.finalproj.models.requestmodels.UserRequestModel;
import io.github.iwag.finalproj.models.responsemodels.*;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


public class APIManager {
    private Client client = ClientBuilder.newClient();

    private String baseUrl = "http://localhost:8080";
//    private String baseUrl = "https://calm-wave-21290.herokuapp.com/";

    public ProfileEntity createUser(UserEntity ue) {
        // UserEntity => UserRequestModel
        UserRequestModel userRequestModel = InterviewerMapper.convert(ue, MapperImplementation::convertUserRequestModel);

        // send a request (POST) & get a response
        WebTarget webTarget = client.target(baseUrl).path("/users");

        UserResponseModel userResponseModel = null;
        try {
            Entity<?> entity = Entity.entity(userRequestModel, MediaType.APPLICATION_JSON);
            userResponseModel = webTarget.request(MediaType.APPLICATION_JSON).accept("application/json").post(entity, UserResponseModel.class);
        } catch (BadRequestException e) {
            return null;
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
        WebTarget webTarget = client.target(baseUrl).path("/users/login");

        CredientialResponseModel credientialResponseModel = null;
        try {
            Entity<?> entity = Entity.entity(requestModel, MediaType.APPLICATION_JSON);
            credientialResponseModel = webTarget.request(MediaType.APPLICATION_JSON)
                    .accept("application/json").post(entity, CredientialResponseModel.class);
        } catch (BadRequestException e) {
            return null;
    } catch (NotAuthorizedException e) {
        return null;
    }

        // UserResponseModel => ProfileEntity
        return InterviewerMapper.convertToProfileEntity(credientialResponseModel, MapperImplementation::convertToProfileEntity);
    }

    public InterviewEntity getInterviewer(InterviewSelectionModel model) {
        // InterviewSelectionModel => InterviewSelectionRequestModel
        // send a request (GET) & get a response
        WebTarget webTarget = client.target(baseUrl).path("/interview/topics/" + model.getTopics());

        InterviewResponseModel interviewResponseModel = null;
        try {
            interviewResponseModel = webTarget.request(MediaType.APPLICATION_JSON).accept("application/json").get(InterviewResponseModel.class);
        } catch (BadRequestException e) {
            return null;
        } catch (NotAuthorizedException e) {
            return null;
        }
        return InterviewerMapper.convertToInterviewEntity(interviewResponseModel, MapperImplementation::convertToInterviewEntity);
   }

    public InterviewResultEntity submit(AnswerCollectionEntity ace, String auth) {
        // AnswerCollectionEntity => SubmitRequestModel
        SubmitRequestModel requestModel = InterviewerMapper.convertToSubmitRequestModel(ace, MapperImplementation::convertToSubmitRequestModel);

        // send a request (POST) & get a response
        WebTarget webTarget = client.target(baseUrl).path("/interview/" + ace.getInterviewId());

        SubmitResponseModel submitResponseModel = null;
        try {
            Entity<?> entity = Entity.entity(requestModel, MediaType.APPLICATION_JSON);
            submitResponseModel = webTarget.request(MediaType.APPLICATION_JSON)
                    .header("auth", auth)
                    .accept("application/json").post(entity, SubmitResponseModel.class);
        } catch (BadRequestException e) {
            return null;
        } catch (NotAuthorizedException e) {
            return null;
        }

        // SubmitResponseModel => InterviewResultEntity
        return InterviewerMapper.convertToInterviewResultEntity(submitResponseModel, MapperImplementation::convertToInterviewResultEntity);
    }

    public HistoryEntity history(Integer userId, String auth) {
        // send a request (GET) & get a response
        WebTarget webTarget = client.target(baseUrl).path("/interview/history/user/" + userId);

        HistoryResponseModel historyResponseModel = null;
        try {
            historyResponseModel = webTarget.request(MediaType.APPLICATION_JSON)
                    .header("auth", auth)
                    .accept("application/json").get(HistoryResponseModel.class);
        } catch (BadRequestException e) {
            return null;
        } catch (NotAuthorizedException e) {
            return null;
        }
        return InterviewerMapper.convertToHistoryEntity(historyResponseModel, MapperImplementation::convertToHistoryEntity);
    }

}
