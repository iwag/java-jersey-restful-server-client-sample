package finalproject.models.interfaces;

import finalproject.models.entities.CredientialEntity;
import finalproject.models.entities.ProfileEntity;
import finalproject.models.entities.UserEntity;
import finalproject.models.requestmodels.CredientialEntityModel;
import finalproject.models.requestmodels.UserRequestModel;
import finalproject.models.responsemodels.CredientialResponseModel;
import finalproject.models.responsemodels.UserResponseModel;

public class InterviewerMapper {

    public static UserRequestModel convert(UserEntity ue, MapFunction<UserEntity, UserRequestModel> mapper) {
        return mapper.convert(ue);
    }

    public static ProfileEntity convert(UserResponseModel ue, MapFunction<UserResponseModel, ProfileEntity> mapper) {
        return mapper.convert(ue);
    }

    public static CredientialEntityModel convertToCredientialRequestModel(CredientialEntity ce, MapFunction<CredientialEntity, CredientialEntityModel> mapper) {
        return mapper.convert(ce);
    }

    public static ProfileEntity convertToProfileEntity(CredientialResponseModel ue, MapFunction<CredientialResponseModel, ProfileEntity> mapper) {
        return mapper.convert(ue);
    }

}
