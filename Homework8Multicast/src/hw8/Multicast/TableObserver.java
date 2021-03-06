package hw8.Multicast;

public class TableObserver implements StockQuoteObserver,DJIAQuoteObserver {

	public void updateStock(StockEvent event) {
		System.out.println("TableObserver_update: I am instance of StockEvent class.\n");
		System.out.println(event.getTicker()+ "  "+ event.getQuote()+" \n");
	}
	public void updateDJIA(DJIAEvent event) {
		System.out.println("TableObserver_update: I am instance of DJIAEvent class.\n");
		System.out.println("DJIA:" +event.getDjia() +" \n");
	}
}