package hw11.fileSystem;

public class CountingVisitor implements FSVisitor {

	private int dirNum = 0;
	private int linkNum = 0;
	private int fileNum = 0;
	
	@Override
	public void visit(Link link) 
	{
		linkNum++;
	}

	@Override
	public void visit(Directory dir) 
	{
		dirNum++;
	}

	@Override
	public void visit(File file) 
	{
		fileNum++;
	}

	public int getDirNum()
	{
		return dirNum;
	}
	
	public int getFileNum()
	{
		return fileNum;
	}
	
	public int getLinkNum()
	{
		return linkNum;
	}

}
