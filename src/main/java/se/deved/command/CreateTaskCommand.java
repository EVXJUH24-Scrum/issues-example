package se.deved.command;

import se.deved.Application;
import se.deved.Task;
import se.deved.utility.DateUtility;

import java.util.Scanner;

public class CreateTaskCommand extends Command {

    public CreateTaskCommand(Application application) {
        super("create-task", "Create a task.", application);
    }

    @Override
    public void execute(String[] commandArgs) {
        if (commandArgs.length != 2) {
            throw new IllegalArgumentException("Usage: create-task <title>");
        }

        String taskName = commandArgs[1];
        Task task = new Task();
        task.title = taskName;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Beskriv tasken:");
        task.description = scanner.nextLine();

        System.out.println("Vad är det för typ av task?");
        System.out.println("1. Simpel");
        System.out.println("2. En gångs");
        System.out.println("3. Upprepande dagligen");

        int taskTypeIndex;
        try {
            taskTypeIndex = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Du valde inte en riktig task-type.");
            return;
        }

        if (taskTypeIndex == 1) {
            //task.type = TaskType.SIMPLE;
        } else if (taskTypeIndex == 2) {
            //task.type = TaskType.ONE_TIME;
            System.out.println("När är deadline? (yyyy-MM-dd HH:mm:ss)");
            String dateString = scanner.nextLine();
            task.deadline = DateUtility.parseString(dateString);

            if (task.deadline == null) {
                System.out.println("Fel datumformat. Försök igen.");
                return;
            }
        } else if (taskTypeIndex == 3) {
            //task.type = TaskType.REPEATING_DAILY;
            System.out.println("Vilken tid på dagen?");
            task.time = scanner.nextLine();
        }

        /*System.out.println("Vad har tasken för prioritet?");
        int priorityIndex = 0;
        for (Priority priority : main.taskManager.priorities) {
            System.out.println(" " + (priorityIndex + 1) + ". " + priority.name);
            priorityIndex++;
        }

        try {
            priorityIndex = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Du valde inte en riktig priority.");
            return;
        }

        if (priorityIndex - 1 >= main.taskManager.priorities.size() || priorityIndex - 1 < 0) {
            System.out.println("Du valde inte en riktig priority.");
            return;
        }

        task.priority = main.taskManager.priorities.get(priorityIndex - 1);
         */

        System.out.println("Ange en label till din task:");
        task.label = scanner.nextLine();

        try {
            application.getTaskManager().save(task);
            System.out.println("Sparade task '" + task.title + "'.");
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Kunde inte spara task. Försök igen.");
        }
    }
}
