package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public abstract class StockAPI implements Tradable {

	private String name;
	private double price;
	private String description;
	private StockPriceStrategyAPI stockPriceStrategyAPI;
	protected List<Double> bidHistory = new ArrayList<>();

	public StockAPI(String name, double price, String description, StockPriceStrategyAPI stockPriceStrategyAPI) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.stockPriceStrategyAPI = stockPriceStrategyAPI;
	}

	public void updatePrice() {
		this.price = stockPriceStrategyAPI.computeNewStockPrice(this.price);
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

	public void setBid(String bid) {
		// TODO Auto-generated method stub
		try {
			double bidValue = Double.parseDouble(bid);
			bidHistory.add(bidValue);
			price = bidValue; // Update price based on the latest bid
		} catch (NumberFormatException e) {
			System.out.println("Invalid bid format: " + bid);
		}

	}

	@Override
	public String toString() {
		return "StockAPI [name=" + name + ", price=" + price + ", description=" + description
				+ ", stockPriceStrategyAPI=" + stockPriceStrategyAPI + ", bidHistory=" + bidHistory + "]";
	}
	
}
