package hw8.Observer;

import java.util.ArrayList;

public class Observable {
	private ArrayList<Observer> observers;
	
	
	public Observable() {
		
		observers = new ArrayList<Observer>();
	}
	
	public void addObservers(Observer o) {
		observers.add(o);
	}
	
	public void setChanged() {
		return;
	}
	public boolean hasChanged() {
		return true;
	}
	public void clearChanged() {
		return;
	}
	public void notifyObservers() {
		notifyObservers(null);
	}
	public void notifyObservers(Object arg) {
		
		if(hasChanged())
		{
			for (int counter = 0; counter < observers.size(); counter++)
			{ 		      
				
				System.out.println("\n");
		          observers.get(counter).update(this, arg);
		     }  
		}
		clearChanged();
	}
}
