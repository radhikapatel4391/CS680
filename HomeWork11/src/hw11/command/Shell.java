package hw11.command;

import java.util.Scanner;


import hw11.command.cmd.*;
import hw11.fileSystem.FileSystem;


public class Shell {
	private static CommandHistory commandhistory = CommandHistory.getInstance();
	
	public Shell()
	{
		//commandhistory = CommandHistory.getInstance();
	}
	public static void execute(String s)	
	{	
		String command[] = s.split(" ");
		int len = command.length;
		Command commandInstance = null;
		String c = command[0].toUpperCase();
		//System.out.println(c);
		if(c.contains("PWD")){			
			commandInstance = new PWD();			
		}		
		else if(c.equalsIgnoreCase("CD") && (len==1)) 
		{
			commandInstance = new CD();			
		}
		else if(c.equalsIgnoreCase("CD") && len>1)
		{	
			commandInstance = new CD(command[1]);		
		}
		else if(c.equalsIgnoreCase("LS"))
		{
			commandInstance = new LS();			
		}
		else if(c.equalsIgnoreCase("DIR") && len>1)
		{			
			commandInstance = new DIR(command[1]);			
		}
		else if(c.equalsIgnoreCase("DIR")&& len == 1)
		{
			commandInstance = new DIR();			
		}
		else if(c.equalsIgnoreCase("MKDIR") && len>1)
		{		
			commandInstance = new MKDIR(command[1]);
		}		
		else if(c.equalsIgnoreCase("RMDIR") && len>1)
		{			
			commandInstance = new RMDIR(command[1]);			
		}		
		else if(c.equalsIgnoreCase("LN") && len>2)
		{
			commandInstance = new LN (command[1] +" "+ command[2]);			
		}
		else if(c.equalsIgnoreCase("MV") && len>2)
		{
			commandInstance = new MV (command[1] +" "+ command[2]);			
		}
		else if(c.equalsIgnoreCase("CP") && len>2)
		{
			commandInstance = new CP (command[1] +" "+ command[2]);			
		}
		else if(c.equalsIgnoreCase("CHOWN") && len==2)
		{
			commandInstance = new CHOWN(command[1]);	
		}else if(c.equalsIgnoreCase("CHOWN") && len==3)
		{
			commandInstance = new CHOWN(command[1] +" "+ command[2]);	
		}
		else if(c.equalsIgnoreCase("HISTORY"))
		{
			commandInstance =new HISTORY();			
		}
		else if(c.equalsIgnoreCase("REDO"))
		{
			commandInstance =new REDO();			
		}		
		else if(c.equalsIgnoreCase("SORT") && len>1)
		{			
			commandInstance =new SORT(command[1]);			
		}
		else if(c.equalsIgnoreCase("SORT") && len==1)
		{
			commandInstance = new SORT("");
		}else if(c.equalsIgnoreCase("SHOW")){
			FileSystem.getInstance().showAllElements();
		}
		else if(c.equalsIgnoreCase("EXIT")){
			System.exit(0);
		}
		else{
			System.out.println("Invalid Command.......\n");
			System.out.println("-----------------------------------------------------------------------------------\n");
			System.out.println(" pwd\r\n" + "Print the current working directory.\r\n\n" + 
					" cd dirName\r\n" +"Change the current directory to the specified directory. Accept a relative (not absolute) directory name. Accept ..\r\n" + 
					"(move to the parent directory of the current directory.) \r\n\n" + 
					" cd\r\n" +"Change the current directory to the root directory.\r\n\n" + 
					" ls\r\n" +"Print the name of every file, directory and link in the current directory.\r\n\n" + 
					" dir\r\n" + 
					"Print the information (i.e., kind, name, size and owner) of every file, directory and link in the current directory.\r\n\n" + 
					" dir dir/fileName \r\n" + 
					"Print the specified directorys/files information. Accept relative (not absolute) directory name. Accept ..\r\n\n" + 
					" mkdir dirName\r\n" + 
					"Make the specified directory in the current directory.\r\n\n" + 
					" rmdir dirName \r\n" + 
					"Remove the specified directory in the current directory.\r\n\n" + 
					" ln target (real) dir/file link(alias)Name\r\n" + 
					"Make a link\r\n\n" + 
					" mv dir/file destination dirPath \r\n" + 
					"Move a directory/file to the detonation directoryPath \r\n\n" + 
					" cp dir/file destination dir\r\n" + 
					"Copy a directory/file to the destination directoryPath \r\n\n" + 
					" chown newName dirPath \r\n" + 
					"Change the owner of a file/directory\r\n\n" + 
					" history\r\n" + 
					"Print a sequence of previously-executed commands.\r\n\n" + 
					" redo\r\n" + 
					"Redo the most recently-executed command.\r\n\n" + 
					" sort\r\n" + 
					"Sort directories and files in the current directory \n\n"+
					" exit\r\n" + 
					"Exit from shell \n\n"+
					" show\r\n" + 
					"show directory structure \n\n");
			System.out.println("-----------------------------------------------------------------------------------\n");
			return;
		}
		try {
			if(commandInstance != null) {
				commandInstance.execute();
				commandhistory.push(commandInstance);			
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR ... Check your arguments and commands..\n");
			System.out.println(e);
		}
		
		
		
	}
	public static void main(String[] args) throws Exception{
		FileSystem fs = FileSystem.getInstance();
		fs.createFileSystem();
		
		System.out.println("\n");
		System.out.println("WelCome to Shell Script...!!! \n");
		Scanner in = new Scanner(System.in);
		while(true){
			//System.out.println("\n");
			Command pwd = new PWD();
			pwd.execute();
			System.out.println(" Shell>");
			String commandStr = in.nextLine().trim();
			//System.out.println(command);
			execute(commandStr);
		}
}
}
