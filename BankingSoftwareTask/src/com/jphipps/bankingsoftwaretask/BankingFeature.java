package com.jphipps.bankingsoftwaretask;

import java.util.ArrayList;

public class BankingFeature {
    private final CSVFileHandler fileHandler;
    private final Logger logger;
    private final ArrayList<Customer> customers;
    private int customerID;

    BankingFeature() {
        fileHandler = new CSVFileHandler();
        logger = new Logger();
        customers = new ArrayList<>();
        customerID = 0;
    }

    public void addCustomerLedger(String filePath) {
        ArrayList<Transaction> transactions = fileHandler.readTransactionsFromFile(filePath);
        if(transactions.size() > 0) logger.loadedTransactionsForCustomer(customerID, filePath);
        customers.add(new Customer(customerID, filePath, transactions));
        customerID++;
    }

    public void processCustomerLedgers(){
        for(Customer customer : customers) {
            logger.processingTransactionsForCustomer(customer.getId());
            ArrayList<Transaction> transactions = customer.getTransactions();
            CurrentAccount currentAccount = customer.getCurrentAccount();
            SavingsAccount savingsAccount = customer.getSavingsAccount();

            for(Transaction transaction: transactions) {
                switch (transaction.getAccountType()){
                    case CURRENT:
                        if(currentAccount.getId() < 0) currentAccount.setId(transaction.getAccountID());
                        currentAccount.updateBalance(transaction.getValue());
                        break;
                    case SAVINGS:
                        if(savingsAccount.getId() < 0) savingsAccount.setId(transaction.getAccountID());
                        savingsAccount.updateBalance(transaction.getValue());
                        break;
                    default:
                        break;
                }

                customer.addCompletedTransaction(transaction);

                if(currentAccount.getBalance() < 0 && savingsAccount.getBalance() > 0) {
                    double outstandingDebt = Math.abs(currentAccount.getBalance());
                    double amountToTransfer = Math.min(savingsAccount.getBalance(), outstandingDebt);
                    savingsAccount.updateBalance(-amountToTransfer);
                    customer.addCompletedTransaction(new Transaction(savingsAccount.getId(), AccountType.SAVINGS, transaction.getDateTime(), -amountToTransfer));
                    currentAccount.updateBalance(amountToTransfer);
                    customer.addCompletedTransaction(new Transaction(currentAccount.getId(), AccountType.CURRENT, transaction.getDateTime(), amountToTransfer));
                }
            }
            logger.finishedProcessingForCustomer(customer.getId());
        }
    }

    public void saveCustomerLedgers() {
        for(Customer customer : customers){
            ArrayList<Transaction> completedTransactions = customer.getCompletedTransactions();
            String outputPath = customer.getSavingFilePath();
            fileHandler.saveTransactionsToFile(completedTransactions, outputPath);
            logger.savedTransactionsForCustomer(customer.getId(), outputPath);
        }
    }
}
