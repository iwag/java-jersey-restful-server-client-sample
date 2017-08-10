package finalproject.models.responsemodels;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserResponseModel {
    public void setJoined(String joined) {
        this.joined = joined;
    }

    private String firstname;
    private String lastname;
    private String userId;
    private String username;
    private String country;
    private String joined;

    public UserResponseModel() {
    }

    public UserResponseModel(String firstname, String lastname, String userId, String username, String country, String joined, String authToken) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.userId = userId;
        this.username = username;
        this.country = country;
        this.joined = joined;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getCountry() {
        return country;
    }

    public String getJoined() {
        return joined;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
