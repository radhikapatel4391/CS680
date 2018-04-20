package hw11.command.cmd;

import hw11.command.Command;
import hw11.fileSystem.Directory;
import hw11.fileSystem.FSElement;
import hw11.fileSystem.FileSystem;

public class CP implements Command{//Copy given element to given new directory
	private String s;
	private FileSystem fs;
	
	public CP(String s) {
		this.s = s;
		this.fs=FileSystem.getInstance();
		
	}
	@Override
	public void execute() {
		int l;
		if(s==null){
			System.out.println("Give the Directory/File name(for copy) and Directory(destination) as a argument to copy, seprate two argument by space");
			
		}
		else{
			String temp[] = s.split(" ");
			l=temp.length;
			
			if(l!=2) {
				System.out.println("There must be only two arguments");
				System.out.println("Give the Directory/File name(for copy) and Directory(destination) as a argument to copy, seprate two argument by space");
				return;
			}
			
				FSElement f = fs.getElementFromfullPath(temp[1]);
				FSElement ele = fs.getElementFromfullPath(temp[0]);
				if(f instanceof Directory && ele!=null) {
					Directory destinationDir = (Directory) f;
					ele.setParent(destinationDir);
					FSElement newElement = fs.getElementFromfullPath(temp[0]);
					fs.addChild(destinationDir, newElement);
					fs.showAllElements();
//					Command cd = new CD(temp[1]);
//					cd.execute();
//					Command ls = new LS();
//					ls.execute();
				}
				else {
					System.out.println("ERROR Check arguments.....");
				}
				
			
		}
		
		return ;
		

	}
}
