package edu.neu.csye7374;

public class FinanceTechStock extends StockAPI{

	public FinanceTechStock(String name, double price, String description, StockPriceStrategyAPI stockPriceStrategyAPI) {
		super(name, price, description, stockPriceStrategyAPI);
		
	}

	@Override
	public void setBid(String bid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMetric() {
		// TODO Auto-generated method stub
		return "Current Finance Tech Stock Price: $" + getPrice();
	}

}
