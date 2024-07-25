package com.market;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Market {
    private Map<String, Stock> stocks;
    private Random random;

    public Market() {
        stocks = new HashMap<>();
        random = new Random();
        initializeMarket();
    }

    private void initializeMarket() {
        stocks.put("AAPL", new Stock("AAPL", "Apple Inc.", 150.00));
        stocks.put("GOOGL", new Stock("GOOGL", "Alphabet Inc.", 2800.00));
        stocks.put("AMZN", new Stock("AMZN", "Amazon.com Inc.", 3300.00));
        // Add more stocks as needed
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol);
    }

    public void updateMarket() {
        for (Stock stock : stocks.values()) {
            double change = (random.nextDouble() - 0.5) * 20; // Random price change
            stock.setPrice(stock.getPrice() + change);
        }
    }

    public void displayMarket() {
        for (Stock stock : stocks.values()) {
            System.out.println(stock);
        }
    }
}
