package hw11.sortingMethods;

import java.util.Comparator;

import hw11.fileSystem.FSElement;

public class ElementKindComparator implements Comparator<FSElement> 
{
	@Override
	public int compare(FSElement f1, FSElement f2) 
	{
		return f1.getType().compareTo(f2.getType());
	}
	
}

