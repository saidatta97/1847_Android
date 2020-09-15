package com.example.multiple_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.multiple_activity.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent= getIntent();
        String message= intent.getStringExtra(activity3.EXTRA_MESSAGE3);

        EditText name1= findViewById(R.id.name1);
        name1.setText(message);
    }


    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, activity2.class);
        EditText editText = findViewById(R.id.name1);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}