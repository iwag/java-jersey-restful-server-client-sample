package io.github.iwag.jerseystarter.main;


import io.github.iwag.jerseystarter.models.Task;
import io.github.iwag.jerseystarter.repository.ApiTaskRepository;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        ApiTaskRepository taskRepository = new ApiTaskRepository(ClientBuilder.newClient());

        String key = null;
        do {
            System.out.println("get your tasks: [A]");
            System.out.println("get your task: [G]");
            System.out.println("create a task [C]");
            System.out.println("edit a task [E]");
            System.out.println("delete task [D]");
            System.out.println("terminate [T]");
            key = scanner.next();

            if (key.startsWith("A")) {
                // TODO
            } else if (key.startsWith("G")) {
                // TODO
                System.out.println("input task id");
                String id = scanner.next();
                System.out.println(taskRepository.get(id));
            } else if (key.startsWith("C")) {
                System.out.println("input description");
                String text = scanner.next();
                System.out.println("input priority (0~100)");
                int priority = scanner.nextInt();
                System.out.println("input date");
                String date = scanner.next();

                if (taskRepository.create(new Task(null, text, priority, date)))
                    System.out.println("DONE");
            } else if (key.startsWith("E")) {
                // TODO
            } else if (key.startsWith("D")) {
                // TODO
            } else if (key.startsWith("T")) {
                break;
            }
        } while (true);

        return ;
    }
}
