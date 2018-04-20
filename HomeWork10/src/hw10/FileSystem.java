package hw10;



public class FileSystem {
	
	private static FileSystem instance = null;
	private Directory root;
	
	public Directory getRoot() {
		return root;
	}

	public void setRoot(Directory root) {
		this.root = root;
	}

	private FileSystem(){
		
	}

	public static FileSystem getFileSystem()
	{
		if(instance == null) 
		{
			instance = new FileSystem();
		}
		return instance;
	}
	public void showAllElements()
	{
		
	
		if(root == null)
		{
			System.out.println("Empty....");
		}
		else
		{
				
			RecursivePrint(root,0);
		}
		
	}
	
	private void RecursivePrint(FSElement e,int level) 
	{
//		// TERMINATE CONDITION
//		IF(INDEX == ARR.LENGTH)
//			RETURN;
		
		// tabs for internal levels
		for (int i = 0; i < level; i++)
			System.out.print("\t");
		
		// for files
		if(!(e instanceof Directory)) {
			if(e instanceof Link) {
				Link k = (Link) e;
				System.out.println(e.getName()+", Link Ref:"+k.getRef().getName());
				}
			else {
				File f = (File) e;
				System.out.println(e.getName()+", File size: "+f.getSize());
			}
			return;
			}
		// for sub-directories
		else if(e instanceof Directory)
		{
			Directory d = (Directory) e;
			System.out.println("[" + e.getName()+ "]");
			
			for(int num=0; num<d.getChildren().size();num++) {
				RecursivePrint(d.getChildren().get(num),level + 1);
			}
			
			return;
			
			// recursion for sub-directories
			
		}
		
		// recursion for main directory
		
	
	}
	public static void main(String args[])
	{
		FileSystem fs = getFileSystem();
		Directory root = new Directory(null, "root", "RD");
		Directory home = new Directory(root,"home","RD");
		Directory system = new Directory(root,"system","RD");
		Directory pictures = new Directory(home,"pictures","RD");
		File a = new File(system, "a", "RD", 5);
		File b = new File(system, "b","RD", 10);
		File c = new File(system, "c","RD",100);
		File d = new File(home, "d","RD", 500);
		File e = new File(pictures, "e","RD", 800);
		File f = new File(pictures, "f","RD", 20);
		Link x = new Link(home, "x", "RD",system);
		Link y = new Link(pictures, "y","RD",e);
		
		fs.setRoot(root);
		root.appendChild(system);
		root.appendChild(home);		
		
		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);
		
		
		
		home.appendChild(pictures);
		home.appendChild(x);
		home.appendChild(d);
		
		
		
		pictures.appendChild(y);
		pictures.appendChild(e);
		pictures.appendChild(f);
		
		fs.showAllElements();
	}

}
