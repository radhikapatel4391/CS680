package hw11.sortingMethods;
import java.util.Comparator;

import hw11.fileSystem.FSElement;

public class AlphabeticalComparator implements Comparator<FSElement> 
{
	@Override
	public int compare(FSElement f1, FSElement f2) 
	{
		return f1.getName().compareTo(f2.getName());
	}
	
}
