package finalproject.models.entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class ProfileEntity {
    UserEntity userEntity;
    Integer userId;
    LocalDate date;
    String authToken;

    public ProfileEntity(UserEntity userEntity, Integer userId, LocalDate date, String authToken) {
        this.userEntity = userEntity;
        this.userId = userId;
        this.date = date;
        this.authToken = authToken;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public Integer getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getAuthToken() {
        return authToken;
    }

    @Override
    public String toString() {
        return "ProfileEntity{" +
                "userEntity=" + userEntity +
                ", userId=" + userId +
                ", date=" + date +
                ", authToken='" + authToken + '\'' +
                '}';
    }
}
