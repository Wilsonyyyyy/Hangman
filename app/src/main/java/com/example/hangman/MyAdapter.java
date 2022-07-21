package com.example.hangman;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<User> list;


    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = list.get(position);
        holder.un.setText(user.getUn());
        holder.highscore.setText(user.getHighscore());
        holder.date.setText(user.getDate());
        // holder.lastname.setText(user.getLastname());
        // holder.age.setText(user.getAge());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView un, highscore,date,firstName, lastName, age;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            un = itemView.findViewById(R.id.tvusername);
            highscore = itemView.findViewById(R.id.tvhighscore);
            date = itemView.findViewById(R.id.tvdate);
            // = itemView.findViewById(R.id.tvlastName);
            // age = itemView.findViewById(R.id.tvage);

        }
    }

}
