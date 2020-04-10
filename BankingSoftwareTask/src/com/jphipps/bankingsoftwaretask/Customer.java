package com.jphipps.bankingsoftwaretask;

import java.util.ArrayList;

public class Customer {
    private final int id;
    private final String filePath;
    private final CurrentAccount currentAccount;
    private final SavingsAccount savingsAccount;
    private final ArrayList<Transaction> transactions;
    private final ArrayList<Transaction> completedTransactions;

    Customer(int id, String filePath, ArrayList<Transaction> transactions) {
        this.id = id;
        this.filePath = filePath;
        currentAccount = new CurrentAccount();
        savingsAccount = new SavingsAccount();
        this.transactions = transactions;
        completedTransactions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getSavingFilePath() {
        String outputFilePath;
        int fileExtension = filePath.toLowerCase().indexOf(".csv");
        outputFilePath = filePath.substring(0, fileExtension);
        outputFilePath = outputFilePath + "-processed.csv";
        return outputFilePath;
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void addCompletedTransaction(Transaction transactions) {
        completedTransactions.add(transactions);
    }

    public ArrayList<Transaction> getCompletedTransactions() {
        return completedTransactions;
    }
}
