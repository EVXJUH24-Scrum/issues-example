package se.deved.menu;

import se.deved.Application;
import se.deved.command.CompleteTaskCommand;
import se.deved.command.CreateTaskCommand;
import se.deved.command.RemoveTaskCommand;

public class UserMenu extends Menu {

    public UserMenu(Application application) {
        super(application);
        registerCommand(new CreateTaskCommand(application));
        registerCommand(new RemoveTaskCommand(application));
        registerCommand(new CompleteTaskCommand(application));
    }

    @Override
    public void display() {
        System.out.println("Welcome to the application! Type 'help' for a list of commands.");
    }
}
