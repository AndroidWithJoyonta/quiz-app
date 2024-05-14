package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void category_one(View view) {
        Intent intent = new Intent(MainActivity.this,questionActivity1.class);
        startActivity(intent);
    }

    public void category_two(View view) {
        Intent intent = new Intent(MainActivity.this,questionActivity2.class);
        startActivity(intent);
    }

    public void category_three(View view) {
        Intent intent = new Intent(MainActivity.this,questionActivity3.class);
        startActivity(intent);
    }

    public void category_four(View view) {
        Intent intent = new Intent(MainActivity.this,questionActivity4.class);
        startActivity(intent);
    }


}