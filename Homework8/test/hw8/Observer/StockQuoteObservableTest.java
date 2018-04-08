package hw8.Observer;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;


import org.junit.Before;
import org.junit.Test;

public class StockQuoteObservableTest {

	StockQuoteObservable stockObservable = new StockQuoteObservable();
	HashMap<String, Float> map = new HashMap<>();
	
	@Before
	public void setup()
	{
		stockObservable.addObservers(new PieChartObserver());
		stockObservable.addObservers(new TableObserver());
		stockObservable.addObservers(new ThreeDObserver());
	}
	
	@Test
	public void testObserver()
	{
		
		stockObservable.changeQuote("Google",80);
		stockObservable.changeQuote("Apple", 92);
		stockObservable.changeQuote("Google",90 );
		
		map.put("Google",(float) 80);
		map.put("Apple",(float)  92);
		map.put("Google",(float) 90);
		
		//object check
		assertThat("Two map are not same",stockObservable.getMap(), is(map));
		
		//size check
		assertThat("Map size not same",stockObservable.getMap().size(), is(2));
		
		//check contain same key		
		assertTrue(stockObservable.getMap().keySet().containsAll((map.keySet())));
		
		//check two map object mapping same or not?			
		assertTrue(map.equals(stockObservable.getMap()));
	}
}
