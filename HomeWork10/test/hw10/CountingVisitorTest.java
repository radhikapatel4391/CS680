package hw10;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;



import org.junit.Before;

public class CountingVisitorTest {

	FileSystem fs = FileSystem.getFileSystem();
	Directory root;
	CountingVisitor visitor;
	@Before
	public void setup() {
		root = new Directory(null, "root", "RD");
		
		File a = new File(root, "a", "RD", 10);
		File b = new File(root, "b","RD", 10);
		File c = new File(root, "c","RD",20);
		Link x = new Link(root, "x", "RD",a);
		
		fs.setRoot(root);
		root.appendChild(a);
		root.appendChild(b);
		root.appendChild(c);		
		root.appendChild(x);
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
