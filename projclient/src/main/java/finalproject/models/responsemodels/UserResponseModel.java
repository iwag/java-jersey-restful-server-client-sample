package finalproject.models.responsemodels;


public class UserResponseModel {

    String firstname;
    String lastname;
    String userId;
    String username;
    String country;
    String joined;

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

}
