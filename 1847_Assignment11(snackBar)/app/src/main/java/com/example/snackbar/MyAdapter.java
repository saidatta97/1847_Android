package com.example.snackbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Model>list;
    View view;
    Model temp;
    public MyAdapter(Context mContext,ArrayList<Model> list)
    {
        this.mContext=mContext;
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(mContext).inflate(R.layout.each_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.textView.setText(list.get(position).getName());
        holder.imageView.setImageResource(list.get(position).getImage());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext,"deleted",Toast.LENGTH_SHORT).show();
                temp=new Model(list.get(position).getName(),list.get(position).getImage());
                deleteItem(position,view);
            }
        });

    }

    private void deleteItem(final int position, View view)
    {
        list.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,list.size());
        Snackbar.make(view,"UNDO  "+temp.getName(),Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add(position,temp);
                notifyItemInserted(position);
                notifyItemRangeChanged(position,list.size());

            }
        }).setActionTextColor(mContext.getResources().getColor(android.R.color.holo_blue_dark)).show();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView,delete;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            delete=itemView.findViewById(R.id.delete);
            textView=itemView.findViewById(R.id.textView);
        }
    }
}
