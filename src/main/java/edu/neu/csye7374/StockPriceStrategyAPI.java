package edu.neu.csye7374;


/* 
 * Strategy interface for stock price computation 
 * Defines the strategy pattern
 * */
public interface StockPriceStrategyAPI {
	
	double computeNewStockPrice(double currentPrice, double bid);
}
