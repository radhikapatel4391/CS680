package hw9;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class LinkTest {
	FileSystem fs = FileSystem.getFileSystem();
	Directory root;
	Link a,b,c,d,e,f,g,h,i,j;
	
	@Before
	public void setup() {
		
		root = new Directory(null, "root", "RD");
		Directory home = new Directory(root,"home","RD");
		Directory system = new Directory(root,"system","RD");
		Directory pictures = new Directory(home,"pictures","RD");
	
		 a = new Link(home, "a", "RD",root);
		
		 b = new Link(pictures, "b","RD",a);
		
		 c = new Link(home, "c", "RD",b);
		
		 d = new Link(pictures, "d","RD",c);
		
		 e = new Link(home, "e", "RD",system);
		
		 f = new Link(pictures, "f","RD",e);
		
		 g = new Link(home, "x", "g",f);
		
		 h = new Link(pictures, "h","RD",home);
		
		 i = new Link(home, "i", "RD",h);
		
		 j = new Link(system, "j","RD",root);
		
		fs.setRoot(root);
		
		root.appendChild(system);
		root.appendChild(home);		
		home.appendChild(pictures);
		
		home.appendChild(a);
		pictures.appendChild(b);
		home.appendChild(c);		
		
		pictures.appendChild(d);
		home.appendChild(e);
		pictures.appendChild(f);		
		
		
		home.appendChild(g);
		pictures.appendChild(h);
		home.appendChild(i);
		system.appendChild(j);
		
		fs.showAllElements();
	}
	
	@Test
	public void test1TargetSize() {
		
		assertThat("I am not counting right error",j.getTargetSize(),is(1));
	}
	@Test
	public void test2TargetSize() {
		
		assertThat(i.getTargetSize(),is(2));
		assertThat(f.getTargetSize(),is(2));
	}
	@Test
	public void test4TargetSize() {
		
		assertThat(d.getTargetSize(),is(4));
	}
	@After
	public void afterTest() {
		System.out.println("---------------------------------------------------------------");
	}
	
}
