package io.github.iwag.jerseystarter.main;


import io.github.iwag.jerseystarter.models.Task;
import io.github.iwag.jerseystarter.repository.ApiTaskRepository;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class Main {

    public static void main(String[] args) throws java.lang.Exception {
        ApiTaskRepository taskRepository = new ApiTaskRepository(ClientBuilder.newClient());
        System.out.println("GET /task/0 " + taskRepository.get("0"));
        System.out.println("PUT /task " + taskRepository.create(new Task(null, "aaa", 1, "2017/08/14")));
        return ;
    }
}
