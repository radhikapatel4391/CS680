package hw8.Multicast;

public class StockEvent {
	private String ticker;
	private float quote;
	
	public String getTicker() {
		return ticker;
	}

	public float getQuote() {
		return quote;
	}

	public void setQuote(float quote) {
		this.quote = quote;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}	
	
	public StockEvent(String ticker, float quote) {
		this.ticker = ticker;
		this.quote = quote;
	}
	
}
