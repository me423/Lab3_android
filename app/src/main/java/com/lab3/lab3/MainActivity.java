package com.lab3.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private String imageUrl;
    private ImageView imageView;
    private Switch switch1;
    private SeekBar seekbar;
    private Bitmap bitmap;
    private SeekBar seekBar2;

    private int startHeight, startWidth;
    private TextView scaleLabelTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        imageUrl = getResources().getString(R.string.url);
        imageView = (ImageView) findViewById(R.id.image_view);
        seekBar2 = (SeekBar) findViewById(R.id.seek_bar_image_resize);
        scaleLabelTextView = (TextView) findViewById(R.id.change_scale_label);
        switch1 = (Switch) findViewById(R.id.switch1);
        seekbar = (SeekBar) findViewById(R.id.seekBar2);
        loadImage();
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switch1.isChecked()) {
                    imageView.setVisibility(View.VISIBLE);
                }
                else {
                    imageView.setVisibility(View.INVISIBLE);
                }
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub

                imageView.setAlpha(progress);

            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double scale = (double) (progress + 10) / (seekBar.getMax() + 10);
                int h = (int) (startHeight * scale);
                int w = (int) (startWidth * scale);
                Bitmap resized = Bitmap.createScaledBitmap(bitmap, w, h, true);
                imageView.setImageBitmap(resized);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        startWidth =imageView.getWidth();
        startHeight=imageView.getHeight();
    }

    public void openInBrowser(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(imageUrl));
        startActivity(i);
    }

    private void loadImage() {
        Lab3_2 imgLoader = new Lab3_2();
        imgLoader.execute(imageUrl);
    }

    class Lab3_2 extends AsyncTask<String, Void, Bitmap> {
        private ProgressDialog progressDialog;

        @Override
        protected Bitmap doInBackground(String... params) {
            String imageUrl = params[0];
            try {
                URL url = new URL(imageUrl);
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                return bmp;
            } catch (IOException e) {
                Log.e("ERROR", "loadImage: ", e);
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(MainActivity.this, getResources().getString(R.string.wait),
                    getResources().getString(R.string.loading), true);

        }

        @Override
        protected void onPostExecute(Bitmap bmp) {
            imageView.setImageBitmap(bmp);
            bitmap = bmp;
            progressDialog.dismiss();
            startHeight = imageView.getHeight();
            startWidth = imageView.getWidth();
            seekBar2.setVisibility(View.VISIBLE);
            scaleLabelTextView.setVisibility(View.VISIBLE);
        }

    }
}