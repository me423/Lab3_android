package com.lab3.lab3;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;


/**
 * Created by root on 11.12.16.
 */


public class Android extends Activity {
    private Button bgButton;

    public RelativeLayout relativeLayout;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android);

        bgButton = (Button) findViewById(R.id.button19);
        //bgButton.setOnClickListener(this);
        context = Android.this;
        relativeLayout = (RelativeLayout)findViewById(R.id.android);


    }


    public void changeColor(View view) {
        final CharSequence[] items = {getText(R.string.red) ,

                getText(R.string.yellow),getText(R.string.green)



        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.message);

        builder.setItems(items, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int item) {

                switch (item) {

                    case 0: { relativeLayout.setBackgroundResource(R.color.redColor);

                        Toast.makeText(context, R.string.red, Toast.LENGTH_LONG).show();



                        break;}

                    case 1:

                    {relativeLayout.setBackgroundResource(R.color.yellowColor);

                        Toast.makeText(context, R.string.yellow,

                                Toast.LENGTH_LONG).show();



                        break;}

                    case 2:

                    {relativeLayout.setBackgroundResource(R.color.greenColor);

                        Toast.makeText(context, R.string.green, Toast.LENGTH_LONG).show();



                        break;}

                }

            }

        });

        AlertDialog alert = builder.create();

        alert.show();

    }

}
