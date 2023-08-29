package command;

import main.Main;
import task.Task;

public class CommandDeleteHandler implements ICommandHandler{

    @Override
    public void execute(String command, String[] parameters) throws CommandException {
        int number = -1;
        try{
            number = Integer.parseInt(parameters[1]);
        }
        catch (NumberFormatException e){
            throw new CommandException("Input is not a valid number");
        }
        if(number <= 0 || number > Main.getInstance().getTaskList().getCount()){
            throw new CommandException("Input number out of range.");
        }
        Task removedTask = Main.getInstance().getTaskList().removeTask(number - 1);
        Main.getInstance().getUi().say("Noted. I've removed this task:", true, false);
        Main.getInstance().getUi().say("  " + removedTask.toString(), false, false);
        Main.getInstance().getUi().say("Now you have " + Main.getInstance().getTaskList().getCount() +" tasks in the list.", false, true);
    }
}
