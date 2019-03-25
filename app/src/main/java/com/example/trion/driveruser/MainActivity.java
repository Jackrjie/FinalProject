package com.example.trion.driveruser;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends ActivityGroup implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Bundle bundle = new Bundle();
    private LinearLayout layContainer,layHome,layOrder,layUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layContainer = (LinearLayout)findViewById(R.id.layContainer);
        layHome = (LinearLayout)findViewById(R.id.layHome);
        layOrder = (LinearLayout)findViewById(R.id.layOrder);
        layUser = (LinearLayout)findViewById(R.id.layUser);

        layHome.setOnClickListener(this);
        layOrder.setOnClickListener(this);
        layUser.setOnClickListener(this);
        bundle.putString("tag",TAG);
        changeContainerView(layHome);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.layHome || v.getId()==R.id.layOrder || v.getId()==R.id.layUser){
            changeContainerView(v);
        }
    }

    private void changeContainerView(View view) {
        layHome.setSelected(false);
        layOrder.setSelected(false);
        layUser.setSelected(false);
        view.setSelected(true);
        switch (view.getId()){
            case R.id.layHome:
                toActivity("home",HomeActivity.class);
                break;
            case R.id.layOrder:
                toActivity("order",OrderActivity.class);
                break;
            case R.id.layUser:
                toActivity("user",UserActivity.class);
                break;
        }
    }

    private void toActivity(String label, Class<?> cls) {
        Intent intent = new Intent(this, cls).putExtras(bundle);
        layContainer.removeAllViews();
        View v = getLocalActivityManager().startActivity(label, intent).getDecorView();
        v.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layContainer.addView(v);
    }
}