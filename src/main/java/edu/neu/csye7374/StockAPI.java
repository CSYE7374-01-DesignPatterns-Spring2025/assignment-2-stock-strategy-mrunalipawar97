package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public abstract class StockAPI implements Tradable {

	private String name;
	private double price;
	private String description;
	double bid;
	protected int bidCount = 0;
	private StockPriceStrategyAPI stockPriceStrategyAPI;
	protected List<Double> bidHistory = new ArrayList<>();

	public StockAPI(String name, double price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public void updatePrice() {
		this.price = stockPriceStrategyAPI.computeNewStockPrice(this.price, bid);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StockPriceStrategyAPI getStockPriceStrategyAPI() {
		return stockPriceStrategyAPI;
	}

	public void setStockPriceStrategyAPI(StockPriceStrategyAPI stockPriceStrategyAPI) {
		this.stockPriceStrategyAPI = stockPriceStrategyAPI;
	}

	public void setBid(double bid) {
		// TODO Auto-generated method stub
		if (stockPriceStrategyAPI == null) {
            throw new IllegalStateException("Market strategy isnt set or avialble");
        }
        price = stockPriceStrategyAPI.computeNewStockPrice(price, bid);

	}

	@Override
	public String toString() {
		String strategyName = (stockPriceStrategyAPI != null) ? stockPriceStrategyAPI.getClass().getSimpleName() : "None";
	    return "StockAPI [name=" + name + ", price=" + price + ", description=" + description
	            + ", strategy=" + strategyName + "]";
	}
	
}
