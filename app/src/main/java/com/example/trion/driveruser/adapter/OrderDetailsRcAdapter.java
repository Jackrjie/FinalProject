package com.example.trion.driveruser.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trion.driveruser.R;

/**
 * Created by trion on 12/17/2017.
 */

public class OrderDetailsRcAdapter extends RecyclerView.Adapter<OrderDetailsRcAdapter.GoodsHolder> {

    // FIELDS TO STORE IN VALUES
    Context context;
    String[] goodsID;
    String[] goodsNum;

    public OrderDetailsRcAdapter(Context context, String[] goodsID, String[] goodsNum){

        // ASSIGN ITEM
        this.context = context;
        this.goodsID = goodsID;
        this.goodsNum = goodsNum;
    }

    @Override
    public GoodsHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // INFLATE A VIEW FROM XML
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.goods_layout,null,false);
        view.setLayoutParams(new RecyclerView.
                LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT));

        // HOLDER
        GoodsHolder holder = new GoodsHolder(view);

        return holder;
    }

    // DATA IS BEING BOUND TO VIEWS
    @Override
    public void onBindViewHolder(GoodsHolder holder, int position) {

        // BIND DATA
        holder.tv_goodsID.setText(goodsID[position]);
        holder.tv_goodsNum.setText(goodsNum[position]);
    }


    @Override
    public int getItemCount() {
        return goodsID.length;
    }

    public class GoodsHolder extends RecyclerView.ViewHolder{
        // OUR VIEWS
        TextView tv_goodsID,tv_goodsNum;

        // OUR CONSTRUCTOR
        public GoodsHolder(View itemView) {
            super(itemView);

            tv_goodsID = (TextView)itemView.findViewById(R.id.tv_goodsID);
            tv_goodsNum = (TextView)itemView.findViewById(R.id.tv_goodsNum);
        }
    }
}
