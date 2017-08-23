package io.github.iwag.finalproj.store;

import io.github.iwag.finalproj.models.entities.*;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserStoreInMemory implements UserStore {
    private Map<String, ExUserEntity> users;

    public UserStoreInMemory() {
        users = new HashMap<>();
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

        ExUserEntity ue = users.get(username);
        ProfileEntity pe = new ProfileEntity(ue, ue.getUserId(), date, auth);
        if (!pe.getUserEntity().getPassword().equals(password)) {
            return null;
        }
        return pe;
    }

}