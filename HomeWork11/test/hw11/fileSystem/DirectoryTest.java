package hw11.fileSystem;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import hw11.fileSystem.Directory;
import hw11.fileSystem.File;
import hw11.fileSystem.FileSystem;
import hw11.fileSystem.Link;

import org.junit.Before;

public class DirectoryTest {
	FileSystem fs = FileSystem.getInstance();
	Directory root;
	
	@Before
	public void setup() {
		root = new Directory(null, "root", "RD");
		fs.setRoot(root);
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
		fs.addChild(root, system);		
		fs.addChild(root, home);
		
		fs.addChild(root, a);
		fs.addChild(root, b);
		fs.addChild(root, c);		
		
		fs.addChild(root, pictures);
		fs.addChild(root, x);
		fs.addChild(root, d);	
		
		
		fs.addChild(root, y);
		fs.addChild(root, e);
		fs.addChild(root, f);
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
