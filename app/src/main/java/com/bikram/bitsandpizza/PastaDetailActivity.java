package com.bikram.bitsandpizza;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PastaDetailActivity extends AppCompatActivity {
    public static final String EXTRA_PASTA_ID = "com.bikram.bitsandpizza.EXTRA_PASTA_ID";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        int id = intent.getIntExtra(EXTRA_PASTA_ID,0);
        TextView textView = findViewById(R.id.caption);
        Pasta[] pasta = Pasta.pastas;
        textView.setText(pasta[id].getCaption());
        ImageView imageView = findViewById(R.id.imageid);
        imageView.setImageResource(pasta[id].getImageIds());
    }
}
