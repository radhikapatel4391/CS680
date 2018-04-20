package hw11.command.cmd;
import hw11.command.Command;
import hw11.fileSystem.Directory;
import hw11.fileSystem.FSElement;
import hw11.fileSystem.FileSystem;

public class CD implements Command { // change directory

	private FileSystem fs = FileSystem.getInstance();
	private FSElement current;
	private String s;
	public CD(String s) {	
		this.s = s;
	}

	public CD() {
		this.current = fs.getRoot();
	}

	@Override
	public void execute() {
		
		if(!this.s.isEmpty()) {
			current =  fs.getElementFromfullPath(s);
		}
		
		if (current != null)
		{
			if(current  instanceof Directory)
			{
				Directory d = (Directory) current;
				fs.setCurrentDirectory(d);
			}
			else 
			{
				fs.setCurrentDirectory(current.getParent());
			}			
		}
		else
		{
			System.out.println("No Such Directory Exists!!!");
		}
//		Command pwd = new PWD();
//		pwd.execute();		
		return;
	}

	

}
