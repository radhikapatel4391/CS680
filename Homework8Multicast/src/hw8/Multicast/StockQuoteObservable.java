package hw8.Multicast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StockQuoteObservable {
	
	private ArrayList<StockQuoteObserver>  StockQuoteobservers;
	private Set<StockEvent> data = new HashSet<StockEvent>();
	
	public Set<StockEvent> getData() {
		return data;
	}
	public StockQuoteObservable() {
		StockQuoteobservers = new  ArrayList<StockQuoteObserver> ();
	}
	public void addObservers(StockQuoteObserver o) {
		StockQuoteobservers.add(o);
	}
	
	public void notifyObservers(StockEvent arg) {
		
		data.add(arg);
		for (int counter = 0; counter < StockQuoteobservers.size(); counter++)
		{ 
			System.out.println("\n");
			StockQuoteobservers.get(counter).updateStock(arg);
	     }  
	
	
}
	
}
