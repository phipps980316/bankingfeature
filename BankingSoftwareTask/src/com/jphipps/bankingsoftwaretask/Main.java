package com.jphipps.bankingsoftwaretask;

public class Main {

    public static void main(String[] args) {

        BankingFeature bankingFeature = new BankingFeature();
        bankingFeature.addCustomerLedger("C:\\Users\\Jon Phipps\\Desktop\\transactions.csv");
        bankingFeature.addCustomerLedger("C:\\Users\\Jon Phipps\\Desktop\\transactions2.csv");
        bankingFeature.addCustomerLedger("C:\\Users\\Jon Phipps\\Desktop\\transactions3.csv");
        bankingFeature.processCustomerLedgers();
        bankingFeature.saveCustomerLedgers();

    }
}
