package hw12;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;


import java.io.File;
import java.util.LinkedHashMap;



public class FIFOFileCacheTest {

	@Test
	public void testReplace() {
		FIFOFileCache fIFOFileCache = new FIFOFileCache();
		LinkedHashMap<String, File> cache = new LinkedHashMap<String, File>();
		cache.put("file1", new File("src/file1.txt"));
		cache.put("file2", new File("src/file2.txt"));
		cache.put("file3", new File("src/file3.txt"));
		File f = new File("src/file4.txt");
		fIFOFileCache.replace(cache, f);
		assertThat("fifo replcae not working", true,is(cache.containsKey("src/file4.txt")));
	}

	

}
