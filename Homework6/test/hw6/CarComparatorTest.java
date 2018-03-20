package hw6;


import java.util.ArrayList;
import java.util.Collections;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CarComparatorTest {

	ArrayList<Car> usedCars = new ArrayList<Car>();
	
	@Before
	public void setUp()
	{		
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
		
	}
	
	@Test
	public void priceComparator()
	{
		
		int expected[] = {100 , 1000 , 2000 , 3000 , 10000 , 40000};
		int i=0;
		Collections.sort(usedCars, new PriceComparator());
		System.out.println("\n");
		System.out.println("\n");
		//System.out.println("----------------------------------------------------------------------------");
		System.out.println("Price:");
		for(Car u:usedCars)
		{
			System.out.print(u.getPrice()+" , ");
			assertThat(expected[i],is(u.getPrice()));
			i++;
		}
				
	}
	
	@Test
	public void yearComparator()
	{
		
		int expected[] = {2018 , 2018 , 2017 , 2012 , 2010 , 2003};
		int i=0;
		Collections.sort(usedCars, new YearComparator());
		System.out.println("\n");
		System.out.println("\n");
		//System.out.println("----------------------------------------------------------------------------");
		System.out.println("Year:");
		for(Car u:usedCars)
		{
			System.out.print(u.getYear()+" , ");
			assertThat(expected[i],is(u.getYear()));
			i++;
		}
				
	}
	@Test
	public void milageComparator()
	{
		
		float expected[] = {750 , 10000 , 30000, 50000, 75000, 1050000};
		int i=0;
		Collections.sort(usedCars, new MilageComparator());
		System.out.println("\n");
		System.out.println("\n");
		//System.out.println("---------------------------------------------------------------------------");
		System.out.println("Milage:");
		for(Car u:usedCars)
		{
			System.out.print(u.getMilage()+" , ");
			assertThat(expected[i],is(u.getMilage()));
			i++;
		}
				
	}
	
	@Test
	public void paretoComparator()
	{
		
		int expected[] = {0,1,1,1,2,2};
		int i=0;
		Collections.sort(usedCars, new ParetoComparator(usedCars));
		System.out.println("\n");
		System.out.println("\n");
		//System.out.println("----------------------------------------------------------------------------");
		System.out.println("Pareto:");
		for(Car u:usedCars)
		{
			System.out.print(u.getDominationCount()+" , ");
			assertThat(expected[i],is(u.getDominationCount()));
			i++;
		}
				
	}
	@After
	public void print() {
		System.out.println("\n");
		System.out.println("----------------------------------------------------------------------------");
	}

}
