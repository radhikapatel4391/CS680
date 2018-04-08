package hw9;

import java.util.LinkedList;

public class Directory extends FSElement
{
	private LinkedList<FSElement> children;
	public Directory(Directory parent, String name, String owner) 
	{
		super(parent, name, owner,0);
		children = new LinkedList<FSElement>();
	}

	public LinkedList<FSElement> getChildren()
	{
		return this.children;
	}
	public void appendChild(FSElement child)
	{
		
		children.add(child);
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
}
