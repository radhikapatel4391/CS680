package hw7;
import java.io.File;
import java.util.LinkedHashMap;



public class FIFO implements CacheReplacementPolicy
{
	private static FIFO instance = null;
	private FIFO(){
		
	}
		
	public static FIFO getInstance()
	{
		if(instance == null)
		{
			instance = new FIFO();
		}
		return instance;
		
	}
		@Override
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