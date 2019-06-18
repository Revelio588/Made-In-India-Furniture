package com.example.madeinindiafurniture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.madeinindiafurniture.account_details.AccountActivity;
import com.example.madeinindiafurniture.home_pcg.HomeActivity;

public class BuyNow extends AppCompatActivity {

    TextView username;
    TextView address;
    TextView phoneno;
    Button edit;
    Button continue_pay;
    ImageView gotoHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_now);
//        Intent i = getIntent();
//        String user = i.getStringExtra("username");
//        String phone = i.getStringExtra("contactno");
//        String adrline1 = i.getStringExtra("addrline1");
//        String adrlin2 = i.getStringExtra("addrline2");
//        String pincode_adr = i.getStringExtra("pincode");
//        String city_adr = i.getStringExtra("city");
//        String state_adr = i.getStringExtra("state");

        username = findViewById(R.id.username_buynow_id);
        address = findViewById(R.id.addrlines_id);
        phoneno = findViewById(R.id.pno_id);
        edit = findViewById(R.id.edit_goto_acc);
        continue_pay = findViewById(R.id.goto_pay);
        gotoHome = findViewById(R.id.gotohome_id);

//        username.setText(user);
//        address.setText(adrline1+"\n"+adrlin2+"\n"+pincode_adr+"\n"+city_adr+", "+state_adr);
//        phoneno.setText(phone);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
                startActivity(intent);
            }
        });
        continue_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(),Payment.class);
                startActivity(intent);
            }
        });
        gotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
