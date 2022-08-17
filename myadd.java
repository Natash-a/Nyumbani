package com.example.nyumbani;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadd extends RecyclerView.Adapter<myadd.MyViewHolder> {
    private Context context;
    private ArrayList hnumber_id, status_id, date_id;

    public myadd(Context context, ArrayList hnumber_id, ArrayList status_id, ArrayList date_id) {
        this.context = context;
        this.hnumber_id = hnumber_id;
        this.status_id = status_id;
        this.date_id = date_id;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vi = LayoutInflater.from(context).inflate(R.layout.gb, parent, false);

        return new MyViewHolder(vi);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.hnumber_id.setText(String.valueOf(hnumber_id.get(position)));
        holder.status_id.setText(String.valueOf(status_id.get(position)));
        holder.date_id.setText(String.valueOf(date_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return hnumber_id.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView hnumber_id, status_id, date_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            hnumber_id = itemView.findViewById(R.id.texthn);
            status_id = itemView.findViewById(R.id.textstat);
            date_id = itemView.findViewById(R.id.textdte);
        }
    }
}
