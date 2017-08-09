package finalproject.models.requestmodels;

public class UserRequestModel {
    String firstname;
    String lastname;
    String country;
    String username;
    String password;

    public UserRequestModel(String firstname, String lastname, String country, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.username = username;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCountry() {
        return country;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
