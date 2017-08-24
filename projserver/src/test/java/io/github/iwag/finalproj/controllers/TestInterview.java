package io.github.iwag.finalproj.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.iwag.finalproj.models.entities.ProfileEntity;
import io.github.iwag.finalproj.models.entities.UserEntity;
import io.github.iwag.finalproj.models.requestmodels.SubmitRequestModel;
import io.github.iwag.finalproj.models.responsemodels.SubmitResponseModel;
import io.github.iwag.finalproj.store.AuthenticationStore;
import io.github.iwag.finalproj.store.Stores;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@WebMvcTest(Interviews.class)
public class TestInterview {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getInterviewShouldSuccess() throws Exception {
        this.mockMvc.perform(get("/interview/topics/java")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Canada")));
        this.mockMvc.perform(get("/interview/topics/sql")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("SQL")));
    }

    @Test
    public void getInterviewShouldFail() throws Exception {
        this.mockMvc.perform(get("/interview/topics/XXX")).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void submitShouldSuccess() throws Exception {
        ProfileEntity pe = Stores.userStore.newAuth(new UserEntity("ta", "iw", "ja", "iw@gm", "aaa"), 0);
        SubmitRequestModel req = new SubmitRequestModel("0", Arrays.asList());
        String js = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(req);

        this.mockMvc.perform(post("/interview/5").contentType(MediaType.APPLICATION_JSON).content(js)
                .header("auth", pe.getAuthToken())).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("0/2")));
    }

    @Test
    public void submitShouldBeNotFound() throws Exception {
        ProfileEntity pe = Stores.userStore.newAuth(new UserEntity("ta", "iw", "ja", "iw@gm", "aaa"), 0);
        SubmitRequestModel req = new SubmitRequestModel("0", Arrays.asList());
        String js = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(req);
        this.mockMvc.perform(post("/interview/0").contentType(MediaType.APPLICATION_JSON).content(js)
                .header("auth", pe.getAuthToken())).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void submitShouldBeUnAuth() throws Exception {
        ProfileEntity pe = Stores.userStore.newAuth(new UserEntity("ta", "iw", "ja", "iw@gm", "aaa"), 0);
        SubmitRequestModel req = new SubmitRequestModel("0", Arrays.asList());
        String js = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(req);
        this.mockMvc.perform(post("/interview/5").contentType(MediaType.APPLICATION_JSON).content(js)
                .header("auth", "invalid_auth_token")).andDo(print()).andExpect(status().isUnauthorized());
    }

}