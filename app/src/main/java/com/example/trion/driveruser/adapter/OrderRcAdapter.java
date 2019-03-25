package com.example.trion.driveruser.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trion.driveruser.OrderDetailsActivity;
import com.example.trion.driveruser.R;

/**
 * Created by trion on 12/16/2017.
 */

public class OrderRcAdapter extends RecyclerView.Adapter<OrderRcAdapter.OrderListHolder>{

    //FIELDS TO STORE IN VALUES
    Context context;
    String[] orderID;
    String[] status;
    String[] date;
    String[] sAdd;
    String[] eAdd;
    String[] carNum;
    String[] quantity;
    String[] model;

    public OrderRcAdapter(Context context, String[] orderID, String[] status, String[] date,
                          String[] sAdd, String[] eAdd, String[] carNum,
                          String[] quantity, String[] model){
        // ASSIGN ITEM
        this.context = context;
        this.orderID = orderID;
        this.status = status;
        this.date = date;
        this.sAdd = sAdd;
        this.eAdd = eAdd;
        this.carNum = carNum;
        this.quantity = quantity;
        this.model = model;
    }

    @Override
    public OrderListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // INFLATE A VIEW FROM XML
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.order_layout,null,false);
        view.setLayoutParams(new RecyclerView.
                LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT));

        // HOLDER
        OrderListHolder holder = new OrderListHolder(view);

        return holder;
    }

    // DATA IS BEING BOUND TO VIEWS
    @Override
    public void onBindViewHolder(OrderListHolder myHolder, int position) {

        // BIND DATA
        myHolder.tvO_orderID.setText(orderID[position]);
        myHolder.tvO_status.setText(status[position]);
        myHolder.tvO_date.setText(date[position]);
        myHolder.tvO_sAdd.setText(sAdd[position]);
        myHolder.tvO_eAdd.setText(eAdd[position]);


        // WHEN ITEM IS CLICKED
        myHolder.setOrderItemClickListener(new OrderItemClickListener() {
            @Override
            public void onOrderItemClick(View view, int position) {

                // INTENT OBJ
                Intent it = new Intent(context, OrderDetailsActivity.class);

                // ADD DATA TO OUR INTENT
                it.putExtra("orderID",orderID[position]);
                it.putExtra("status",status[position]);
                it.putExtra("date",date[position]);
                it.putExtra("sAdd",sAdd[position]);
                it.putExtra("eAdd",eAdd[position]);
                it.putExtra("carNum",carNum[position]);
                it.putExtra("quantity",quantity[position]);
                it.putExtra("model",model[position]);

                // START DETAILS ACTIVITY
                context.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderID.length;
    }

    public class OrderListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // OUR VIEWS
        TextView tvO_orderID,tvO_status,tvO_date,tvO_sAdd,tvO_eAdd;

        private OrderItemClickListener orderItemClickListener;
        // OUR CONSTRUCTOR
        public OrderListHolder(View itemView) {
            super(itemView);

            tvO_orderID = (TextView)itemView.findViewById(R.id.tvO_orderID);
            tvO_status = (TextView)itemView.findViewById(R.id.tvO_status);
            tvO_date = (TextView)itemView.findViewById(R.id.tvO_date);
            tvO_sAdd = (TextView)itemView.findViewById(R.id.tvO_sAdd);
            tvO_eAdd = (TextView)itemView.findViewById(R.id.tvO_eAdd);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            this.orderItemClickListener.onOrderItemClick(view,getLayoutPosition());
        }

        public void setOrderItemClickListener(OrderItemClickListener clc)
        {
            this.orderItemClickListener = clc;
        }
    }
}
