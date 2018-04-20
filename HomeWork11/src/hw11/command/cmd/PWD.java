package hw11.command.cmd;

import java.util.ArrayList;

import hw11.command.Command;
import hw11.fileSystem.Directory;
import hw11.fileSystem.FileSystem;

public class PWD implements Command{
	private FileSystem f; 
	//private String s;
	public PWD()
	{
		f = FileSystem.getInstance();
	}
	
	@Override
	public void execute() 
	{
		//System.out.println("PWD executing....\n");
		Directory cur = f.getCurrentDirectory();	
		//System.out.println(cur.getName());
		ArrayList<String> path=new ArrayList<String>();		
		while(cur!=null){			
			path.add(cur.getName());
			cur=cur.getParent();
		}
		for(int i=path.size()-1;i>=0;i--){
			System.out.print("/"+path.get(i));
		}
	}
}
