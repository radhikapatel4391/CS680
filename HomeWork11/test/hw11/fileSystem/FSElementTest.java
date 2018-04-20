package hw11.fileSystem;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

//import java.sql.Date;

import org.junit.Test;

import hw11.fileSystem.Directory;
import hw11.fileSystem.File;




public class FSElementTest {

	private Directory home;
	private File file = new File(home, "F1", "Radhika",20);
	

	@Test
	public void GetnSetName()
	{	
		file.setName("File");
		String actual = "File";
		String expected = file.getName();
		assertThat(actual, is(expected));
	}

	@Test
	public void GetnSetOwner()
	{
		file.setOwner("RD");
		String actual = "RD";
		String expected = file.getOwner();
		assertThat(actual, is(expected));
	}


	@Test
	public void  GetnSetSize()
	{
		
		int expected = 20;
		int actual = file.getSize();
		assertThat(actual,is(expected));
		file.setSize(30);
		assertThat(file.getSize(),is(30));
	}
//	@Test
//	public void  GetnSetLastModified()
//	{
//		
//		Date d = new Date(2018,4,16);
//		file.setLastModified(d);
//		assertThat(file.getLastModified(),is(sameInstance(d)));
//		
//	}
	@Test
	public void  GetnSetparent()
	{
		
		Directory newParent = new Directory(null,"newParent","Radhika");
		file.setParent(newParent);
		assertThat(file.getParent(),is(sameInstance(newParent)));
		
	}
}
