package hw7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;


public class FileCache {
	private static FileCache instance;
	private CacheReplacementPolicy replacementPolicy;
	
	public void setReplacementPolicy(CacheReplacementPolicy replacementPolicy) {
		this.replacementPolicy = replacementPolicy;
	}

	private LinkedHashMap<String, File> cache;

	private FileCache()
	{
		replacementPolicy = NullReplacement.getInstance();
		cache = new LinkedHashMap<String, File>();
		System.out.println("Cash has maximum size 3.");
	}

	public static FileCache getInstance()
	{
		if (instance == null)
		{
			instance = new FileCache();
		}
		return instance;
	}

	public String fetch(String target) throws FileNotFoundException
	{
		File f;		

		if (cache.containsKey(target))
		{
			System.out.println("reading from hashmap...");
			f = this.cache.get(target);
			targetContent(f);
		} 
		else 
		{
			f = new File(target);// get from the disc
			
			targetContent(f);// print it..
			
			if (cache.size() < 3) // put in cash if space available
			{
				cache.put(target, f);
				System.out.println("target file put in hashmap...");

			} 
			else
			{
				replace(f);
				
			}
		}

		return target;
	}
	public int getCacheSize() {
		return this.cache.size();
	}
	private void targetContent(File f) throws FileNotFoundException {
			System.out.println("\n");
			
			System.out.println("\n");
			FileInputStream s = new FileInputStream(f);
			int line;
			
			try {
				while((line = s.read()) != -1)
				{
				    System.out.print((char)line);
				}
				System.out.println("\n");
				System.out.println("---------file end---------");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	private void replace(File target) {
		
			replacementPolicy.replace(this.cache, target);
		
	}

	
}