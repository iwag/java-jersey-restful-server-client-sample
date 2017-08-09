package finalproject.models.responsemodels;

public class CredientialResponseModel {

    String firstname;
    String lastname;
    String userId;
    String username;
    String country;
    String joined;
    String authToken;

    public CredientialResponseModel(String firstname, String lastname, String userId, String username, String country, String joined, String authToken) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.userId = userId;
        this.username = username;
        this.country = country;
        this.joined = joined;
        this.authToken = authToken;
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

    public String getAuthToken() {
        return authToken;
    }

}
