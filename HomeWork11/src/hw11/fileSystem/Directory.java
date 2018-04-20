package hw11.fileSystem;

import java.util.LinkedList;



public class Directory extends FSElement
{
	private LinkedList<FSElement> children;
	public Directory(Directory parent, String name, String owner) 
	{
		super(parent, name, owner,0);
		this.setType("Directory");
		children = new LinkedList<FSElement>();
	}
	public FSElement getChildUsingName(String name) {		
		for(FSElement f:this.children){
		if(f.getName().contentEquals(name)){			
			//System.out.println("Dir: child:"+f.getName()+"name:"+name);
			return f;
		}
		
		}
		return null;
		
	} 
	public Directory getChildDirUsingName(String dirName) {
		Directory dir=null;
		for(FSElement f:this.children){
		if(f.getName().contentEquals(dirName) && f instanceof Directory){			
			dir=(Directory) f;
			return dir;
		}
		
		}
		return dir;
		
	} 
	public File getChildFileUsingName(String fileName) {
		File file=null;
		for(FSElement f:this.children){
		if(f.getName().contentEquals(fileName) && f instanceof File){			
			file=(File) f;
			return file;
		}
		
		}
		return file;
		
	} 

	public LinkedList<FSElement> getChildren()
	{
		return this.children;
	}
	public void appendChild(int index, FSElement child)
	{		
		children.add(index,child);
		
	}
//	public void appendChild(FSElement child)
//	{		
//		children.add(child);
//		
//	}
	public void removeChild(FSElement child)
	{
		
		children.remove(child);
	}
	public int countFSElements() {
		System.out.println("Total child in this directory: "+children.size());
		return children.size();
	}
	public int getTotalSize() {
		
		int total=0;
		
		for(int num=0; num < children.size(); num++)
	      {	    			  
	    	  total+=children.get(num).getSize();
	      }
		System.out.println("getTotalSize: "+total);
		return total;
	}
	public void accept(FSVisitor v) {
		v.visit(this);
		for (FSElement e : children)
		{
			e.accept(v);
		}
	}
}
