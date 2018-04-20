package hw11.command.cmd;


import hw11.command.Command;
import hw11.fileSystem.FSElement;
import hw11.fileSystem.FileSystem;


public class CHOWN implements Command{//change owner 
	
	private FileSystem fs;
	private String s;
	
	public CHOWN(String s) {
		this.s = s;
		this.fs=FileSystem.getInstance();
	}
	
	
	@Override
	public void execute() {
		int l;
		if(s==null){
			System.out.println("Give the Owner name and Directory/File Name as a argument to change Owner for specific directory/file");
			System.out.println("only one argument will change owner name of current directory");
		}
		else{
			String temp[] = s.split(" ");
			l=temp.length;		
			
			if(l==1) {
				fs.getCurrentDirectory().setOwner(temp[0]);
			}else if(l>1) {
				
				FSElement ele =  fs.getElementFromfullPath(temp[1]);
				if(ele!=null) {
					ele.setOwner(temp[0]);
				}else {
					System.out.println("No such directory found argument Order is 'newName'  'elementPath' ");
				}
				
			}
		}

		return ;
		
	}
}
