package hw6;
import java.util.ArrayList;
import java.util.Comparator;

public class ParetoComparator implements Comparator<Car>{

	public ParetoComparator(ArrayList<Car> usedCars) {
		for(Car u:usedCars)
		{
			int dominationCount=0;
			for(Car ui:usedCars) {
				if(u.getMilage() > ui.getMilage() && u.getPrice() > ui.getPrice() && u.getYear() < ui.getYear()) {
					dominationCount++;
				}else if(u.getMilage() == ui.getMilage() && u.getPrice() == ui.getPrice() && u.getYear() == ui.getYear()) {
					
				}
				else if(u.getMilage() == ui.getMilage() && (u.getPrice() > ui.getPrice() || u.getYear() < ui.getYear())) {
					dominationCount++;
				}else if((u.getMilage() > ui.getMilage() || u.getYear() < ui.getYear()) && u.getPrice() == ui.getPrice()) {
					dominationCount++;
				}else if((u.getMilage() > ui.getMilage() || u.getPrice() > ui.getPrice()) && u.getYear() == ui.getYear()) {
					dominationCount++;
				}
				
			}
			
			u.setDominationCount(dominationCount);
		}
	}
	
	@Override
	public int compare(Car car1, Car car2) 
	{
		return car1.getDominationCount() - car2.getDominationCount();
	}

}
