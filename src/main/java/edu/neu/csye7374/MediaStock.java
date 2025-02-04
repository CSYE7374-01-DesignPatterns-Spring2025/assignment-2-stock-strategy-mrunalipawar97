package edu.neu.csye7374;

public class MediaStock extends StockAPI{

	public MediaStock(String name, double price, String description, StockPriceStrategyAPI stockPriceStrategyAPI) {
		super(name, price, description, stockPriceStrategyAPI);
	}

	@Override
	public void setBid(String bid) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getMetric() {
		// TODO Auto-generated method stub
		return "Current Media Tech Stock Price: $" + getPrice();
	}

}
