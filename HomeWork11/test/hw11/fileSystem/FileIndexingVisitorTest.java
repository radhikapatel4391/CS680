package hw11.fileSystem;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import hw11.fileSystem.Directory;
import hw11.fileSystem.File;
import hw11.fileSystem.FileIndexingVisitor;
import hw11.fileSystem.FileSystem;
import hw11.fileSystem.Link;

import org.junit.Before;

public class FileIndexingVisitorTest {

	FileSystem fs = FileSystem.getInstance();
	Directory root;
	FileIndexingVisitor visitor;
	@Before
	public void setup() {
		root = new Directory(null, "root", "RD");
		fs.setRoot(root);
		File a = new File(root, "a", "RD", 10);
		File b = new File(root, "b","RD", 10);
		File c = new File(root, "c","RD",20);
		Link x = new Link(root, "x", "RD",a);
		
		fs.setRoot(root);
		fs.addChild(root, a);
		fs.addChild(root, b);
		fs.addChild(root, c);
		fs.addChild(root, x);
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
