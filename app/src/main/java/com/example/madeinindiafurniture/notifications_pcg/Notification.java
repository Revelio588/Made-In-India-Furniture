package com.example.madeinindiafurniture.notifications_pcg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.madeinindiafurniture.MyCart;
import com.example.madeinindiafurniture.home_pcg.HomeActivity;
import com.example.madeinindiafurniture.R;

import java.util.ArrayList;
import java.util.List;

public class Notification extends AppCompatActivity {
    String Title1;
    String ContentN;
    String DateN;
    List list_notification;
    ImageView backBtn;
    ImageView open_cart;

    public Notification() {
    }

    public Notification(String title, String contentN, String dateN) {
        Title1 = title;
        ContentN = contentN;
        DateN = dateN;
    }

    public String getTitle1() {
        return Title1;
    }

    public void setTitle(String title) {
        Title1 = title;
    }

    public String getContentN() {
        return ContentN;
    }

    public void setContentN(String contentN) {
        ContentN = contentN;
    }

    public String getDateN() {
        return DateN;
    }

    public void setDateN(String dateN) {
        DateN = dateN;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        open_cart = findViewById(R.id.cart_details);
        open_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(), MyCart.class);
                startActivity(intent);
            }
        });
        list_notification = new ArrayList<>();
        list_notification.add(new Notification("Important Scam Advisory","xyz","date"));
        list_notification.add(new Notification("Important Scam Advisory","xyz","date"));
        list_notification.add(new Notification("Important Scam Advisory","xyz","date"));


        RecyclerView rcv = findViewById(R.id.rec_viewN);
        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        RecViewAdapterNotifications adapter = new RecViewAdapterNotifications(this,list_notification);
       // rcv.setLayoutManager(new GridLayoutManager(this,2));
        rcv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rcv.setAdapter(adapter);
    }

}
