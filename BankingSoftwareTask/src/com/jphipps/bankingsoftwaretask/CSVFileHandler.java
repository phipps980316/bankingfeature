package com.jphipps.bankingsoftwaretask;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVFileHandler {
    private final String ACCOUNT_ID_HEADING = "AccountID";
    private final String ACCOUNT_TYPE_HEADING = "AccountType";
    private final String INITIATOR_TYPE_HEADING = "InitiatorType";
    private final String DATE_TIME_HEADING = "DateTime";
    private final String TRANSACTION_VALUE_HEADING = "TransactionValue";

    public ArrayList<Transaction> readTransactionsFromFile(String filePath) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            ArrayList<String> headings = new ArrayList<>();
            String row;
            while ((row = reader.readLine()) != null) {
                String[] fetchedData = row.split(",");
                if (fetchedData[0].equals(ACCOUNT_ID_HEADING)){
                    headings.addAll(Arrays.asList(fetchedData));
                }
                else{
                    String accountID = fetchedData[headings.indexOf(ACCOUNT_ID_HEADING)];
                    String accountType = fetchedData[headings.indexOf(ACCOUNT_TYPE_HEADING)];
                    String initiatorType = fetchedData[headings.indexOf(INITIATOR_TYPE_HEADING)];
                    String dateTime = fetchedData[headings.indexOf(DATE_TIME_HEADING)];
                    String transactionValue = fetchedData[headings.indexOf(TRANSACTION_VALUE_HEADING)];
                    Transaction newTransaction = new Transaction(accountID, accountType, initiatorType, dateTime, transactionValue);
                    transactions.add(newTransaction);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error Reading File");
            e.printStackTrace();
        }
        return transactions;
    }

    public void saveTransactionsToFile(ArrayList<Transaction> transactions, String fileName) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.append(ACCOUNT_ID_HEADING);
            writer.append(",");
            writer.append(ACCOUNT_TYPE_HEADING);
            writer.append(",");
            writer.append(INITIATOR_TYPE_HEADING);
            writer.append(",");
            writer.append(DATE_TIME_HEADING);
            writer.append(",");
            writer.append(TRANSACTION_VALUE_HEADING);
            writer.append("\n");

            for (Transaction transaction : transactions){
                writer.append(String.valueOf(transaction.getAccountId()));
                writer.append(",");
                writer.append(transaction.getAccountTypeString());
                writer.append(",");
                writer.append(transaction.getInitiatorTypeString());
                writer.append(",");
                writer.append(transaction.getDateTime());
                writer.append(",");
                writer.append(decimalFormat.format(transaction.getValue()));
                writer.append("\n");
            }
            writer.flush();
            writer.close();

        } catch (IOException e) {
            System.out.println("Error Writing File");
            e.printStackTrace();
        }
    }
}
