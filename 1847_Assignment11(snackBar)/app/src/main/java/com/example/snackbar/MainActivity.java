package com.example.snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Model> list;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        addlist();
        myAdapter=new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }

    private void addlist() {
        list=new ArrayList<>();
        list.add(new Model("C",R.drawable.c));
        list.add(new Model("C++",R.drawable.cplus));
        list.add(new Model("PHP",R.drawable.php));
        list.add(new Model("C#",R.drawable.csharp));
        list.add(new Model("C",R.drawable.c));
        list.add(new Model("C++",R.drawable.cplus));
        list.add(new Model("HTML",R.drawable.html));
        list.add(new Model("CSS",R.drawable.css));
        list.add(new Model("PHP",R.drawable.php));
        list.add(new Model("Python",R.drawable.python));

        list.add(new Model("C",R.drawable.c));
        list.add(new Model("C++",R.drawable.cplus));
        list.add(new Model("PHP",R.drawable.php));
        list.add(new Model("C#",R.drawable.csharp));
        list.add(new Model("C",R.drawable.c));
        list.add(new Model("C++",R.drawable.cplus));
        list.add(new Model("HTML",R.drawable.html));
        list.add(new Model("CSS",R.drawable.css));
        list.add(new Model("PHP",R.drawable.php));
        list.add(new Model("Python",R.drawable.python));





    }

}