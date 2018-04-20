package hw11.fileSystem;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import hw11.fileSystem.CountingVisitor;
import hw11.fileSystem.Directory;
import hw11.fileSystem.File;
import hw11.fileSystem.FileSystem;
import hw11.fileSystem.Link;

import org.junit.Before;

public class CountingVisitorTest {

	FileSystem fs = FileSystem.getInstance();
	Directory root;
	CountingVisitor visitor;
	@Before
	public void setup() {
		root = new Directory(null, "root", "RD");
		fs.setRoot(root);
		File a = new File(root, "a", "RD", 10);
		File b = new File(root, "b","RD", 10);
		File c = new File(root, "c","RD",20);
		Link x = new Link(root, "x", "RD",a);
		
		fs.setRoot(root);
		root.appendChild(0,a);
		root.appendChild(1,b);
		root.appendChild(2,c);		
		root.appendChild(3,x);
		visitor = new CountingVisitor();
		root.accept(visitor);
		
	}
	@Test
	public void getDirNumZero() {
		
		int expected = 1;
		int actual = visitor.getDirNum();
		assertThat(actual, is(expected));
	}
	@Test
	public void getFileNum() {		
		int expected = 3;
		int actual = visitor.getFileNum();
		assertThat(actual, is(expected));
	}
	@Test
	public void getLinkNum() {
		int expected = 1;
		int actual = visitor.getLinkNum();
		assertThat(actual, is(expected));
	}
//	@Test
//	public void getDirNumOne() {
//		
//		int expected = 0;
//		int actual = visitor.getDirNum();
//		assertThat(actual, is(expected));
//	}
}
