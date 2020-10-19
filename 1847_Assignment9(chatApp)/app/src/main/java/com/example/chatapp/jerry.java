package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class jerry extends AppCompatActivity {

    TextInputEditText jerryChat;

    public static final String USER = "JERRY";

    public RecyclerView recyclerView;
    public RecyclerAdaptor recyclerAdaptor;

    final ArrayList<Message> texts = Message_store.getInstance().chats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jerry_activity);

        jerryChat=(TextInputEditText)findViewById(R.id.jerry_chat);
        jerryChat.setHint("Jerry");

        recyclerAdaptor = new RecyclerAdaptor(texts,USER);

        recyclerView = (RecyclerView)findViewById(R.id.recycleViewJerry);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdaptor);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.change:
                Intent i = new Intent(this,tom.class);
                startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    public void send(View view) {
        if(jerryChat.getText().toString().length()!=0) {
            String msg = jerryChat.getText().toString();
            jerryChat.setText("");
            jerryChat.setHint("Type message");
            texts.add(new Message(msg,"JERRY"));
            recyclerAdaptor = new RecyclerAdaptor(texts,USER);
            recyclerView.setAdapter(recyclerAdaptor);

        }

    }
}
