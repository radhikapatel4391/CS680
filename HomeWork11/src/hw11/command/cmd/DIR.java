package hw11.command.cmd;




import java.util.LinkedList;

import hw11.command.Command;
import hw11.fileSystem.Directory;
import hw11.fileSystem.FSElement;
import hw11.fileSystem.FileSystem;

public class DIR implements Command{//List of FSElement in current Directory or information about it.
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
			if(null != this.s && !this.s.isEmpty()) {
				element = f.getElementFromfullPath(s);
				if(element!=null) {
					System.out.println("Name: "+element.getName()+" Size: "+element.getSize()+" Owner: "+element.getOwner()+"\n");
				}else {
					System.out.println("No such element in current directory..");
				}
			}else {				
				Directory current = f.getCurrentDirectory();
				LinkedList<FSElement> children = current.getChildren();
				System.out.println("\n");				
				for(int i=0; i<children.size();i++)
				{
					System.out.println("Name: "+children.get(i).getName()+" Size: "+children.get(i).getSize()+" Owner: "+children.get(i).getOwner()+"\n");
				}
				System.out.println("\n");
				return ;
			}
		
			
		
		return ;
	}
}
