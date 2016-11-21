package com.lab3.lab3;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by root on 11.12.16.
 */





public class Main1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
    }

    public void createSecond(View v) {
        Intent intent = new Intent(this, Two.class);
        startActivity(intent);
    }

    public void createThird(View v) {
        Intent intent = new Intent(this, Three.class);
        startActivity(intent);
    }

    public void createFourth(View v) {
        Intent intent = new Intent(this, Four.class);
        startActivity(intent);
    }

    public void close(View v) {
        this.finish();
    }
}