package edu.neu.csye7374;

/*
 * Pessimistic Market Strategy: Bear Market (price decreases)
 */
public class BearMarketStrategy implements StockPriceStrategyAPI{

	@Override
	public double computeNewStockPrice(double currentPrice) {
		double discountRate = 0.9; //Decrease by 10%
		return currentPrice * discountRate;
	}

}
