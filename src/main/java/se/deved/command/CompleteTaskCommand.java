package se.deved.command;

import se.deved.Application;

public class CompleteTaskCommand extends Command {
    public CompleteTaskCommand(Application application) {
        super("complete-task", "Mark task as completed.", application);
    }

    @Override
    public void execute(String[] commandArgs) {

    }
}
