package se.deved;

import java.util.ArrayList;
import java.util.List;

public class ListTaskManager implements TaskManager{

    private List<Task> tasks = new ArrayList<>();

    @Override
    public void save(Task task) {
        tasks.add(task);
    }

    @Override
    public void remove(Task task) {
        tasks.remove(task);
    }

    @Override
    public Task getByTitle(String title) {
        for (Task task : tasks) {
            if (task.title.equalsIgnoreCase(title)) {
                return task;
            }
        }

        return null;
    }
}
