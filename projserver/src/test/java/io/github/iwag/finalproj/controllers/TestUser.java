package io.github.iwag.finalproj.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.iwag.finalproj.models.entities.ProfileEntity;
import io.github.iwag.finalproj.models.entities.UserEntity;
import io.github.iwag.finalproj.models.interfaces.MapperImplementation;
import io.github.iwag.finalproj.models.requestmodels.CredientialRequestModel;
import io.github.iwag.finalproj.models.requestmodels.SubmitRequestModel;
import io.github.iwag.finalproj.models.requestmodels.UserRequestModel;
import io.github.iwag.finalproj.store.Stores;
import io.github.iwag.finalproj.store.UserStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(User.class)
public class TestUser {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createAndLoginShouldSuccess() throws Exception {

        {
            UserEntity ue = new UserEntity("ta", "iw", "ja", "iw@gm", "aaa");
            UserRequestModel req = MapperImplementation.convertUserRequestModel(ue);
            String js = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(req);
            this.mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(js))
                    .andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString("iw@gm")));
        }

        // succ
        {
            CredientialRequestModel creq = new CredientialRequestModel("iw@gm", "aaa");
            String js = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(creq);

            this.mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON).content(js))
                    .andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString("authtoken")));
        }
        // fail to login
        {
            CredientialRequestModel creq = new CredientialRequestModel("iw@gm", "invalid password");
            String js = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(creq);

            this.mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON).content(js))
                    .andDo(print()).andExpect(status().isUnauthorized())
                    .andExpect(content().string(containsString("login failed")));
        }
    }

    @Test
    public void createShouldFail() throws Exception {
        this.mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content("{}"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

}