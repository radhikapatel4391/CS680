package hw9;

import java.util.Date;

public class FSElement {
	
	private String name,owner;
	private Date created,lastModified;
	private int size;
	private Directory parent;
	public Directory getParent() {
		return parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}	

	public FSElement(Directory parent, String name, String owner, int size)
	{
		this.parent = parent;
		this.name = name;
		this.owner = owner;
		this.size = size;
		//this.type = type;
		this.created = new Date();
		this.lastModified = new Date();
	}
	
	public Date getCreated() {
		return created;
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
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	

}
