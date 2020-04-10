package com.jphipps.bankingsoftwaretask;

public class CurrentAccount extends Account{

    public void updateBalance(double amount){
        Logger logger = new Logger();
        if(amount >= 0) {
            balance += Math.abs(amount);
            logger.addedToCurrentAccountBalance(amount, this.id, this.balance);
        }
        else {
            balance -= Math.abs(amount);
            logger.subtractedFromCurrentAccountBalance(amount, this.id, this.balance);
        }
    }
}
