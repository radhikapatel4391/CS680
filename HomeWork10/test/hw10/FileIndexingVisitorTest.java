package hw10;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;



import org.junit.Before;

public class FileIndexingVisitorTest {

	FileSystem fs = FileSystem.getFileSystem();
	Directory root;
	FileIndexingVisitor visitor;
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
		visitor = new FileIndexingVisitor();
		root.accept(visitor);
		
	}
	
	@Test
	public void getIndexedFileNum() {
		int expected = 3;
		int actual = visitor. getIndexedFileNum();
		assertThat(actual, is(expected));
	}

}
