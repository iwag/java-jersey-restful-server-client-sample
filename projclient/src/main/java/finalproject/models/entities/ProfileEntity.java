package finalproject.models.entities;

import java.time.LocalTime;

public class ProfileEntity {
    UserEntity userEntity;
    Integer userId;
    LocalTime date;
    String authToken;

    public ProfileEntity(UserEntity userEntity, Integer userId, LocalTime date, String authToken) {
        this.userEntity = userEntity;
        this.userId = userId;
        this.date = date;
        this.authToken = authToken;
    }
}
