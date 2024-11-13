package se.deved.command;

import se.deved.Application;
import se.deved.Task;

public class RemoveTaskCommand extends Command{

    public RemoveTaskCommand(Application application) {
        super("remove-task", "Remove a task.", application);
    }

    @Override
    public void execute(String[] commandArgs) {
        if (commandArgs.length != 2) {
            System.out.println("Usage: remove-task <name>");
            return;
        }

        String taskName = commandArgs[1];
        Task task = application.getTaskManager().getByTitle(taskName);
        if (task == null) {
            System.out.println("Den tasken finns inte.");
            return;
        }

        application.getTaskManager().remove(task);
        System.out.println("Raderade task '" + task.title + "'");
    }
}
