package hw11.command.cmd;

import hw11.command.Command;
import hw11.fileSystem.Directory;
import hw11.fileSystem.FSElement;
import hw11.fileSystem.FileSystem;

public class MV implements Command{
	private String s;
	private FileSystem fs;
	
	public MV(String s) {//move file/dir to other dir
		this.s = s;
		this.fs=FileSystem.getInstance();
	}
	@Override
	public void execute() {
		
		
		int l;
		if(s==null){
			System.out.println("Give the Directory/File name(for move) and Directory(destination) as a argument to copy, seprate two argument by space");
			
		}
		else{
			String temp[] = s.split(" ");
			l=temp.length;
			
			if(l!=2) {
				System.out.println("There must be only two arguments");
				System.out.println("Give the Directory/File name(for move) and Directory(destination) as a argument to copy, seprate two argument by space");
				return;
			}
			
				FSElement f = fs.getElementFromfullPath(temp[1]);
				FSElement newElement = fs.getElementFromfullPath(temp[0]);
				
				if(f instanceof Directory) {
					Directory destinationDir = (Directory) f;
					
					newElement.getParent().removeChild(newElement);					
					newElement.setParent(destinationDir);					
					fs.addChild(destinationDir, newElement);
					fs.showAllElements();
				}
				else
				{
					System.out.println("ERROR Check your arguments..!!!!");
				}
				
			
		}
		
		return ;
		

	}
}
