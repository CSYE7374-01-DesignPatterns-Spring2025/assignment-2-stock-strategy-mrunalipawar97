package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

	private static StockMarket stockMarketInstance;

	private List<StockAPI> stocks = new ArrayList<>();

	private StockMarket() {

	}

	public static StockMarket getInstance() {
		if (stockMarketInstance == null) {
			stockMarketInstance = new StockMarket();
		}
		return stockMarketInstance;
	}

	public void addStock(StockAPI stock) {
		stocks.add(stock);
	}

	public void removeStock(StockAPI stock) {
		boolean isRemoved = this.stocks.remove(stock);

		if (!isRemoved) {
			System.out.println("stock was not found to be traded");
		}
	}

	public void tradeStock(StockAPI stock, String bid) {
		stock.setBid(bid);
		System.out.println("Traded: " + stock.toString());
	}

	private StockPriceStrategyAPI stockPriceStrategyAPI;

	public StockPriceStrategyAPI getStockPriceStrategyAPI() {
		return stockPriceStrategyAPI;
	}

	public void setStockPriceStrategyAPI(StockPriceStrategyAPI stockPriceStrategyAPI) {
		this.stockPriceStrategyAPI = stockPriceStrategyAPI;
	}

	/**
	 * Demonstration of Strategy Pattern
	 */
	public static void demo() {

		StockMarket stockMarket = getInstance();

		// Initial Strategies
		StockPriceStrategyAPI bullMarketStrategy = new BullMarketStrategy();
		StockPriceStrategyAPI bearMarketStrategy = new BearMarketStrategy();

		// Initial Stock Prices
		System.out.println("Initial Stock Prices:");

		FinanceTechStock financeTechStock = new FinanceTechStock("Mastercard Inc.", 560.00, "FinTech Sector Stock", bullMarketStrategy);
		MediaStock mediaStock = new MediaStock("Disney Stock", 150.00, "Entertainment & Media Stock", bearMarketStrategy);
		

		stockMarket.addStock(financeTechStock);
		stockMarket.addStock(mediaStock);
		

		// Applying Market Conditions
		System.out.println("\nApplying Market Conditions:");

		String[] bids = { "132.89", "130.98", "135.00", "134.02", "136.00", "139.02" };
		for (String bid : bids) {
			stockMarket.tradeStock(financeTechStock, bid);
		}
		System.out.println(financeTechStock.getMetric());
		System.out.println();

		bids = new String[] { "132", "130", "135", "134", "136", "139" };
		for (String bid : bids) {
			stockMarket.tradeStock(mediaStock, bid);
		}
		System.out.println(mediaStock.getMetric());
		System.out.println();



		// Updating stock prices in Bull Market

		// Update prices based on the current strategy
		financeTechStock.updatePrice(); // Mastercard stock price increases by 10%
		mediaStock.updatePrice(); // disney stock price decreases by 10%

		// Updating stock prices in Bear Market

		// Changing strategy dynamically
	}
}
