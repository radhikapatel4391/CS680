package hw11.fileSystem;

import java.util.LinkedList;
import java.util.ListIterator;

public class FileSystem {
	
	private static FileSystem instance = null;
	private Directory root;
	private Directory current;
	
//Constructor this class is singleton so private constructor
	private FileSystem(){
		this.root = new Directory(null,"root","Radhika");
		this.current = this.root;
	}
	
//Gives Unique instance
	public static FileSystem getInstance()
	{
		if(instance == null) 
		{
			instance = new FileSystem();
		}
		return instance;
	}
	
//All getter Setter
	public Directory getRoot() {
		return root;
	}
	public void setRoot(Directory root) {
		this.root = root;
	}	
	public Directory getCurrentDirectory()
	{
		return this.current;
	}
	public void setCurrentDirectory(Directory current)
	{
		this.current = current;
	}
//Utilities Methods

	//add child in alphabetical order
	public void addChild(Directory parent,FSElement child) 
	{
		if(child!=null && parent!=null)
		{
			parent.appendChild(getInsertionLocation(parent,child), child);
		}
		else
		{
			System.out.println("One of value is null");
		}
	}
	
	//Gives FSElement from given full path based on current position and root
	public FSElement getElementFromfullPath(String s)  
	{		
		
		FSElement f = null;
		
		if (s.contains("/") || s.contains("\\"))
		{
			String path[];
			if(s.contains("/")) {
				 path = (s.split("/"));	
			}else {
				path = (s.split("\\"));	
			}
					
			int l = path.length;
			
			Directory c = current;			
			if(path[0].contains(this.root.getName()) || path[0].contains("")) 
			{
				//System.out.println("Here \n");
				f = root;
				c = root;
			}
			else if(path[0].contains(".."))
			{
				f = this.getCurrentDirectory().getParent();
				c = (Directory) f;
				
			}
			else 
			{
				f = this.getCurrentDirectory().getChildDirUsingName(path[0]);				
				c = (Directory) f;
			}
			
			for (int i=1;i<(l-1);i++)
			{
				if (path[i].contains(".."))
				{
					f = c.getParent();
					c = (Directory) f;
					
				} 
				else
				{
					f =  c.getChildDirUsingName(path[i]);
					c = (Directory) f;					
				}				

			}			
			if(l>1 && c!=null)
			{				
				f =  c.getChildUsingName(path[l-1]);				
			}
			
			if(f!=null) 
			{
				return f;
			}
			else 
			{
				
				throw new IllegalArgumentException("\n"+"NO such Element found... Check path argument make sure you are using this '/' "); 
			}			
		} 
		else 
		{
			if (s.contains("..")) 
			{
				f =  this.getCurrentDirectory().getParent();
				if(f!=null)
				{
					return f;
				}
				else
				{
					//System.out.println("NO such Element found...");
					throw new IllegalArgumentException("\n" + "you are already in root directory"); 
				}
			}
			else
			{
				f = this.getCurrentDirectory().getChildUsingName(s);
				if(f!=null)
				{
					return f;
				}
				else
				{
					//System.out.println("NO such Element found...");
					throw new IllegalArgumentException("\n" + "No such child in this directory check path/name in arguments"); 
				}
			}
		}		
	}
	//Show directory presentation
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
	
	//create defined file structure as shown in PPT
	public void createFileSystem()
	{
		FileSystem fs = getInstance();
		Directory root = fs.getRoot();
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
		fs.addChild(root, home);
		fs.addChild(root, system);
	
		fs.addChild(system, a);
		fs.addChild(system, b);
		fs.addChild(system, c);		
		
		fs.addChild(home, d);
		fs.addChild(home, x);
		fs.addChild(home, pictures);
		
		fs.addChild(pictures, e);
		fs.addChild(pictures, f);
		fs.addChild(pictures, y);
		
		fs.showAllElements();
		return;
	}
//private methods to help public methods	
	private int getInsertionLocation(Directory parent,FSElement child)
	{
			
			LinkedList<FSElement> children;
			children = parent.getChildren();		
			ListIterator<FSElement> li = children.listIterator(children.size());
			for(int i = 0;i<children.size();i++) {
				if(children.get(i).getName().compareTo(child.getName())>0) 
				{			
					
						return i;				
				}
			}		
			return children.size();
	}
	
	private void RecursivePrint(FSElement e,int level) 
	{
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
}
