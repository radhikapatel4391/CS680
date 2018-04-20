package hw11.sortingMethods;

import java.util.Comparator;

import hw11.fileSystem.FSElement;



public class FileTypeComparator implements Comparator<FSElement> 
{
	@Override
	public int compare(FSElement f1, FSElement f2) 
	{
		String s1="",s2="";
		int i = f1.getName().lastIndexOf('.');
		 if (i > 0) {
		     s1 = f1.getName().substring(i+1);
		 }
		 int j = f2.getName().lastIndexOf('.');
		 if (j > 0) {
		     s2 = f2.getName().substring(i+1);
		 }
		return s1.compareTo(s2);
	}
	
}
