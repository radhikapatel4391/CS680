package hw9;



import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class FileSystemTest {
	
	FileSystem fs = FileSystem.getFileSystem();
	Directory root;
	
	@Before
	public void setup() {
		Directory root = new Directory(null, "root", "RD");
		Directory home = new Directory(root,"home","RD");
		Directory system = new Directory(root,"system","RD");
		Directory pictures = new Directory(home,"pictures","RD");
		File a = new File(system, "a", "RD", 5);
		File b = new File(system, "b","RD", 10);
		File c = new File(system, "c","RD",100);
		File d = new File(home, "d","RD", 500);
		File e = new File(pictures, "e","RD", 800);
		File f = new File(pictures, "f","RD", 20);
		Link x = new Link(home, "x", "RD",system);
		Link y = new Link(pictures, "y","RD",e);
		
		fs.setRoot(root);
		root.appendChild(system);
		root.appendChild(home);	
		//root.appendChild(pictures);
		
		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);
		
		
		
		home.appendChild(pictures);
		home.appendChild(x);
		home.appendChild(d);
		
		
		
		pictures.appendChild(y);
		pictures.appendChild(e);
		pictures.appendChild(f);
		
		
	}
	
	@Test
	public void testshowAllElements() {
		fs.showAllElements();
		assertThat(true,is(true));
	}
	

}
