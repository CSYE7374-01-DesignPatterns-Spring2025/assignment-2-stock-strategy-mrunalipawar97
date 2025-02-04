package edu.neu.csye7374;

public class MastercardStockEagerFactory implements AbstractFactory {
	
    public static final MastercardStockEagerFactory INSTANCE = new MastercardStockEagerFactory();
    
    private MastercardStockEagerFactory() {
    	
    }

    public static synchronized MastercardStockEagerFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public StockAPI getObject() {
        return new FinanceTechStock("Mastercard Inc.", 560.00, "FinTech Sector Stock");
    }

}
