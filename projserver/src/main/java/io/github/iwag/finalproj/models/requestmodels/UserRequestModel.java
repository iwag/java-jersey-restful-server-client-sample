package io.github.iwag.finalproj.models.requestmodels;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserRequestModel {
    private String firstname;
    private String lastname;
    private String country;
    private String username;
    private String password;

    public UserRequestModel() {
    }

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

    public boolean validate() {
       return password != null && firstname != null && lastname != null && country != null && username != null;
    }
}
