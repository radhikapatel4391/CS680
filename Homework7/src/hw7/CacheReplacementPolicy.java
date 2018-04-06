package hw7;

import java.io.File;
import java.util.LinkedHashMap;

public interface CacheReplacementPolicy {
	void replace(LinkedHashMap<String,File> cache,File targetFile);
}
