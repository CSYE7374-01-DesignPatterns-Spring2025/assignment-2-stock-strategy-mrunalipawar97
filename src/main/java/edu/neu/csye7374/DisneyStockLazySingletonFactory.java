package edu.neu.csye7374;

public class DisneyStockLazySingletonFactory implements AbstractFactory {

    private static DisneyStockLazySingletonFactory disneyStockLazySingletonFactory;
    
    private StockPriceStrategyAPI stockPriceStrategyAPI;

    private DisneyStockLazySingletonFactory() {
    	
    }

    public static synchronized DisneyStockLazySingletonFactory getInstance() {
        if(disneyStockLazySingletonFactory == null){
        	disneyStockLazySingletonFactory = new DisneyStockLazySingletonFactory();
        }
        return disneyStockLazySingletonFactory;
    }

    @Override
    public StockAPI getObject() {
        return new MediaStock("Disney Stock", 150.00, "Entertainment & Media Stock", stockPriceStrategyAPI);
    }

}
