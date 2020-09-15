package com.example.multiple_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class activity2 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE2 = "com.example.multiple_activity.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        Intent intent= getIntent();
        String message= intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        EditText name2= findViewById(R.id.name2);
        name2.setText(message);
    }

    public void sendMessage2(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, activity3.class);
        EditText editText = findViewById(R.id.name2);
        String message2 = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE2, message2);
        startActivity(intent);
    }


}