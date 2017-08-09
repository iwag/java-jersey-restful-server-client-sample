package finalproject.models.entities;

public class UserEntity {
    String firstName;
    String lastName;
    String countryLocation;
    String userName;
    String password;


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


}
