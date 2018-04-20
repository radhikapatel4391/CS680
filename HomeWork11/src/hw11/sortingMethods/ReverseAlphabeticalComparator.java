package hw11.sortingMethods;

import java.util.Comparator;

import hw11.fileSystem.FSElement;

public class ReverseAlphabeticalComparator  implements Comparator<FSElement> {
	@Override
	public int compare(FSElement f1, FSElement f2) 
	{
		return f2.getName().compareTo(f1.getName());
	}
}
