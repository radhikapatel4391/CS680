package hw9;

public class Link extends FSElement 
{
	FSElement ref;
	public FSElement getRef() {
		return ref;
	}


	public Link(Directory parent, String name, String owner,FSElement ref) 
	{
		
		super(parent, name, owner,0);
		this.ref = ref;
		
	}

	
	public int getTargetSize()
	{
		int totalRef=0;
		FSElement t = this;
		while(t instanceof Link){
			Link tLink = (Link) t;
			totalRef++;
			t= tLink.ref;
		}
		System.out.println(this.getName()+"  TargetSize: "+totalRef+"\n");
		return totalRef;
	}
}
