package com.example.miniprojectandroid;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.example.miniprojectandroid.Adapter.TransactionAdapter;
import com.example.miniprojectandroid.Repo.TransactionRepo;
import com.example.miniprojectandroid.transaction_classes.Transaction;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView RecyclerViewTransaction;

    ArrayList<Transaction> transactionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            startActivity(intent);
        });

        transactionList = TransactionRepo.getInstance().generateDummyTransaction(1);


        TransactionAdapter transactionAdapter = new TransactionAdapter(transactionList);
        RecyclerViewTransaction = findViewById(R.id.RecyclerViewTransaction);
        RecyclerViewTransaction.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewTransaction.setAdapter(transactionAdapter);



}}