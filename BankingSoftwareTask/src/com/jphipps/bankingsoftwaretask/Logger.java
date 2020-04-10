package com.jphipps.bankingsoftwaretask;

import java.text.DecimalFormat;

public class Logger {
    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public void addedToCurrentAccountBalance(double amount, int id, double balance) {
        double absoluteAmount = Math.abs(amount);
        System.out.println("Added £" + decimalFormat.format(absoluteAmount) + " To Current Account (ID: " + id + "), Current Account Balance: " + decimalFormat.format(balance));
    }

    public void subtractedFromCurrentAccountBalance(double amount, int id, double balance) {
        double absoluteAmount = Math.abs(amount);
        System.out.println("Subtracted £" + decimalFormat.format(absoluteAmount) + " From Current Account (ID: " + id + "), Current Account Balance: " + decimalFormat.format(balance));
    }

    public void addedToSavingAccountBalance(double amount, int id, double balance) {
        double absoluteAmount = Math.abs(amount);
        System.out.println("Added £" + decimalFormat.format(absoluteAmount) + " To Saving Account (ID: " + id + "), Saving Account Balance: " + decimalFormat.format(balance));
    }

    public void subtractedFromSavingAccountBalance(double amount, int id, double balance) {
        double absoluteAmount = Math.abs(amount);
        System.out.println("Subtracted £" + decimalFormat.format(absoluteAmount) + " From Saving Account (ID: " + id + "), Saving Account Balance: " + decimalFormat.format(balance));
    }

    public void loadedTransactionsForCustomer(int id, String filePath) {
        System.out.println("Loaded Transactions For Customer (ID: " + id + ") From: " + filePath);
    }

    public void savedTransactionsForCustomer(int id, String filePath) {
        System.out.println("Saved Transactions For Customer (ID: " + id + ") To: " + filePath);
    }

    public void processingTransactionsForCustomer(int id) {
        System.out.println("Processing Transactions For Customer (ID: " + id + ")");
    }

    public void finishedProcessingForCustomer(int id) {
        System.out.println("Finished Processing Transactions For Customer (ID: " + id + ")");
    }
}
