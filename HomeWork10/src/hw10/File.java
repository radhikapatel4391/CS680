package hw10;



public class File extends FSElement {

	public File(Directory parent, String name, String owner, int size) 
	{
		super(parent, name, owner, size);
	}
	public void accept(FSVisitor v) {
		v.visit(this);
	}
}