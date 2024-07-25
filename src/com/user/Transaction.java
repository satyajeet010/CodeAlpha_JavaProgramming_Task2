package com.user;

import com.market.Stock;

public class Transaction {
    public static void buyStock(User user, Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (user.getBalance() >= cost) {
            user.setBalance(user.getBalance() - cost);
            user.getPortfolio().addStock(stock.getSymbol(), quantity);
            System.out.println("Bought " + quantity + " shares of " + stock.getName());
        } else {
            System.out.println("Insufficient balance to buy " + quantity + " shares of " + stock.getName());
        }
    }

    public static void sellStock(User user, Stock stock, int quantity) {
        if (user.getPortfolio().getStocks().getOrDefault(stock.getSymbol(), 0) >= quantity) {
            double revenue = stock.getPrice() * quantity;
            user.setBalance(user.getBalance() + revenue);
            user.getPortfolio().removeStock(stock.getSymbol(), quantity);
            System.out.println("Sold " + quantity + " shares of " + stock.getName());
        } else {
            System.out.println("Insufficient shares to sell " + quantity + " shares of " + stock.getName());
        }
    }
}
