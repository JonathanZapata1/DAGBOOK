package com.example.dagbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class AdapterProspect extends RecyclerView.Adapter<AdapterProspect.MyViewHolder> {
    Context context;
    ArrayList<Prospecto> list;

    public AdapterProspect(Context context, ArrayList<Prospecto> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Prospecto pros= list.get(position);
        holder.name.setText(pros.getName());
        holder.phone.setText(pros.getPhone());
        holder.address.setText(pros.getAddress());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,phone,address;
        public  MyViewHolder(@NonNull View itemView){
            super(itemView);
            name= itemView.findViewById(R.id.tvname);
            phone=itemView.findViewById(R.id.tvphone);
            address=itemView.findViewById(R.id.tvaddress);
        }
    }
}
