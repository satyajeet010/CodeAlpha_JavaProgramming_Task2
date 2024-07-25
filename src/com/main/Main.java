package com.main;

import com.market.Market;
import com.market.Stock;
import com.user.User;
import com.user.Transaction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        String name = "john_doe";
        double money = 10000.00;
        User user = new User(name, money);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View Market\t2. View Portfolio\n\n3. Buy Stock\t4. Sell Stock\n\n5. View Balance\t6.Add Money\n\n7.Withdraw Money\t8. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                	System.out.println("Market Data\n");
                    market.updateMarket();
                    market.displayMarket();
                    break;
                case 2:
                	System.out.println(user.getUsername()+" - Portfolio\n");
                    user.getPortfolio().displayPortfolio();
                    break;
                case 3:
                	System.out.println("Buy Stock\n");
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = scanner.nextLine().toUpperCase();
                    System.out.print("Enter quantity to buy: ");
                    int buyQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Stock buyStock = market.getStock(buySymbol);
                    if (buyStock != null) {
                        Transaction.buyStock(user, buyStock, buyQuantity);
                    } else {
                        System.out.println("Stock symbol not found.");
                    }
                    break;
                case 4:
                	System.out.println("Sell Stock\n");
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = scanner.nextLine().toUpperCase();
                    System.out.print("Enter quantity to sell: ");
                    int sellQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Stock sellStock = market.getStock(sellSymbol);
                    if (sellStock != null) {
                        Transaction.sellStock(user, sellStock, sellQuantity);
                    } else {
                        System.out.println("Stock symbol not found.");
                    }
                    break;
                case 5:
                	System.out.println(user.getUsername()+"\n");
                	System.out.println("Available Balance : "+user.getBalance());
                	break;
                case 6:
                	System.out.println("Add Balance\n");
                	System.out.print("Enter amount to add in your balance : ");
                	money=scanner.nextDouble();
                	scanner.nextLine(); // Consume newline
                	user.setBalance(user.getBalance() + money);
                	System.out.println(money+" amount of money added successfully.");
                	break;
                case 7:
                	System.out.println("Withdraw Money\n");
                	System.out.print("Enter amount to withdraw from your balance : ");
                	money=scanner.nextDouble();
                	scanner.nextLine(); // Consume newline
                	user.setBalance(user.getBalance() - money);
                	System.out.println(money+" amount of money withdrew successfully.");
                	break;
                case 8:
                	System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
