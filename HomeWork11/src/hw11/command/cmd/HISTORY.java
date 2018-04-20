package hw11.command.cmd;

import java.util.ListIterator;
import java.util.Stack;

import hw11.command.Command;
import hw11.command.CommandHistory;

public class HISTORY implements Command{//Print command histroy
	private CommandHistory history;
	private Stack<Command> commands;
	
	
	public HISTORY()
	{
		
	}
	
	@Override
	public void execute() 
	{		
		history = CommandHistory.getInstance();
		commands = history.getHistory();
		ListIterator<Command> li = commands.listIterator(commands.size());
		while(li.hasPrevious()) {
			  System.out.println(li.previous().getClass().getSimpleName());
			}

		return ;
	}

}
