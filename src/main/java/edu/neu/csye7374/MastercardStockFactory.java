package edu.neu.csye7374;

public class MastercardStockFactory implements AbstractFactory {
	
	private StockPriceStrategyAPI stockPriceStrategyAPI; // Add strategy field
	
	public MastercardStockFactory() {
		
	}
	
    public MastercardStockFactory(StockPriceStrategyAPI stockPriceStrategyAPI) {
		super();
		this.stockPriceStrategyAPI = stockPriceStrategyAPI;
	}

	@Override
	public StockAPI getObject() {
		
		return new FinanceTechStock("Mastercard Inc.", 560.00, "FinTech Sector Stock");
	}
    

}
