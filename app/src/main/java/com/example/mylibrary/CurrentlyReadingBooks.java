package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class CurrentlyReadingBooks extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BookRecViewAdpter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading_books);
        recyclerView = findViewById(R.id.curRecView);
        adapter = new BookRecViewAdpter(this,"cR");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        adapter.setBooks(Utils.getInstance(this).getCurrentlyReadingBooks());

        // Test für Github
    }
}