package hw6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MainCarArrayList {
		
	public static void main(String args[])
	{		
		ArrayList<Car> usedCars = new ArrayList<Car>();
		
		usedCars.add(new Car(40000,2018,10000));
		usedCars.add(new Car(3000,2012,1050000));
		usedCars.add(new Car(10000,2010,50000));
		usedCars.add(new Car(2000,2017,30000));
		usedCars.add(new Car(1000,2003,75000));
		usedCars.add(new Car(100,2018,750));
//		usedCars.add(new Car(1235,2014,10000));
//		usedCars.add(new Car(789587,2015,75000));
//		usedCars.add(new Car(456123,2016,850));
//		usedCars.add(new Car(7000,2005,85476));
//		usedCars.add(new Car(85999,1994,96000));
//		usedCars.add(new Car(875,2006,98756));
//		usedCars.add(new Car(10,2018,75000));
//		usedCars.add(new Car(250,2015,789546));
//		usedCars.add(new Car(6600,1945,785423));
//		usedCars.add(new Car(500,2009,111111));
//		usedCars.add(new Car(4500,2008,75000));
//		usedCars.add(new Car(5000,1995,567835));
//		usedCars.add(new Car(2200,1991,32756));
		
		Collections.sort(usedCars, new MilageComparator());		
		System.out.println("Milage:");
		for(Car u:usedCars)
		{
			System.out.print(u.getMilage()+" , ");
		}

		Collections.sort(usedCars,new PriceComparator());
		System.out.println("---");
		System.out.println("Price:");
		for(Car u:usedCars)
		{
			System.out.print(u.getPrice()+" , ");
		}
	
		Collections.sort(usedCars, new YearComparator());
		System.out.println("---");
		System.out.println("Year:" );
		for(Car u:usedCars)
		{
			System.out.print(u.getYear()+" , ");
		}
		
		Collections.sort(usedCars, new ParetoComparator(usedCars));
		System.out.println("---");
		System.out.println("Pareto:");
		for(Car u:usedCars)
		{
			System.out.println(u.getDominationCount()+" , "+u.getPrice()+" , "+u.getYear()+" , "+u.getMilage());
		}
		
	}
	
	
}
	