package com.example.madeinindiafurniture;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;

import java.util.HashMap;
import java.util.Map;

public class MyCart extends AppCompatActivity {
    Button place_order;
    ImageView back_btn;
    TextView remove_item;
    ImageView drop_down_qty;
    ImageView drop_up_qty;
    TextView quantity;
    String quantity_str;
    int qty = 1;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        place_order = findViewById(R.id.place_order_id);
        remove_item = findViewById(R.id.remove_id);
        builder = new AlertDialog.Builder(this);
        remove_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                builder.setTitle("Remove from Cart")
                        .setMessage("Are you sure you wish to remove  this product from cart? ");
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(getApplicationContext(),"Product item removed from cart",Toast.LENGTH_SHORT).show();


                            }});
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("Remove from Cart");
                alertDialog.show();

            }
        });
        back_btn = findViewById(R.id.back_btn_cart);
        drop_down_qty = findViewById(R.id.decrease_qty_id);
        drop_up_qty = findViewById(R.id.increase_qty_id);
        quantity = findViewById(R.id.qty);

        drop_up_qty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty = Integer.parseInt(quantity.getText().toString().trim());
                quantity_str = new String(" ");
                quantity_str = String.valueOf((qty+1));
                quantity.setText((quantity_str));
            }
        });
        drop_down_qty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty = Integer.parseInt(quantity.getText().toString().trim());
                if (qty == 0){
                    quantity_str = String.valueOf((qty));
                    quantity.setText((quantity_str));
                }
                else {
                    quantity_str = new String(" ");
                    quantity_str = String.valueOf((qty-1));
                    quantity.setText((quantity_str));
                }

            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),BuyNow.class);
                startActivity(intent);
            }
        });
    }
}
