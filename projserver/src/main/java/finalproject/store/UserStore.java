package finalproject.store;

import finalproject.models.entities.CredientialEntity;
import finalproject.models.entities.ExUserEntity;
import finalproject.models.entities.ProfileEntity;
import finalproject.models.entities.UserEntity;

import java.time.LocalDate;
import java.util.*;

public class UserStore {
    private Map<String, ExUserEntity> users;
    private Map<String, ProfileEntity> authorized;

    public UserStore() {
        this.users = new HashMap<>();
        this.authorized = new HashMap<>();
    }

    public ExUserEntity addUser(UserEntity ue) {
        if (users.containsKey(ue.getUserName())) {
            return null;
        }
        Integer userId = users.size();
        ExUserEntity eue = new ExUserEntity(ue.getFirstName(), ue.getLastName(), ue.getCountryLocation(), ue.getUserName(), ue.getPassword(), userId);
        users.put(ue.getUserName(), eue);
        return eue;
    }


    public ProfileEntity loginUser(String username, String password, LocalDate date, String auth) {
        if (!users.containsKey(username)) {
            return null;
        }
        if (authorized.containsKey(username)) {
            authorized.remove(username);
        }
        ExUserEntity ue = users.get(username);
        ProfileEntity pe = new ProfileEntity(ue, ue.getUserId(), date, auth);
        authorized.put(username, pe);
        return pe;
    }

    public boolean isAuth(Integer userId, String auth) {
        for (ProfileEntity pe : authorized.values()) {
            if (pe.getAuthToken() == auth && pe.getUserId() == userId) {
                return true;
            }
        }
        return false;
    }
}
