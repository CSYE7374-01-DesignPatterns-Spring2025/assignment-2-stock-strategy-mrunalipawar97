package edu.neu.csye7374;

public class MediaStock extends StockAPI {

	private double bidVal;

	public MediaStock() {
		super("Disney Stock", 150.00, "Entertainment & Media Stock");
	}

	@Override
	public void setBid(String bid) {
		// TODO Auto-generated method stub
		bidVal = Double.parseDouble(bid);
		double newPrice = getPrice() * 0.90; // 10% decrease
		if (newPrice < 50) {
			newPrice = 50; // Set a minimum threshold for the price
			
		}
		setPrice(newPrice);
		// System.out.println("Bid " + bidCount + " : " + bidVal);
		bidCount++;
	}

	@Override
	public String getMetric() {
		// TODO Auto-generated method stub
		int performanceMetric = (int) (getPrice() / 10);
		return "Current Media Tech Stock Price: $" + getPrice();
	}
}
