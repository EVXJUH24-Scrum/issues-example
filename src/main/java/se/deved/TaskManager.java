package se.deved;

public interface TaskManager {
    void save(Task task);
    void remove(Task task);
    Task getByTitle(String title);
}
