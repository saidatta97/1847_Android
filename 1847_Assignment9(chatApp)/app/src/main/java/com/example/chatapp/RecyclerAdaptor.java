package com.example.chatapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.MyViewHodler>{

    ArrayList<Message> texts;
    String user;
    int count = 0;

    public RecyclerAdaptor(ArrayList<Message> texts, String user) {
        this.texts=texts;
        this.user = user;
    }

    @Override
    public int getItemViewType(int position) {

        count=position;
        if (texts.get(count).sentBy == user) {
            return 0;
        }
        else
            return 1;
    }

    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =null;
        if(viewType==0){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            view = layoutInflater.inflate(R.layout.send_msg,parent,false);
        }
        else{
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            view = layoutInflater.inflate(R.layout.receive_msg,parent,false);
        }
        MyViewHodler viewHodler = new MyViewHodler(view);

        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodler holder, int position) {

        holder.txt.setText(texts.get(position).message);
    }



    @Override
    public int getItemCount() {
        return texts.size();
    }

    class MyViewHodler extends RecyclerView.ViewHolder{
        TextView txt;

        public MyViewHodler(@NonNull View itemView) {
            super(itemView);
            if(texts.get(count).sentBy==user){
                txt = itemView.findViewById(R.id.msgsend);
            }
            else{
                txt = itemView.findViewById(R.id.msgrecieve);
            }
        }
    }
}
