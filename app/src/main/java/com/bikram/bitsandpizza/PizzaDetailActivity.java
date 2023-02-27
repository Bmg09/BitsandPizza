package com.bikram.bitsandpizza;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class PizzaDetailActivity extends AppCompatActivity {
    public static final String EXTRA_PIZZA_ID = "com.bikram.bitsandpizza.EXTRA_PIZZA_ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        int number = intent.getIntExtra(EXTRA_PIZZA_ID,0);
        Pizza[] pizza = Pizza.pizzas;
        TextView textView = findViewById(R.id.caption);
        textView.setText(pizza[number].getName());
        ImageView imageView = findViewById(R.id.imageid);
        imageView.setImageResource(pizza[number].getImageResourceId());
    }
}