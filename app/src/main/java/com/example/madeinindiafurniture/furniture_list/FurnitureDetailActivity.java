package com.example.madeinindiafurniture.furniture_list;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.madeinindiafurniture.BuyNow;
import com.example.madeinindiafurniture.home_pcg.HomeActivity;
import com.example.madeinindiafurniture.MyCart;
import com.example.madeinindiafurniture.R;
import com.example.madeinindiafurniture.image_swiping.CustomSwipeAdapter;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class FurnitureDetailActivity extends AppCompatActivity {
    List<Furniture> listFurniture;
    ViewPager viewPager;
    SearchView searchView;
    TextView addtocart;
    TextView buynow;
    ImageView back_btn;
    LayoutInflater inflater;
    View popup;
    LinearLayout linearLayout;
    ImageView productDetails_btn;
    CircleIndicator circleIndicator;
    CustomSwipeAdapter customSwipeAdapter;
    ImageView cart_goto;
    ImageView add_towishlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture_detail_acitvity);
        viewPager = findViewById(R.id.view_pager_img_d);
        addtocart = findViewById(R.id.add_to_cart_id);
        cart_goto = findViewById(R.id.cart_detail);
        add_towishlist = findViewById(R.id.add_to_wishlist);
        add_towishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add to wishlist code
                add_towishlist.setImageResource(R.drawable.wishbutton_onclick);
            }
        });
        cart_goto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyCart.class);
                startActivity(intent);
            }
        });
        buynow = findViewById(R.id.buy_now_id);
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MyCart.class);
                startActivity(intent);
            }
        });
        buynow = findViewById(R.id.buy_now_id);
        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuyNow.class);
                startActivity(intent);
            }
        });
//        searchView = findViewById(R.id.search_id_detail);
//        searchView.onActionViewExpanded();
//        searchView.setIconifiedByDefault(true);
//        searchView.setQueryHint("Search for Products, Brands and More");

//        popup = inflater.inflate(R.layout.product_detail_popup,null);
//        linearLayout = popup.findViewById(R.id.product_popup);
        circleIndicator = findViewById(R.id.indicator_d);
        circleIndicator.setViewPager(viewPager);
        listFurniture = new ArrayList<>();
        productDetails_btn = findViewById(R.id.product_details_show);
        productDetails_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog;
                dialog = new Dialog(FurnitureDetailActivity.this);
                dialog.setContentView(R.layout.product_detail_popup);
                ImageView close_btn;
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                close_btn = dialog.findViewById(R.id.close_pop);
                close_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                dialog.getWindow().setAttributes(lp);

            }
        });
        back_btn = findViewById(R.id.back_id);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        listFurniture.add(new Furniture("Indian Couch","28,000","4.8",R.drawable.diglipur));
        listFurniture.add(new Furniture("Indian Couch","28,000","4.8",R.drawable.diglipur));
        listFurniture.add(new Furniture("Indian Couch","28,000","4.8",R.drawable.diglipur));
        listFurniture.add(new Furniture("Indian Couch","28,000","4.8",R.drawable.diglipur));
        listFurniture.add(new Furniture("Indian Couch","28,000","4.8",R.drawable.diglipur));
        listFurniture.add(new Furniture("Indian Couch","28,000","4.8",R.drawable.diglipur));

        RecyclerView rcv = findViewById(R.id.rec_view_list_d);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,listFurniture);
        rcv.setLayoutManager(new GridLayoutManager(this,2));
        rcv.setAdapter(adapter);
        customSwipeAdapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(customSwipeAdapter);
    }
}
