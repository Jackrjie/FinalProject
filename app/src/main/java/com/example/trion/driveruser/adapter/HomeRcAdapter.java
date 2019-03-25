package com.example.trion.driveruser.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trion.driveruser.R;
import com.example.trion.driveruser.bean.OrderCars;

import java.util.ArrayList;

/**
 * Created by trion on 12/15/2017.
 */

public class HomeRcAdapter extends RecyclerView.Adapter<HomeRcAdapter.MyViewHolder> {

    private ArrayList<OrderCars> arrayList = new ArrayList<>();
    Activity context;

    public HomeRcAdapter(ArrayList<OrderCars> arrayList)
    {
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,
                parent, false);
        MyViewHolder myh = new MyViewHolder(view);
        return myh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.c_orderID.setText(arrayList.get(position).getMyOrderID());
        holder.c_status.setText(arrayList.get(position).getMyStatus());
        holder.c_date.setText(arrayList.get(position).getMyDate());
        holder.c_sAdd.setText(arrayList.get(position).getMySAdd());
        holder.c_eAdd.setText(arrayList.get(position).getMyEAdd());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView c_orderID,c_status,c_date,c_sAdd,c_eAdd;

        public MyViewHolder(View itemView) {
            super(itemView);
            c_orderID = (TextView)itemView.findViewById(R.id.tvH_orderID);
            c_status = (TextView)itemView.findViewById(R.id.tvH_status);
            c_date = (TextView)itemView.findViewById(R.id.tvH_date);
            c_sAdd = (TextView)itemView.findViewById(R.id.tvH_sAdd);
            c_eAdd = (TextView)itemView.findViewById(R.id.tvH_eAdd);
        }
    }

    public void setFilter(ArrayList<OrderCars> newList)
    {
        arrayList = new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }
}
