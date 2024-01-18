package com.example.miniprojectandroid.Repo;

import com.example.miniprojectandroid.transaction_classes.Transaction;
import com.example.miniprojectandroid.transaction_classes.TransactionType;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class TransactionRepo {

    private static TransactionRepo instance;

    private TransactionRepo(){

    }

    public static TransactionRepo getInstance(){
        if (instance == null)
            instance = new TransactionRepo();
        return instance;
    }

    public ArrayList<Transaction> dummyData(int numofItem){
        ArrayList<Transaction> transactions = new ArrayList<>();
        String[] dates = {"January 19,2024", "January 14,2024", "January 15,2024", "January 16,2024", "January 17,2024", "January 18,2024"};
        for(int i = numofItem; i < 8; i++)
        {
            int id = 1, accountNumber = 1001;
            double amount = 200, balance = 1200;
            double updatedAmount = amount * i;
            double updatedBalance = (balance + updatedAmount);

        transactions.add(new Transaction(id+i,accountNumber+i,dates[i%6],amount*i,updatedBalance, TransactionType.DEPOSITE));
}
        return transactions;
    }
}
