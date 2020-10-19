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
import java.util.List;

public class tom extends AppCompatActivity {

    TextInputEditText tomChat;

    public static final String USER = "TOM";

    public RecyclerView recyclerView;
    public RecyclerAdaptor recyclerAdaptor;

    final ArrayList<Message> texts = Message_store.getInstance().chats;

    List<String> message;
    List<String> sentBy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tom_activity);

        message = new ArrayList<>();
        sentBy = new ArrayList<>();
        recyclerAdaptor = new RecyclerAdaptor(texts,USER);
        recyclerView = (RecyclerView)findViewById(R.id.recycleViewTom);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdaptor);
        tomChat=(TextInputEditText)findViewById(R.id.tom_chat);
        tomChat.setHint("Tom");


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
                Intent i = new Intent(this,jerry.class);
                startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    public void send(View view) {
        if(tomChat.getText().toString().length()!=0) {
            String msg_tom = tomChat.getText().toString();
            texts.add(new Message(msg_tom,"TOM"));
            tomChat.setText("");
            tomChat.setHint("Type message");
            recyclerAdaptor = new RecyclerAdaptor(texts,USER);
            recyclerView.setAdapter(recyclerAdaptor);
        }
    }

}