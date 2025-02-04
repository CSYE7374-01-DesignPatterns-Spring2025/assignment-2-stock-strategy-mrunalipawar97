package edu.neu.csye7374;


/* 
 * Strategy interface for stock price computation 
 * */
public interface StockPriceStrategyAPI {
	
	double computeNewStockPrice(double currentPrice);
}
