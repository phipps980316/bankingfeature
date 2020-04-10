package com.jphipps.bankingsoftwaretask;

public class Account {
    protected int id;
    protected double balance;

    Account() {
        id = -1;
        balance = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }
}
