package hw12;
import java.io.File;
import java.util.LinkedHashMap;



public class FIFOFileCache extends FileCache
{
	
	
	
//	public static FIFOFileCache getInstance()
//	{
//		if(instance == null)
//		{
//			instance = new FIFOFileCache();
//		}
//		return instance;
//		
//	}
		
	public void replace(LinkedHashMap<String, File> cache, File targetFile) 
	{
		System.out.println("FIFO Replace method called....");
		String key  = cache.keySet().iterator().next();
		//System.out.println(key);
		cache.remove(key);
		//System.out.println(targetFile.getPath());
		cache.put("src/"+targetFile.getName(), targetFile);
		
	}
}