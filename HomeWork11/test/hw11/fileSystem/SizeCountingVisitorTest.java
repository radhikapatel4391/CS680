package hw11.fileSystem;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import hw11.fileSystem.Directory;
import hw11.fileSystem.File;
import hw11.fileSystem.FileSystem;
import hw11.fileSystem.SizeCountingVisitor;

import org.junit.Before;

public class SizeCountingVisitorTest {
	FileSystem fs = FileSystem.getInstance();
	Directory root;
	SizeCountingVisitor visitor;
	@Before
	public void setup() {
		root = new Directory(null, "root", "RD");
		fs.setRoot(root);
		File a = new File(root, "a", "RD", 10);
		File b = new File(root, "b","RD", 10);
		File c = new File(root, "c","RD",20);
		
		
		fs.setRoot(root);
		fs.addChild(root, a);
		fs.addChild(root, b);
		fs.addChild(root, c);
				
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
