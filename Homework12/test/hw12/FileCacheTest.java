package hw12;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;




public class  FileCacheTest {

	
	
//	@Test
//	public void testGetInstance() {
//		System.out.println("singleton check:");
//		FileCache filec1 = FileCache.getInstance();
//		assertThat("FileCache1 is null.", filec1,is(notNullValue()));		
//		FileCache filec2 = FileCache.getInstance();
//		assertThat("FileCache2 is null.", filec2,is(notNullValue()));		
//		assertThat("filecahse violates singleton propertirs.", filec2, is(sameInstance(filec1)));
//	}
	
	@Test
	public void fetchTestWith3FetchCalled() {
		System.out.println("fetchTestWith3FetchCalled:");
		FileCache filec1 = new FileCache();	
		try {
			filec1.fetch( "src/file1.txt");
			filec1.fetch( "src/file2.txt");
			filec1.fetch( "src/file3.txt");
			
			assertThat("fetch not insert file in hashmap", filec1.getCacheSize(),is(3));
		
			}catch(Exception e){
				fail();
			}
		}
	@Test
	public void fetchTestWith4FetchCalled() 
	{
		System.out.println("fetchTestWith4FetchCalled:");
		FileCache filec1 = new FileCache();
		try {
			
			
			filec1.fetch( "src/file1.txt");
			filec1.fetch( "src/file4.txt");			
			filec1.fetch( "src/file2.txt");
			filec1.fetch( "src/file3.txt");
			filec1.fetch( "src/file4.txt");
			
			assertThat("fetch not insert file in hashmap", filec1.getCacheSize(),is(3));
		
			}catch(Exception e){
				fail();
			}
		}
	
	@Test
	public void fetchTestFileNotFound()
	{
		System.out.println("exception check in fetch methods");
		FileCache filec1 = new FileCache();
		
		try {
			filec1.fetch( "src/file5.txt");			
		
			}catch(Exception e){
				assertThat(e.getMessage(),is("src\\file5.txt (The system cannot find the file specified)"));
			}
	}
	@After
	public void print() {
		System.out.println("\n");
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
