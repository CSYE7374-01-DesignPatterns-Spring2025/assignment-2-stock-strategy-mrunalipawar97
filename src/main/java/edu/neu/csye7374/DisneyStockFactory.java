package edu.neu.csye7374;

public class DisneyStockFactory implements AbstractFactory {
	
	private StockPriceStrategyAPI stockPriceStrategyAPI; // Add strategy field
	
    public DisneyStockFactory(StockPriceStrategyAPI stockPriceStrategyAPI) {
		super();
		this.stockPriceStrategyAPI = stockPriceStrategyAPI;
	}

	@Override
    public StockAPI getObject() {
        return new MediaStock("Disney Stock", 150.00, "Entertainment & Media Stock", stockPriceStrategyAPI);
    }

}


