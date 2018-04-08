package hw8.Multicast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



public class DJIAQuoteObservable {
	
	private ArrayList<DJIAQuoteObserver>  DJIAQuoteobservers;
	private Set<DJIAEvent> data = new HashSet<DJIAEvent>();
	
	public DJIAQuoteObservable() {
		DJIAQuoteobservers = new ArrayList<DJIAQuoteObserver> ();
	}
	
	public Set<DJIAEvent> getData() {
		return data;
	}
	
	public void addObservers(DJIAQuoteObserver o) {
		
		DJIAQuoteobservers.add(o);
	}
	public void notifyObservers(DJIAEvent arg) {
		
		data.add(arg);
			for (int counter = 0; counter < DJIAQuoteobservers.size(); counter++)
			{ 
				System.out.println("\n");
				DJIAQuoteobservers.get(counter).updateDJIA(arg);
		     }  
		
		
	}
}
