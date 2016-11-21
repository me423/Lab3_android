package com.lab3.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 11.12.16.
 */





public class Four extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four);
    }

    public void changeBackground(View v) {
        Button btnTab1 = (Button) findViewById(R.id.button18);
        btnTab1.setBackgroundResource(R.drawable.bg);
    }
}
