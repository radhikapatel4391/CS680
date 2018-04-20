package hw10;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;




public class FSElementTest {

	private Directory home;
	private File p = new File(home, "F1", "Radhika",20);
	

	@Test
	public void GetnSetName()
	{	
		p.setName("File");
		String actual = "File";
		String expected = p.getName();
		assertThat(actual, is(expected));
	}

	@Test
	public void GetnSetOwner()
	{
		p.setOwner("RD");
		String actual = "RD";
		String expected = p.getOwner();
		assertThat(actual, is(expected));
	}


	@Test
	public void  GetnSetSize()
	{
		
		int expected = 20;
		int actual = p.getSize();
		assertThat(actual,is(expected));
		p.setSize(30);
		assertThat(p.getSize(),is(30));
	}
}
