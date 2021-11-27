package com.example.ffood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterFood extends RecyclerView.Adapter<AdapterFood.MyViewHolder> {

    Context context;

    private List<foods> list;

    public AdapterFood(Context context, ArrayList<foods> list) {
        this.context = context;
        this.list = list;
    }

    public AdapterFood(List<foods> list) {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(context).inflate(R.layout.item,parent, false);
        return  new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        foods food = list.get(position);
        holder.ten.setText(food.getTen());
        holder.giatien.setText(food.getGiatien());
        holder.chitiet.setText(food.getChitiet());

    }
    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView ten, giatien, chitiet;
        ImageView imghinh;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            ten = itemView.findViewById(R.id.tv_ten);
            giatien = itemView.findViewById(R.id.tv_giatien);
            chitiet = itemView.findViewById(R.id.tv_chitiet);
            imghinh = itemView.findViewById(R.id.img_hinh);

        }
    }

}
