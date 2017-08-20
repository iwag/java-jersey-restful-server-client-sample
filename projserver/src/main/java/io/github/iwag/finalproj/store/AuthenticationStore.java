package io.github.iwag.finalproj.store;

import io.github.iwag.finalproj.models.entities.ExUserEntity;
import io.github.iwag.finalproj.models.entities.ProfileEntity;
import io.github.iwag.finalproj.models.entities.UserEntity;

import java.time.LocalDate;
import java.util.*;

public class AuthenticationStore {
    private Map<String, ExUserEntity> users;
    private Map<String, ProfileEntity> authorized;

    public AuthenticationStore() {
        this.users = new HashMap<>();
        this.authorized = new HashMap<>();
    }

    public boolean isAuth(Integer userId, String auth) {
        for (ProfileEntity pe : authorized.values()) {
            if (pe.getAuthToken() == auth && pe.getUserId() == userId) {
                return true;
            }
        }
        return false;
    }

    public ProfileEntity newAuth(UserEntity ue, Integer id) {
        LocalDate now = LocalDate.now();
        ProfileEntity pe = new ProfileEntity(ue, id, now, UUID.randomUUID().toString());
        return pe;
    }
}
