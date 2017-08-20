package io.github.iwag.finalproj.store;

import io.github.iwag.finalproj.models.entities.*;
import org.jvnet.hk2.annotations.Contract;

import java.sql.SQLException;
import java.time.LocalDate;

@Contract
public interface UserStore {

    public ExUserEntity addUser(UserEntity ue);


    public ProfileEntity loginUser(String username, String password, LocalDate date, String auth);

}
