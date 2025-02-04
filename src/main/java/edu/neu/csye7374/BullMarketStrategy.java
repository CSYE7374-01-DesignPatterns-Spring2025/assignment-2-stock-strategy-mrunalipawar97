package edu.neu.csye7374;

/**
 * Optimistic Market Strategy: Bull Market (price increases)
 */
public class BullMarketStrategy implements StockPriceStrategyAPI {

	@Override
	public double computeNewStockPrice(double currentPrice, double bid) {
		double discountRate = 1.10; // // Increase by 10% 
		return currentPrice * discountRate;
	}

}
