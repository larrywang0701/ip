package command;

import main.Main;
import task.TodoTask;

public class CommandTodoHandler implements ICommandHandler{

    @Override
    public void execute(String command, String[] parameters) {
        Main.getInstance().getTaskList().addTask(new TodoTask(command.replaceFirst("todo ", "")));
    }
}
