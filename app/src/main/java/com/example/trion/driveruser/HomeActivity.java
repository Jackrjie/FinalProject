package com.example.trion.driveruser;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import com.example.trion.driveruser.adapter.HomeRcAdapter;
import com.example.trion.driveruser.bean.OrderCars;
import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private final static String TAG = "HomeActivity";
    String[] oID = {"001","002","003","004","005","006"};
    String[] oStatus = {"T","T","S","S","T","S"};
    String[] oDate = {"13/12","14/12","14/12","16/12","17/12","17/12"};
    String[] sAdd = {"台南","高雄","高雄","台南","屏東","新竹"};
    String[] eAdd = {"高雄","台南","台南","高雄","新竹","桃園"};
    Toolbar tb_home;
    RecyclerView recyclerView;
    HomeRcAdapter adapter;
    LinearLayoutManager layoutManager;
    ArrayList<OrderCars> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("司機端");
        tb_home = (Toolbar)findViewById(R.id.tb_home);
        setSupportActionBar(tb_home);
        initRecyclerView();

    }

    private void initRecyclerView()
    {
        recyclerView = (RecyclerView)findViewById(R.id.recyclerHome);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        int count = 0;

        for (String OID : oID)
        {
            arrayList.add(new OrderCars(OID,oStatus[count],oDate[count],sAdd[count],eAdd[count]));
            count++;
        }

        adapter = new HomeRcAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setQueryHint("輸入車單編號");
        searchView.setInputType(InputType.TYPE_CLASS_NUMBER);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<OrderCars> newList = new ArrayList<>();
        for(OrderCars orderCars : arrayList)
        {
            String searchOrderID = orderCars.getMyOrderID().toLowerCase();
            if(searchOrderID.contains(newText))
                newList.add(orderCars);
        }

        adapter.setFilter(newList);
        return true;
    }
}
