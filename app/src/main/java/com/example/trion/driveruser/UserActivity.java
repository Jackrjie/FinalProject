package com.example.trion.driveruser;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.trion.driveruser.util.RoundImage;

public class UserActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView img_yui;
    RoundImage roundImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
       img_yui = (ImageView)findViewById(R.id.yui);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.yui);
        roundImage = new RoundImage(bitmap);
        img_yui.setImageDrawable(roundImage);
        findViewById(R.id.btnHistory).setOnClickListener(this);
        findViewById(R.id.btnManagement).setOnClickListener(this);
        findViewById(R.id.btnLogout).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btnHistory:
                Toast.makeText(this,"寄送記錄",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnManagement:
                Toast.makeText(this,"車輛管理",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnLogout:
                Toast.makeText(this,"登出",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
