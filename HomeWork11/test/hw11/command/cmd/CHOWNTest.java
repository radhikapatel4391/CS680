package hw11.command.cmd;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import hw11.command.Command;
import hw11.fileSystem.Directory;
import hw11.fileSystem.FileSystem;

public class CHOWNTest {

	FileSystem fs = FileSystem.getInstance();
	Directory c;
	Directory d;
	Directory programFiles;
	Directory pictures;

	@Before
	public void setup() {
		
		c = new Directory(fs.getRoot(), "c", "OwnerName");
		fs.addChild(fs.getRoot(), c);
		
		programFiles = new Directory(c, "programFiles", "OwnerName");
		fs.addChild(c, programFiles);
		
		d = new Directory(fs.getRoot(), "d", "OwnerName");
		fs.addChild(fs.getRoot(), d);
		
		pictures = new Directory(d, "pictures", "OwnerName");
		fs.addChild(d, pictures);
	}

	@Test
	public void executeTest_CHOWNtoCurrentDir() {		
		Command chown = new CHOWN("RadhikaPatel");
		chown.execute();
		assertThat(fs.getCurrentDirectory().getOwner(), is(("RadhikaPatel")));
	}

	@Test
	public void executeTest_CHOWN() {	
		fs.setCurrentDirectory(pictures);
		Command chown = new CHOWN("RadhikaPatel ../");
		chown.execute();
		assertThat(d.getOwner(), is(("RadhikaPatel")));
	}
}
