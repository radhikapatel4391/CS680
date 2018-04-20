package hw11.command.cmd;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import hw11.command.Command;
import hw11.fileSystem.FSElement;
import hw11.fileSystem.FileSystem;
import hw11.sortingMethods.*;

public class SORT implements Command {
	private String sortingMethod;
	FileSystem fs;

	public SORT(String sortingMethod) {
		this.sortingMethod = sortingMethod;
		fs = FileSystem.getInstance();
	}

	@Override
	public void execute() {

		LinkedList<FSElement> childrens = (LinkedList<FSElement>) fs.getCurrentDirectory().getChildren().clone();

		if (this.sortingMethod.contentEquals("")) {
			//Collections.sort(childrens, new AlphabeticalComparator());// already in alphabetical order so no need of it.

		} else if (this.sortingMethod.contentEquals("alphabetical")) {
			//Collections.sort(childrens, new AlphabeticalComparator());// Already sorted in alphabetical so no need of it.

		} else if (this.sortingMethod.contentEquals("reversealphabetical")) {
			Collections.sort(childrens, new ReverseAlphabeticalComparator());

		} else if (this.sortingMethod.contentEquals("timestamp")) {
			Collections.sort(childrens, new TimeStampComparator());

		} else if (this.sortingMethod.contentEquals("element")) {
			int startFileIndex = java.lang.Integer.MAX_VALUE, endFileIndex = 0, count = 0;
			Collections.sort(childrens, new ElementKindComparator());
			for (int i = 0; i < childrens.size(); i++) {
				if (childrens.get(i).getType() == "File") {
					if (startFileIndex < i) {
						startFileIndex = i;
					}
					count++;
				}

			}
			if(startFileIndex<java.lang.Integer.MAX_VALUE) {
				endFileIndex = startFileIndex + count;
				List subFileList = childrens.subList(startFileIndex,endFileIndex);
				Collections.sort(subFileList, new ElementKindComparator());
			}
			
			//System.out.println(startFileIndex+" "+endFileIndex);
			

		} else {
			System.out.println("Possible sorting stretage could be: alphabetical, reversealphabetical, timestamp, element");
		}
		for (int i = 0; i < childrens.size(); i++) {
			
			System.out.println(childrens.get(i).getName()+" ,  "+childrens.get(i).getType());
		}
		
		return ;
	}
}
