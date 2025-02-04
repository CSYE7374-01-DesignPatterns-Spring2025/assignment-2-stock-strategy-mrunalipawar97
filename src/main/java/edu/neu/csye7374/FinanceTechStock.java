package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

/***
 *  FinanceTechStock 
 */

public class FinanceTechStock extends StockAPI {

	List<Double> bidList = new ArrayList<>();

	public FinanceTechStock(String name, double price, String description) {
		super(name, price, description);

	}

	@Override
	public void setBid(String bid) {
		// TODO Auto-generated method stub
		double bidValue = Double.parseDouble(bid);
		bidList.add(bidValue);
		setPrice(bidValue);
		//System.out.println("The price for " + this.getName() + " is now " + bidValue);
	}

	@Override
	public String getMetric() {
		// TODO Auto-generated method stub
		double bidAvgValue = bidList.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
	    
	    return String.format("The Metric for %s: Average Bid for the past %d bid values is: %.2f", 
	                          this.getName(), bidList.size(), bidAvgValue);
	}

}
