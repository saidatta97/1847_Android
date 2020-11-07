package com.example.webclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    Button btnTotalSal;
    public static TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTotalSal= (Button) findViewById(R.id.TotalSalary);
        data = (TextView) findViewById(R.id.text);
        async sortData = new async();
        sortData.execute();
        btnTotalSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),async.totalSalary.toString(),Toast.LENGTH_LONG).show();

            }
        });

    }
}

