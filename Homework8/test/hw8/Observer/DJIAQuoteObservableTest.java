package hw8.Observer;


import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;


public class DJIAQuoteObservableTest {

	DJIAQuoteObservable dJIAQuoteObservable = new DJIAQuoteObservable();
	 Set<Float> data = new HashSet<Float>();
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
		dJIAQuoteObservable.changeQuote(70);
		dJIAQuoteObservable.changeQuote(80);
		dJIAQuoteObservable.changeQuote(90);
		data.add((float) 70);
		data.add((float) 80);
		data.add((float) 90);
		assertTrue(dJIAQuoteObservable.getData().containsAll(data));
	}
}
