package se.deved;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileTaskManager implements TaskManager {

    @Override
    public void save(Task task) {
        File folder = new File("./tasks");
        folder.mkdirs();

        File file = new File(folder, task.title);
        try {
            file.createNewFile();

            // Serialization
            FileWriter writer = new FileWriter(file);

            // TODO: Spara all information (label, dates etc)
            writer.append(task.title)
                    .append("\n")
                    .append(task.description)
                    .append("\n")
                    .append(String.valueOf(task.completed))
                    .append("\n")
                    .append(task.label)
                    .append("\n");

            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    @Override
    public void remove(Task task) {
        File folder = new File("./tasks");
        if (!folder.exists())
            return;

        File file = new File(folder, task.title);
        if (!folder.exists())
            return;

        file.delete();
    }

    @Override
    public Task getByTitle(String title) {
        File folder = new File("./tasks");
        if (!folder.exists())
            return null;

        File file = new File(folder, title);
        if (!folder.exists())
            return null;

        // Deserialization
        try {
            FileReader reader = new FileReader(file);
            BufferedReader buffered = new BufferedReader(reader);

            Task task = new Task();
            // TODO: Läs all information (label, dates etc)
            task.title = buffered.readLine();
            task.description = buffered.readLine();
            task.completed = buffered.readLine().equals("true");
            task.label = buffered.readLine();

            buffered.close();

            return task;
        } catch (Exception e) {
            return null;
        }
    }
}
