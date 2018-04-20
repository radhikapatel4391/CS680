package hw11.command.cmd;




import hw11.command.Command;
import hw11.fileSystem.FSElement;
import hw11.fileSystem.FileSystem;

public class DIR implements Command{//List of FSElement in current Directory
	private FileSystem f;
	private FSElement element;
	private String s="";
	
	public DIR() {
		f = FileSystem.getInstance();
		//element = f.getCurrentDirectory();
	}
	
	public DIR(String s) {
		f = FileSystem.getInstance();
		this.s = s;
		//element = f.getElementFromfullPath(s);
	}
	@Override
	public void execute() {
			if(this.s.isEmpty()) {
				element = f.getCurrentDirectory();
			}else {
				element = f.getElementFromfullPath(s);
			}
		if(element!=null) {
			System.out.println("Name: "+element.getName()+" Size: "+element.getSize()+" Owner: "+element.getOwner()+"\n");
		}else {
			System.out.println("No such element in current directory..");
		}
			
		
		return ;
	}
}
