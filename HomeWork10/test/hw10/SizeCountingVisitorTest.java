package hw10;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;



import org.junit.Before;

public class SizeCountingVisitorTest {
	FileSystem fs = FileSystem.getFileSystem();
	Directory root;
	SizeCountingVisitor visitor;
	@Before
	public void setup() {
		root = new Directory(null, "root", "RD");
		
		File a = new File(root, "a", "RD", 10);
		File b = new File(root, "b","RD", 10);
		File c = new File(root, "c","RD",20);
		
		
		fs.setRoot(root);
		root.appendChild(a);
		root.appendChild(b);
		root.appendChild(c);		
		visitor = new SizeCountingVisitor();
		root.accept(visitor);
		
		
	}
	
	@Test
	public void getTotalSize() {
		
		int expected = 40;
		int actual = visitor.getTotalSize();
		assertThat(actual, is(expected));
	}
	
	
}
