package hw11.fileSystem;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import hw11.fileSystem.Directory;
import hw11.fileSystem.File;
import hw11.fileSystem.FileSystem;
import hw11.fileSystem.Link;

import org.junit.Before;

public class FileSystemTest {
	
	FileSystem fs = FileSystem.getInstance();
	Directory root,pictures,system,home;
	
	@Before
	public void setup() {
		root = new Directory(null, "root", "RD");
		fs.setRoot(root);
		home = new Directory(root,"home","RD");
		system = new Directory(root,"system","RD");
		pictures = new Directory(home,"pictures","RD");
		File a = new File(system, "a", "RD", 5);
		File b = new File(system, "b","RD", 10);
		File c = new File(system, "c","RD",100);
		File d = new File(home, "d","RD", 500);
		File e = new File(pictures, "e","RD", 800);
		File f = new File(pictures, "f","RD", 20);
		Link x = new Link(home, "x", "RD",system);
		Link y = new Link(pictures, "y","RD",e);		
		fs.setRoot(root);
		fs.addChild(root, system);
		fs.addChild(root, home);		
		
		fs.addChild(system, a);
		fs.addChild(system, b);
		fs.addChild(system, c);			
		
		fs.addChild(home, pictures);
		fs.addChild(home, x);
		fs.addChild(home, d);		
		
		fs.addChild(pictures, y);
		fs.addChild(pictures, e);
		fs.addChild(pictures, f);	
		
	}
	@Test
	public void testGetFileSystem() 
	{
		FileSystem fileSystem1 = FileSystem.getInstance();
		assertThat("FileSystem1 is null.", fileSystem1, is(notNullValue()));		
		FileSystem fileSystem2 = FileSystem.getInstance();
		assertThat("drawerClosedNotPlaying2 is null.", fileSystem2, is(notNullValue()));		
		assertThat("DrawerOpen violates singleton propertirs.", fileSystem1, is (sameInstance ( fileSystem2)));
	}
	
	@Test
	public void testshowAllElements() {
		fs.showAllElements();
		assertThat(true,is(true));
	}
	@Test
	public void testGetnSetRoot() {
		Directory newroot = new Directory(null, "newRoot", "RD");
		fs.setRoot(newroot);
		assertThat(fs.getRoot(), is (sameInstance (newroot)));
	}
	@Test
	public void testgetElementFromfullPath() {
		FSElement fe = fs.getElementFromfullPath("root/home/pictures");
		assertThat(fe, is (sameInstance (pictures)));
		fs.setCurrentDirectory(pictures);
		fe = fs.getElementFromfullPath("..");
		assertThat(fe, is (sameInstance (home)));
		
	}
	@Test
	public void testaddChild() {
		Directory newChild = new Directory(null, "newChild", "RD");
		fs.addChild(home, newChild);
		assertThat(home.getChildDirUsingName("newChild"), is (sameInstance (newChild)));
	}

}
