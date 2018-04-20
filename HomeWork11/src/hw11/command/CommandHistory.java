package hw11.command;

import java.util.Stack;

public class CommandHistory {
	private Stack<Command> command;
	private static CommandHistory instance;
	
	private CommandHistory()
	{
		command = new Stack<Command>();
	}

	public static CommandHistory getInstance()//singletance class
	{
		if(instance == null)
		{
			instance = new CommandHistory();
		}
		return instance;
	}
	
	public void push(Command c)
	{
		this.command.push(c);
	}

	public Command pop()
	{
		
		return this.command.pop();
	}

	public Stack<Command> getHistory()
	{
		return this.command;
	}

}
