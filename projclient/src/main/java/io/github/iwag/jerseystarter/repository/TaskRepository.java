package io.github.iwag.jerseystarter.repository;

import io.github.iwag.jerseystarter.models.Task;

interface TaskRepository {
    Task[] gets();
    Task get(String id);
    boolean create(Task t);
    boolean update(String id, Task t);
    boolean delete(String id);
}
