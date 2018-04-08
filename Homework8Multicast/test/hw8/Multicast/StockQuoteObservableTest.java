package hw8.Multicast;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class StockQuoteObservableTest {

	StockQuoteObservable stockQuoteObservable = new StockQuoteObservable();
	 Set<Float> actual = new HashSet<Float>();
	 Set<Float> expected = new HashSet<Float>();
	 
	@Before
	public void setup()
	{
		stockQuoteObservable.addObservers(new PieChartObserver());		
		stockQuoteObservable.addObservers(new TableObserver());
		stockQuoteObservable.addObservers(new ThreeDObserver());
	}
	
	@Test
	public void testObserver()
	{
		stockQuoteObservable.notifyObservers(new StockEvent("Google",80));
		stockQuoteObservable.notifyObservers(new StockEvent("Apple",90));
		stockQuoteObservable.notifyObservers(new StockEvent("Google",50));
		
		
		for (StockEvent d : stockQuoteObservable.getData()) 
		{
			actual.add(d.getQuote());
			//System.out.println(d.getQuote());
		}
		expected.add((float) 80);
		expected.add((float) 90);
		expected.add((float) 50);
	
		assertTrue(actual.containsAll(expected));
	}
}
