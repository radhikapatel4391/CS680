package hw6;
import java.util.Comparator;

public class PriceComparator implements Comparator<Car>{

	@Override
	public int compare(Car car1, Car car2) 
	{
		return car1.getPrice() - car2.getPrice();
	}

}
