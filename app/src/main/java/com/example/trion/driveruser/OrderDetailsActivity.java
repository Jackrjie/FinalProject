package com.example.trion.driveruser;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.trion.driveruser.adapter.OrderDetailsRcAdapter;


public class OrderDetailsActivity extends AppCompatActivity implements View.OnClickListener{

    // VIEWS
    TextView tvD_orderID,tvD_carNum,tvD_status,tvD_date,tvD_sAdd,tvD_eAdd,tvD_quantity,tvD_model;
    String[] goodsID = {"001","002","003","004","005","006"};
    String[] goodsNum = {"A01","A02","A03","A04","A05","A06"};
    String[] goodsSAdd = {"台南","台南","高雄","高雄","屏東","新竹"};
    Bundle bundle;

    RecyclerView recyclerGoods;
    LinearLayoutManager layoutManager;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        Toolbar tb = (Toolbar)findViewById(R.id.tb_orderDetails);
        setSupportActionBar(tb);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // REFERENCE RECYCLE VIEWS
        findViewById(R.id.tv_more).setOnClickListener(this);
        syncData();
        initAdapter();


    }

    private void initAdapter() {
        recyclerGoods = (RecyclerView)findViewById(R.id.recyclerGoods);
        recyclerGoods.setHasFixedSize(true);

        // SET PROPERTIES
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerGoods.setLayoutManager(layoutManager);

        // ADAPTER
        OrderDetailsRcAdapter adapter = new OrderDetailsRcAdapter(this,goodsID,goodsNum);
        recyclerGoods.setAdapter(adapter);
    }

    private void syncData() {
        // REFERENCE VIEW FROM XML
        tvD_orderID = (TextView)findViewById(R.id.tvD_orderID);
        tvD_carNum = (TextView)findViewById(R.id.tvD_carNum);
        tvD_status = (TextView)findViewById(R.id.tvD_status);
        tvD_date = (TextView)findViewById(R.id.tvD_date);
        tvD_sAdd = (TextView)findViewById(R.id.tvD_sAdd);
        tvD_eAdd = (TextView)findViewById(R.id.tvD_eAdd);
        tvD_quantity = (TextView)findViewById(R.id.tvD_quantity);
        tvD_model = (TextView)findViewById(R.id.tvD_model);

        // RECEIVE OUR DATA FROM ORDER LIST
        Intent it = getIntent();
        final String orderID = it.getStringExtra("orderID");
        final String status = it.getStringExtra("status");
        final String date = it.getStringExtra("date");
        final String sAdd = it.getStringExtra("sAdd");
        final String eAdd = it.getStringExtra("eAdd");
        final String carNum = it.getStringExtra("carNum");
        final String quantity = it.getStringExtra("quantity");
        final String model = it.getStringExtra("model");

        // ASSIGN DATA TO THOSE VIEWS
        tvD_orderID.setText(orderID);
        tvD_status.setText(status);
        tvD_date.setText(date);
        tvD_sAdd.setText(sAdd);
        tvD_eAdd.setText(eAdd);
        tvD_carNum.setText(carNum);
        tvD_quantity.setText(quantity);
        tvD_model.setText(model);
    }

    @Override
    public void onClick(View view) {
        int id_num = view.getId();
        switch (id_num){
            case R.id.tv_more:
                Intent it = new Intent(this,GoodsDetailsActivity.class);
                bundle = new Bundle();
                bundle.putStringArray("goodsID",goodsID);
                bundle.putStringArray("goodsNum",goodsNum);
                bundle.putStringArray("goodsAdd",goodsSAdd);
                it.putExtras(bundle);
                startActivity(it);
                break;
        }
    }
}
