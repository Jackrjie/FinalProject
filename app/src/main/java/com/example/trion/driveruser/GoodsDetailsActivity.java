package com.example.trion.driveruser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.trion.driveruser.adapter.GoodsDetailRcAdapter;

public class GoodsDetailsActivity extends AppCompatActivity {

    RecyclerView recyclerGDetails;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        initToolbar();


        initAdapter();


    }

    private void initAdapter() {

        Bundle bundle = getIntent().getExtras();
        String[] goodsID = bundle.getStringArray("goodsID");
        String[] goodsNum = bundle.getStringArray("goodsNum");
        String[] goodsAdd = bundle.getStringArray("goodsAdd");

        // Reference recycle views
        recyclerGDetails = (RecyclerView)findViewById(R.id.recyclerGDetails);
        recyclerGDetails.setHasFixedSize(true);

        // Set properties
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerGDetails.setLayoutManager(layoutManager);

        // Adapter
        GoodsDetailRcAdapter adapter = new GoodsDetailRcAdapter(this,goodsID,goodsNum,goodsAdd);
        recyclerGDetails.setAdapter(adapter);
    }

    private void initToolbar() {
        // INITIAL TOOLBAR
        Toolbar tb = (Toolbar)findViewById(R.id.tb_goods);
        setSupportActionBar(tb);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
