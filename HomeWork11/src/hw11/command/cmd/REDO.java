package hw11.command.cmd;



import hw11.command.Command;
import hw11.command.CommandHistory;

public class REDO implements Command{
	private CommandHistory history;
	private Command c;
	
	public REDO() {
		
	}
	@Override
	public void execute() {
		history = CommandHistory.getInstance();
		c = history.getHistory().pop();
		System.out.println(c.getClass().getSimpleName());
		
		c.execute();
		return ;
	}
}
