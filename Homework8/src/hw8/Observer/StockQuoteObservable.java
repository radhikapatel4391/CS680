package hw8.Observer;

import java.util.HashMap;

public class StockQuoteObservable extends Observable {
	
	
	private HashMap<String, Float> map;
	
	public HashMap<String, Float> getMap() {
		return map;
	}

	public StockQuoteObservable() {
		map = new HashMap<>();
	}
	
	public void changeQuote(String t,float q) {
		
		this.map.put(t,q);
		setChanged();
		notifyObservers(new StockEvent(t,q));
	}

}
