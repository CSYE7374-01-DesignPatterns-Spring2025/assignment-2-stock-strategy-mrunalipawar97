package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

	private static StockMarket stockMarketInstance;

	private List<StockAPI> stocks;

	private StockPriceStrategyAPI stockPriceStrategyAPI;

	private StockMarket() {
		stocks = new ArrayList<>();
	}

	public static synchronized StockMarket getInstance() {
		if (stockMarketInstance == null) {
			stockMarketInstance = new StockMarket();
		}
		return stockMarketInstance;
	}

	public void tradeStock(StockAPI stock, String bid) {
		stock.setBid(bid);
		System.out.println("Traded: " + stock.toString());
	}

	public StockPriceStrategyAPI getStockPriceStrategyAPI() {
		return stockPriceStrategyAPI;
	}

	public void setStockPriceStrategyAPI(StockPriceStrategyAPI stockPriceStrategyAPI) {
		this.stockPriceStrategyAPI = stockPriceStrategyAPI;
	}

	public void addStock(StockAPI stock) {
		stocks.add(stock);
	}

	public void removeStock(StockAPI stock) {
		stocks.remove(stock);
	}

	public void showAllStocks() {
		if (stocks.isEmpty()) {
			return;
		}
		for (StockAPI stock : stocks) {
			System.out.println(stock);
			System.out.println("Performance Metric: " + stock.getMetric());
			System.out.println("-------------------");
		}
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

		MastercardStockEagerFactory mastercardStockEagerFactory = MastercardStockEagerFactory.getInstance();
		StockAPI mastercardEager = mastercardStockEagerFactory.getObject();

		FinanceTechStock financeTechStock = new FinanceTechStock("Mastercard Inc.", 560.00, "FinTech Sector Stock");
		MediaStock mediaStock = new MediaStock();

		// Applying Market Conditions
		System.out.println("\nApplying Market Conditions:");
		stockMarket.showAllStocks();

		System.out.println("financeTech stocks Eager");
		// financeTech stocks
		stockMarket.addStock(financeTechStock);
		financeTechStock.setStockPriceStrategyAPI(bullMarketStrategy);

		String[] bids = { "332.89", "330.98", "435.00", "424.02", "536.00", "239.02" };
		for (String bid : bids) {
			System.out.println("\nPlacing bid: " + bid);
			stockMarket.tradeStock(financeTechStock, bid);
		}
		System.out.println(financeTechStock.getMetric());
		System.out.println();

		System.out.println("Media stocks Lazy");
		// media stocks
		DisneyStockLazySingletonFactory disneyStockLazySingletonFactory = DisneyStockLazySingletonFactory.getInstance();
		StockAPI disneyLazy = disneyStockLazySingletonFactory.getObject();
		stockMarket.addStock(mediaStock);
		mediaStock.setStockPriceStrategyAPI(bearMarketStrategy);

		bids = new String[] { "132", "130", "135", "134", "136", "139" };
		for (String bid : bids) {
			System.out.println("\nPlacing bid: " + bid);
			stockMarket.tradeStock(mediaStock, bid);
		}
		System.out.println(mediaStock.getMetric());
		System.out.println();

		// Update prices based on the current strategy
		financeTechStock.updatePrice(); // Mastercard stock price increases by 10%
		mediaStock.updatePrice(); // Disney stock price decreases by 10%

		// Changing strategy dynamically

		System.out.println("Mastercard factory");

		MastercardStockFactory mastercardfacFactory = new MastercardStockFactory();
		StockAPI mastercard = mastercardfacFactory.getObject();
		mastercard.setStockPriceStrategyAPI(bearMarketStrategy);
		bids = new String[]{ "332.89", "330.98", "435.00", "424.02", "536.00", "239.02" };
		for (String bid : bids) {
            stockMarket.tradeStock(mastercard, bid);
        }
        System.out.println(mastercard.getMetric());
        System.out.println();
		
		System.out.println("Disney Factory");
		DisneyStockFactory disneyStockFactory = new DisneyStockFactory();
		StockAPI disney = disneyStockFactory.getObject();
		disney.setStockPriceStrategyAPI(bullMarketStrategy);
		bids = new String[] { "132", "130", "135", "134", "136", "139" };
		for (String bid : bids) {
            stockMarket.tradeStock(disney, bid);
        }
        System.out.println(disney.getMetric());
        System.out.println();
        
		System.out.println("\nUpdated Stock Prices:");
		System.out.println(financeTechStock.getMetric());
		System.out.println(mediaStock.getMetric());
	}
}
