package edu.neu.csye7374;

/**
 * Pessimistic Market Strategy: Bear Market (price decreases)
 */
public class BearMarketStrategy implements StockPriceStrategyAPI{

	@Override
	public double computeNewStockPrice(double currentPrice, double bid) {
		double discountRate = 0.90; //Decrease by 10%
		double newPrice = currentPrice + (bid - currentPrice) * discountRate;
		if (newPrice < 50) {  // Minimum price threshold
	        newPrice = 50;
	    }
		return newPrice ;
		
	}

}
