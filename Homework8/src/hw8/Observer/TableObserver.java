package hw8.Observer;

public class TableObserver implements Observer {

	public void update(Observable obs,Object arg) {
		if(arg instanceof DJIAEvent) {
			DJIAEvent dJIAEvent = (DJIAEvent) arg;
			System.out.println("TableObserver_update: I am instance of DJIAEvent class.\n");
			System.out.println("DJIA:" +dJIAEvent.getDjia() +" \n");
		}else if(arg instanceof StockEvent) {
			StockEvent stockevent = (StockEvent) arg;
			System.out.println("TableObserver_update: I am instance of StockEvent class.\n");
			System.out.println(stockevent.getTicker()+ "  "+ stockevent.getQuote()+" \n");
		}
	}
}