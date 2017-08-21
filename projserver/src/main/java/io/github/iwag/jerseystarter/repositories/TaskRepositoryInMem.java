package io.github.iwag.jerseystarter.repositories;

import io.github.iwag.jerseystarter.models.Task;
import org.jvnet.hk2.annotations.Service;

@Service
public class TaskRepositoryInMem implements TaskRepository {
    public Task[] gets() {
        return new Task[0];
    }

    public Task get(String id) {
        return null;
    }

    public boolean create(Task t) {
        return false;
    }

    public boolean update(String id, Task t) {
        return false;
    }

    public boolean delete(String id) {
        return false;
    }
}
