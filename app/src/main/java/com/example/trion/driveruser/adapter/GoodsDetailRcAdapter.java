package com.example.trion.driveruser.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trion.driveruser.MapsActivity;
import com.example.trion.driveruser.R;

/**
 * Created by trion on 12/18/2017.
 */

public class GoodsDetailRcAdapter extends RecyclerView.Adapter<GoodsDetailRcAdapter.GDHolder>{

    // Fields to store in values
    Context context;
    String[] gdID;
    String[] gdNum;
    String[] gdAdd;

    public GoodsDetailRcAdapter(Context context, String[] gdID, String[] gdNum, String[] gdAdd){

        // Assign item
        this.context = context;
        this.gdID = gdID;
        this.gdNum = gdNum;
        this.gdAdd = gdAdd;
    }

    @Override
    public GoodsDetailRcAdapter.GDHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Inflate a view from XML
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.goods_details_layout,null,false);
        view.setLayoutParams(new RecyclerView.
                LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT));

        // Holder
        GDHolder holder = new GDHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(GoodsDetailRcAdapter.GDHolder holder, int position) {

        // Bind data
        holder.myID.setText(gdID[position]);
        holder.myNum.setText(gdNum[position]);
        holder.myAdd.setText(gdAdd[position]);

        // When item is clicked
        holder.setGdItemClickListener(new GDItemClickListener() {
            @Override
            public void onGDItemClick(View view, int position) {

                // Intent object
                Intent it = new Intent(context, MapsActivity.class);

                // Add data to our intent
                it.putExtra("gdID",gdID[position]);
                it.putExtra("gdNum",gdNum[position]);
                it.putExtra("gdAdd",gdAdd[position]);

                // Start Map Activity
                context.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gdID.length;
    }

    public class GDHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        // Our Views
        TextView myID,myNum,myAdd;

        private GDItemClickListener gdItemClickListener;

        public GDHolder(View itemView) {
            super(itemView);

            myID = (TextView)itemView.findViewById(R.id.tv_gd_ID);
            myNum = (TextView)itemView.findViewById(R.id.tv_gd_Num);
            myAdd = (TextView)itemView.findViewById(R.id.tv_gd_sAdd);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            this.gdItemClickListener.onGDItemClick(view,getLayoutPosition());
        }

        public void setGdItemClickListener(GDItemClickListener gd){
            this.gdItemClickListener = gd;
        }
    }

}

