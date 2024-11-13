package se.deved.command;

import se.deved.Application;
import se.deved.Task;

public class CompleteTaskCommand extends Command {
    public CompleteTaskCommand(Application application) {
        super("complete-task", "Mark task as completed.", application);
    }
    // FIX ISSUE

    @Override
    public void execute(String[] commandArgs) {
        if (commandArgs.length != 2) {
            System.out.println("Usage: complete-task <name>");
            return;
        }

        String taskName = commandArgs[1];
        Task task = application.getTaskManager().getByTitle(taskName);
        if (task == null) {
            System.out.println("Den tasken finns inte.");
            return;
        }

        task.completed = true;
        System.out.println("Uppdaterade task '" + task.title + "'");
        application.getTaskManager().save(task);
    }
}
