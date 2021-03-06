package hw8.Multicast;

public class ThreeDObserver implements StockQuoteObserver,DJIAQuoteObserver {

	public void updateStock(StockEvent event) {
		System.out.println("ThreeDObserver_update: I am instance of StockEvent class.\n");
		System.out.println(event.getTicker()+ "  "+ event.getQuote()+" \n");
	}
	public void updateDJIA(DJIAEvent event) {
		System.out.println("ThreeDObserver_update: I am instance of DJIAEvent class.\n");
		System.out.println("DJIA:" +event.getDjia() +" \n");
	}
}