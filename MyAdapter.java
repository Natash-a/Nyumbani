package com.example.nyumbani;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList title_id, desc_id, date_id;

    public MyAdapter(Context context, ArrayList title_id, ArrayList desc_id, ArrayList date_id) {
        this.context = context;
        this.title_id = title_id;
        this.desc_id = desc_id;
        this.date_id = date_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title_id.setText(String.valueOf(title_id.get(position)));
        holder.desc_id.setText(String.valueOf(desc_id.get(position)));
        holder.date_id.setText(String.valueOf(date_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return title_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title_id,desc_id,date_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title_id=itemView.findViewById(R.id.texttitle);
            desc_id=itemView.findViewById(R.id.textdesc);
            date_id=itemView.findViewById(R.id.textdate);
        }
    }
}
