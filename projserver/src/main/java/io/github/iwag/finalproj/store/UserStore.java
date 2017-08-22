package io.github.iwag.finalproj.store;

import io.github.iwag.finalproj.models.entities.*;

import java.sql.SQLException;
import java.time.LocalDate;

public interface UserStore {

    public ExUserEntity addUser(UserEntity ue);


    public ProfileEntity loginUser(String username, String password, LocalDate date, String auth);

}
