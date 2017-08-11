package finalproject.models.requestmodels;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CredientialRequestModel {
    private String username;
    private String password;

    public CredientialRequestModel() {
    }

    public CredientialRequestModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validate() {
        return username != null && password != null;
    }
}
