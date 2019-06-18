package com.example.madeinindiafurniture.account_details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.madeinindiafurniture.R;

public class AccountActivity extends AppCompatActivity {
    EditText userName;
    EditText phno;
    EditText adl1;
    EditText adl2;
    EditText pincode;
    ImageView edit_uname;
    ImageView edit_phno;
    EditText city;
    EditText state;
    Button save_addr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_account);
        userName = findViewById(R.id.username_id);
        phno = findViewById(R.id.phoneno_id);
        adl1 = findViewById(R.id.addr_line1);
        adl2 = findViewById(R.id.addr_line2);
        pincode = findViewById(R.id.pincode_id);
        city = findViewById(R.id.city_id);
        state = findViewById(R.id.state_id);
        edit_phno =findViewById(R.id.edit_phno_id);
        edit_uname = findViewById(R.id.edit_uname_id);
        save_addr = findViewById(R.id.save_addrs_id);
        edit_uname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Username Updated",Toast.LENGTH_LONG).show();
            }
        });
        edit_phno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Mobile Number Updated",Toast.LENGTH_LONG).show();
            }
        });
        save_addr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Address Saved",Toast.LENGTH_LONG).show();
            }
        });
        String uname = userName.getText().toString().trim();
        String pno = phno.getText().toString().trim();
        String adr1 = adl1.getText().toString().trim();
        String adr2 = adl2.getText().toString().trim();
        String pincode1 = pincode.getText().toString().trim();
        String city_town = city.getText().toString().trim();
        String state_adr = state.getText().toString().trim();

//        Intent i = new Intent(getApplicationContext(),BuyNow.class);
//        i.putExtra(uname,"username");
//        i.putExtra(pno,"contactno");
//        i.putExtra(adr1,"addrline1");
//        i.putExtra(adr2,"addrline2");
//        i.putExtra(pincode1,"pincode");
//        i.putExtra(city_town,"city");
//        i.putExtra(state_adr,"state");
    }
}
