package com.jphipps.bankingsoftwaretask;

public class SavingsAccount extends Account {

    public void updateBalance(double amount){
        Logger logger = new Logger();
        if(amount >= 0) {
            balance += Math.abs(amount);
            logger.addedToSavingAccountBalance(amount, this.id, this.balance);
        }
        else {
            balance -= Math.abs(amount);
            logger.subtractedFromSavingAccountBalance(amount, this.id, this.balance);
        }
    }
}
