package hw11.fileSystem;

public class File extends FSElement {

	public File(Directory parent, String name, String owner, int size) 
	{
		super(parent, name, owner, size);
		this.setType("File");
	}
	public void accept(FSVisitor v) {
		v.visit(this);
	}

}
