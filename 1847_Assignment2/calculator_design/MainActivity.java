package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    TextView hello;
    EditText name;
    Button btn_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello=(TextView) findViewById(R.id.hello);
        name=(EditText) findViewById(R.id.name);
        btn_name=(Button) findViewById(R.id.btn_name);
        btn_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=name.getText().toString();
                hello.setText(" welcome "+username+", Use our Calculator");
            }
        });
    }
}