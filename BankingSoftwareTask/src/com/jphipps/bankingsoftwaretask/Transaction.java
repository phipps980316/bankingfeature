package com.jphipps.bankingsoftwaretask;

public class Transaction {
    private final int accountID;
    private final AccountType accountType;
    private final InitiatorType initiatorType;
    private final String dateTime;
    private final double value;

    Transaction(int accountID, AccountType accountType, String dateTime, double value) {
        this.accountID = accountID;
        this.accountType = accountType;
        this.initiatorType = InitiatorType.SYSTEM;
        this.dateTime = dateTime;
        this.value = value;
    }

    Transaction(String accountID, String accountType, String initiatorType, String dateTime, String value) {
        this.accountID = Integer.parseInt(accountID);
        this.dateTime = dateTime;
        this.value = Double.parseDouble(value);

        switch (accountType) {
            case "CURRENT":
                this.accountType = AccountType.CURRENT;
                break;
            case "SAVINGS":
                this.accountType = AccountType.SAVINGS;
                break;
            default:
                this.accountType = AccountType.NONE;
                break;
        }

        switch (initiatorType) {
            case "ACCOUNT-HOLDER":
                this.initiatorType = InitiatorType.ACCOUNT_HOLDER;
                break;
            case "SYSTEM":
                this.initiatorType = InitiatorType.SYSTEM;
                break;
            default:
                this.initiatorType = InitiatorType.NONE;
                break;
        }
    }

    public int getAccountId() {
        return accountID;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getAccountTypeString() {
       switch (accountType) {
           case CURRENT:
               return "CURRENT";
           case SAVINGS:
               return "SAVINGS";
           default:
               return "NONE";
       }
    }

    public String getInitiatorTypeString() {
        switch (initiatorType) {
            case ACCOUNT_HOLDER:
                return "ACCOUNT-HOLDER";
            case SYSTEM:
                return "SYSTEM";
            default:
                return "NONE";
        }
    }

    public String getDateTime() {
        return dateTime;
    }

    public double getValue() {
        return value;
    }
}
