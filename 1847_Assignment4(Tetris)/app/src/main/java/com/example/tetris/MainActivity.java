package com.example.tetris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button red= (Button) findViewById(R.id.redbtn);
        Button blue= (Button) findViewById(R.id.bluebtn);
        Button green= (Button) findViewById(R.id.btngreen);
        Button yellow= (Button) findViewById(R.id.btnyellow);



        final LinearLayout page= (LinearLayout) findViewById(R.id.pagecontainer);
        final LayoutInflater inflater= (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View redview= getLayoutInflater().inflate(R.layout.redview,null);
                page.addView(redview);
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View blueview= getLayoutInflater().inflate(R.layout.blueview,null);
                page.addView(blueview);
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View greenview= getLayoutInflater().inflate(R.layout.greenview,null);
                page.addView(greenview);
            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View yellowview= getLayoutInflater().inflate(R.layout.yellowview,null);
                page.addView(yellowview);
            }
        });



    }


}