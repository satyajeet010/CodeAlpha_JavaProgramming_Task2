package com.user;

public class User {
    private String username;
    private double balance;
    private Portfolio portfolio;

    public User(String username, double balance) {
        this.username = username;
        this.balance = balance;
        this.portfolio = new Portfolio();
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }
}
