package io.github.iwag.finalproj.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.iwag.finalproj.models.entities.UserEntity;
import io.github.iwag.finalproj.models.interfaces.MapperImplementation;
import io.github.iwag.finalproj.models.requestmodels.CredientialRequestModel;
import io.github.iwag.finalproj.models.requestmodels.UserRequestModel;
import io.github.iwag.finalproj.store.Stores;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(History.class)
public class TestHistory {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getHistoryShouldSuccess() throws Exception {
        Stores.historyStore.addHistory(0, "java", LocalDate.now(), "10/20");
        {
            UserEntity ue = new UserEntity("ta", "iw", "ja", "iw@gm", "aaa");
            UserRequestModel req = MapperImplementation.convertUserRequestModel(ue);
            String js = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(req);
            this.mockMvc.perform(get("/interview/history/user/0"))
                    .andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString("10/20")));
        }
    }

    @Test
    public void getHistoryShouldFail() throws Exception {
        this.mockMvc.perform(get("/interview/history/user/1"))
                .andDo(print()).andExpect(status().isNotFound());
    }

}