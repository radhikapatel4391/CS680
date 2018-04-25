package hw11.command.cmd;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import hw11.command.Command;
import hw11.fileSystem.Directory;
import hw11.fileSystem.FileSystem;

public class CDTest {

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
	public void executeTest_cdToRoot() {
		fs.setCurrentDirectory(pictures);
		Command cd = new CD();
		cd.execute();
		assertThat(fs.getCurrentDirectory(), is(sameInstance(fs.getRoot())));
	}

	@Test
	public void executeTest_cdToParentDirectory() {
		fs.setCurrentDirectory(pictures);
		Command cd = new CD("..");
		cd.execute();
		assertThat(fs.getCurrentDirectory(), is(sameInstance(d)));
		
		cd = new CD("../");
		cd.execute();
		assertThat(fs.getCurrentDirectory(), is(sameInstance(fs.getRoot())));
	}
	@Test
	public void executeTest_cdToRelativePath() {
		fs.setCurrentDirectory(pictures);
		Command cd = new CD("../../c");
		cd.execute();
		//System.out.println(fs.getCurrentDirectory().getName());
		//System.out.println(c.getName());
		assertThat(fs.getCurrentDirectory().getName(), is((c.getName())));
	}
	@Test
	public void executeTest_cdToAbsolutePath() {
		fs.setCurrentDirectory(pictures);
		Command cd = new CD("root/c/programFiles");
		cd.execute();		
//		fs.setCurrentDirectory(c);
//		Command ls = new LS();
//		ls.execute();
		assertThat(fs.getCurrentDirectory().getName(), is((programFiles.getName())));
	}
}
