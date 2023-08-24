package command;

import main.Main;
import task.DeadlineTask;

public class CommandDeadlineHandler implements ICommandHandler{

    @Override
    public void execute(String command, String[] parameters) throws CommandException {
        String taskName = "";
        int length = parameters.length;
        int i;
        for(i = 1; i < length; i++){
            if(!parameters[i].equals("/by")){
                taskName += (i != 1 ? " " : "") + parameters[i];
            }
            else{
                break;
            }
        }
        String deadline = "";
        for(i++; i < length; i++){
            deadline += parameters[i] + (i != length - 1 ? " " : "");
        }
        if(deadline.equals("")){
            throw new CommandException("Error: No deadline time is given.");
        }
        Main.getInstance().getTaskList().addTask(new DeadlineTask(taskName, deadline));
    }
}
