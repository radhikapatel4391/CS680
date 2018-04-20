package hw11.command.cmd;

import hw11.command.Command;
import hw11.fileSystem.Directory;
import hw11.fileSystem.FileSystem;

public class MKDIR implements Command{
	String dirName;
	private FileSystem f;
	
	public MKDIR(String dirName) {
		this.dirName = dirName;
		f = FileSystem.getInstance();
	}
	
	@Override
	public void execute() {
		
		Directory dir = new Directory(f.getCurrentDirectory(),dirName,"");		
		f.addChild(f.getCurrentDirectory(), dir);
		f.showAllElements();
		return ;
	}

}
