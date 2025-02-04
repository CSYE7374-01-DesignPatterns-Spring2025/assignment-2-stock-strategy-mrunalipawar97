package edu.neu.csye7374;

/**
 * Optimistic Market Strategy: Bull Market (price increases)
 */
public class BullMarketStrategy implements StockPriceStrategyAPI {

	@Override
	public double computeNewStockPrice(double currentPrice) {
		double discountRate = 1.1; // // Increase by 10% 
		return currentPrice * discountRate;
	}

}
