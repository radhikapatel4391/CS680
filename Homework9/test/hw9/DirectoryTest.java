package hw9;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;

public class DirectoryTest {
	FileSystem fs = FileSystem.getFileSystem();
	Directory root;
	
	@Before
	public void setup() {
		root = new Directory(null, "root", "RD");
		Directory home = new Directory(root,"home","RD");
		Directory system = new Directory(root,"system","RD");
		Directory pictures = new Directory(home,"pictures","RD");
		File a = new File(system, "a", "RD", 10);
		File b = new File(system, "b","RD", 10);
		File c = new File(system, "c","RD",100);
		File d = new File(home, "d","RD", 500);
		File e = new File(pictures, "e","RD", 100);
		File f = new File(pictures, "f","RD", 500);
		Link x = new Link(home, "x", "RD",system);
		Link y = new Link(pictures, "y","RD",e);
		
		fs.setRoot(root);
		
		root.appendChild(system);
		root.appendChild(home);		
		
		root.appendChild(a);
		root.appendChild(b);
		root.appendChild(c);		
		
		root.appendChild(pictures);
		root.appendChild(x);
		root.appendChild(d);		
		
		
		root.appendChild(y);
		root.appendChild(e);
		root.appendChild(f);
		fs.showAllElements();
		
	}
	
	@Test
	public void testcountFSElements() {
		
		
		assertThat(root.countFSElements(),is(11));
	}
	
	@Test
	public void testgetTotalSize() {		
		
		assertThat(root.getTotalSize(),is(1220));
	}
	@After
	public void afterTest() {
		System.out.println("---------------------------------------------------------------");
	}
}
