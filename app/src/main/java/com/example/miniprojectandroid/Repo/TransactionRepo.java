package com.example.miniprojectandroid.Repo;

import com.example.miniprojectandroid.transaction_classes.Transaction;
import com.example.miniprojectandroid.transaction_classes.TransactionType;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class TransactionRepo {
    private static TransactionRepo instance;

    private TransactionRepo() {
    }

    public static TransactionRepo getInstance() {
        if (instance == null)
            instance = new TransactionRepo();
        return instance;
    }

    public ArrayList<Transaction> dummyData(int numofItem) {
        int id = 0, accountNumber = 1001;
        double updatedBalance, amount = 200, balance = 1500.00;
        ArrayList<Transaction> transactions = new ArrayList<>();

        String[] dates = {"January 20,2024", "January 14,2024", "January 15,2024", "January 16,2024", "January 17,2024", "January 18,2024", "January 19,2024"};
        TransactionType[] types = {TransactionType.DEPOSITE, TransactionType.WITHDRAWAL};

        for (int i = numofItem; i < 8; i++) {
            double updatedAmount = amount * i;

            if (types[i % 2] == TransactionType.DEPOSITE) {
                updatedBalance = balance + updatedAmount;
            } else {
                updatedBalance = balance - updatedAmount;
            }
            transactions.add(new Transaction(id + 1, accountNumber, dates[i % 7], updatedAmount, updatedBalance, types[i % 2]));
            balance = updatedBalance;
            id++;
        }
        return transactions;
    }
}
