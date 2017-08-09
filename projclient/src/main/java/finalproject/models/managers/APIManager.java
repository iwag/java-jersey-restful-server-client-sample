package finalproject.models.managers;

import finalproject.models.entities.CredientialEntity;
import finalproject.models.entities.InterviewSelectionModel;
import finalproject.models.entities.ProfileEntity;
import finalproject.models.entities.UserEntity;
import finalproject.models.interfaces.InterviewerMapper;
import finalproject.models.interfaces.MapperImplementation;
import finalproject.models.requestmodels.CredientialEntityModel;
import finalproject.models.requestmodels.UserRequestModel;
import finalproject.models.responsemodels.CredientialResponseModel;
import finalproject.models.responsemodels.UserResponseModel;

public class APIManager {
    public ProfileEntity createUser(UserEntity ue) {
        // UserEntity => UserRequestModel
        UserRequestModel userRequestModel = InterviewerMapper.convert(ue, MapperImplementation::convertUserRequestModel);

        // send a request (POST)

        // get a response

        // UserResponseModel => ProfileEntity
        UserResponseModel userResponseModel = null;
        ProfileEntity pe = InterviewerMapper.convert(userResponseModel, MapperImplementation::convertToProfileEntity);

        // return result(ProfileEntity)
        return pe;
    }

    public ProfileEntity login(CredientialEntity ce) {
        // CredientialEntity => CredientialRequestModel
        CredientialEntityModel requestModel = InterviewerMapper.convertToCredientialRequestModel(ce, MapperImplementation::convertToCredientialRequestModel);

        // send a request (POST)

        // get a response

        // UserResponseModel => ProfileEntity
        CredientialResponseModel credientialResponseModel = null;
        return InterviewerMapper.convertToProfileEntity(credientialResponseModel, MapperImplementation::convertToProfileEntity);
    }

    public InterviewEntity getInterviewer(InterviewSelectionModel model) {
        // InterviewSelectionModel => InterviewSelectionRequestModel

        // InterviewSelectionResponseModel InterviewEntity
        return null;
    }

}
