package hw7;
import java.io.File;
import java.util.LinkedHashMap;

public class NullReplacement implements CacheReplacementPolicy{
	
	private static NullReplacement instance = null;
	private NullReplacement(){
		
	}
		
	public static NullReplacement getInstance()
	{
		if(instance == null)
		{
			instance = new NullReplacement();
		}
		return instance;
		
	}
	@Override
	public void replace(LinkedHashMap<String, File> cache, File targetFile) 
	{
		System.out.println("Null Replacement replace........");
		
	}

}
