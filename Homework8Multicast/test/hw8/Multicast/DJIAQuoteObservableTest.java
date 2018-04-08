package hw8.Multicast;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;



public class DJIAQuoteObservableTest {

	DJIAQuoteObservable dJIAQuoteObservable = new DJIAQuoteObservable();
	 Set<Float> actual = new HashSet<Float>();
	 Set<Float> expected = new HashSet<Float>();
	 
	@Before
	public void setup()
	{
	
		dJIAQuoteObservable.addObservers(new PieChartObserver());		
		dJIAQuoteObservable.addObservers(new TableObserver());
		dJIAQuoteObservable.addObservers(new ThreeDObserver());
	}
	
	@Test
	public void testObserver()
	{
		dJIAQuoteObservable.notifyObservers(new DJIAEvent(70));
		dJIAQuoteObservable.notifyObservers(new DJIAEvent(80));
		dJIAQuoteObservable.notifyObservers(new DJIAEvent(90));
		
		
		for (DJIAEvent d : dJIAQuoteObservable.getData()) 
		{

			actual.add(d.getDjia());

		}
		expected.add((float) 70);
		expected.add((float) 80);
		expected.add((float) 90);
	
		assertTrue(actual.containsAll(expected));
	}

}
