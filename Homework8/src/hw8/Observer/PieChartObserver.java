package hw8.Observer;




public class PieChartObserver implements Observer {
	
//	private Set<DJIAEvent> DJIAEventset;
//	private Set<StockEvent> StockEvent;
//	public  PieChartObserver()
//	{
//		DJIAEventset = new HashSet<DJIAEvent>();
//		StockEvent = new HashSet<StockEvent>();
//	}
//	

	public void update(Observable obs,Object arg) {
		if(arg instanceof DJIAEvent) {
			DJIAEvent dJIAEvent = (DJIAEvent) arg;
			System.out.println("PieChartObserver_update: I am instance of DJIAEvent class.\n");
			System.out.println("DJIA :" +dJIAEvent.getDjia() +" \n");
		}else if(arg instanceof StockEvent) {
			StockEvent stockevent = (StockEvent) arg;
			System.out.println("PieChartObserver_update: I am instance of StockEvent class.\n");
			System.out.println(stockevent.getTicker()+ "  "+ stockevent.getQuote()+" \n");
		}
	}
//	private void drawDJIAEvent(Set<DJIAEvent> set) 
//	{
//		System.out.println("\nAfter Updating Pie Chart");
//		 for (DJIAEvent d : set) 
//		 {
//			 System.out.println("DJIA:" +d.getDjia() +" \n");
//	      }
//	}
}
