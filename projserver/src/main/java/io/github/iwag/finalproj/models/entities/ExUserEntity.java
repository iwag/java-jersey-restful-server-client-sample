package io.github.iwag.finalproj.models.entities;

public class ExUserEntity extends UserEntity {
    private Integer userId;

    public ExUserEntity(String firstName, String lastName, String countryLocation, String userName, String password, Integer userId) {
        super(firstName, lastName, countryLocation, userName, password);
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "ExUserEntity{" +
                "firstName='" + firstName + '\'' +
                ", userId=" + userId +
                ", lastName='" + lastName + '\'' +
                ", countryLocation='" + countryLocation + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
