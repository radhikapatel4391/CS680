package hw11.command.cmd;

import hw11.command.Command;
import hw11.fileSystem.Directory;
import hw11.fileSystem.FSElement;
import hw11.fileSystem.FileSystem;
import hw11.fileSystem.Link;

public class LN implements Command{//Make Link
	Directory target;
	String linkName;
	private FileSystem f;
	private String s;
	
	public LN(String s) {
		f = FileSystem.getInstance();
		this.s = s;
	}
	
	@Override
	public void execute() {
		
		int l;
		if(s==null){
			System.out.println("Give the target Directory/File name and link name as a argument to make link, seprate two argument by space");
			
		}
		else{
			String temp[] = s.split(" ");
			l=temp.length;
			
			if(l!=2) {
				System.out.println("There must be only two arguments");
				System.out.println("Give the target Directory/File name and link name as a argument to make link, seprate two argument by space");
				return;
			}
			
				FSElement target = f.getElementFromfullPath(temp[0]);
				if(target!=null) {
					Link link = new Link(f.getCurrentDirectory(),temp[1],"XXXX",target);
					//System.out.println(f.getCurrentDirectory().getName());
					//System.out.println(link.getOwner());
					f.addChild(f.getCurrentDirectory(), link);
					f.showAllElements();
					System.out.println("\n");
				}
				else
				{
					System.out.println("No such Target directory/File exits...");
				}
				
		}

		return ;
		

	}

}
