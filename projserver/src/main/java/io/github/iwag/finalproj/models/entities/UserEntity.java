package io.github.iwag.finalproj.models.entities;

public class UserEntity {
    protected String firstName;
    protected String lastName;
    protected String countryLocation;
    protected String userName;
    protected String password;

    public UserEntity(String firstName, String lastName, String countryLocation, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryLocation = countryLocation;
        this.userName = userName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountryLocation() {
        return countryLocation;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", countryLocation='" + countryLocation + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getInsertValues() {
        return "'" + firstName + "','" + lastName + "','" + countryLocation + "','" + userName + "','" + password + "'";
    }
}
