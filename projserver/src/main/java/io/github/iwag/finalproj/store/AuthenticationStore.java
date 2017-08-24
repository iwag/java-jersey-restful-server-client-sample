package io.github.iwag.finalproj.store;

import io.github.iwag.finalproj.models.entities.ExUserEntity;
import io.github.iwag.finalproj.models.entities.ProfileEntity;
import io.github.iwag.finalproj.models.entities.UserEntity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.*;

public class AuthenticationStore {
    private Map<Integer, ProfileEntity> authorized;
    final Logger logger = LogManager.getLogger(getClass());

    public AuthenticationStore() {
        this.authorized = new HashMap<>();
    }

    public boolean isAuth(Integer userId, String auth) {
        if (!authorized.containsKey(userId)) {
            return false;
        }
        return authorized.get(userId).getAuthToken().equals(auth);
    }

    public ProfileEntity newAuth(UserEntity ue, Integer id) {
        LocalDate now = LocalDate.now();
        ProfileEntity pe = new ProfileEntity(ue, id, now, UUID.randomUUID().toString());
        authorized.put(id, pe);
        return pe;
    }
}
