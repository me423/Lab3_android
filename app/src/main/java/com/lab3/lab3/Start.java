package com.lab3.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;

import android.view.View;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lab31(View v) {
        Intent intent = new Intent(this, Main1.class);
        startActivity(intent);
    }
    public void lab32(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void lab33(View v) {
        Intent intent = new Intent(this, Main3.class);
        startActivity(intent);
    }
    public void lab34(View v) {
        Intent intent = new Intent(this, Main4.class);
        startActivity(intent);
    }
}
