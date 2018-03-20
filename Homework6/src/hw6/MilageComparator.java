package hw6;
import java.util.Comparator;

public class MilageComparator implements Comparator<Car>{

	@Override
	public int compare(Car car1, Car car2) 
	{
		return (int) (car1.getMilage() - car2.getMilage());
	}

}
