package io.github.iwag.jerseystarter.repositories;

import io.github.iwag.jerseystarter.models.Task;
import org.jvnet.hk2.annotations.Contract;

@Contract
public interface TaskRepository {
    Task[] gets();
    Task get(String id);
    boolean create(Task t);
    boolean update(String id, Task t);
    boolean delete(String id);
}
