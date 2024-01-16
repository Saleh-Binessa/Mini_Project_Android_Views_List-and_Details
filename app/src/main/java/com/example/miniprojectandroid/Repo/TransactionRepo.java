package com.example.miniprojectandroid.Repo;

import com.example.miniprojectandroid.transaction_classes.Transaction;
import com.example.miniprojectandroid.transaction_classes.TransactionType;

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
        transactions.add(new Transaction(1,0001,"January 15,2024",100.00,1250.00, TransactionType.DEPOSITE));
        return transactions;
    }
}
