package hw11.fileSystem;

import java.util.Date;



public class FSElement {
	
	private String name,owner;
	private Date created,lastModified;
	private int size;
	private Directory parent;
	private String type;
	
//constructor	
	public FSElement(Directory parent, String name, String owner, int size)
	{
		this.parent = parent;
		this.name = name;
		this.owner = owner;
		this.size = size;		
		this.created = new Date();
		this.lastModified = new Date();
		
	}
//getter setter
	public Directory getParent() {
		return parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		
		this.owner = owner;
		System.out.println(this.getName()+" 's Owner change to "+owner);
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Date getCreated() {
		return created;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}	
	protected void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
//accept method with empty
	public void accept(FSVisitor v) {
		// empty
	}	

}
