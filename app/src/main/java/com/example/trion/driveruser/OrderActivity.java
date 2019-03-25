package com.example.trion.driveruser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.trion.driveruser.adapter.OrderRcAdapter;

public class OrderActivity extends AppCompatActivity {
    String[] orderID = {"001","002","003","004","005","006"};
    String[] oStatus = {"T","T","S","S","T","S"};
    String[] oDate = {"13/12","14/12","14/12","16/12","17/12","17/12"};
    String[] sAdd = {"台南","高雄","高雄","台南","屏東","新竹"};
    String[] eAdd = {"高雄","台南","台南","高雄","新竹","桃園"};
    String[] carNum = {"AE86","AE87","AE88","AE88","AE89","AE90"};
    String[] quantity = {"1","2","3","4","5","6"};
    String[] model = {"Honda","Toyota","Suzumi","Kia","BMW","Mitsubisi"};
    RecyclerView recyclerOrder;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // REFERENCE RECYCLE VIEWS
        recyclerOrder = (RecyclerView)findViewById(R.id.recyclerOrder);
        recyclerOrder.setHasFixedSize(true);

        // SET PROPERTIES
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerOrder.setLayoutManager(layoutManager);

        // ADAPTER
        OrderRcAdapter adapter = new OrderRcAdapter(this,orderID,oStatus,oDate,sAdd,
                eAdd,carNum,quantity,model);
        recyclerOrder.setAdapter(adapter);
    }
}
