package hw10;

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
	
	public void accept(FSVisitor v) {
		v.visit(this);
		for (FSElement e : children)
		{
			e.accept(v);
		}
	}
}