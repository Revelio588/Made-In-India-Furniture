package com.example.madeinindiafurniture.furniture_list;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.madeinindiafurniture.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHold> {

    private Context context;
    TextView addtocart;
    TextView buynow;
    private List<Furniture> lFurniture;

    public RecyclerViewAdapter(Context context, List<Furniture> lFurniture) {
        this.context = context;
        this.lFurniture = lFurniture;
    }

    @NonNull
    @Override
    public MyViewHold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View detail_activity;
        View view;

        LayoutInflater layoutInflater = LayoutInflater.from(context);
//        detail_activity = layoutInflater.inflate(R.layout.activity_furniture_detail_acitvity,viewGroup,false);
        view = layoutInflater.inflate(R.layout.card_furniture,viewGroup,false);
//        addtocart = detail_activity.findViewById(R.id.add_to_cart_id);
//        buynow = detail_activity.findViewById(R.id.buy_now_id);
//
        return new MyViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHold myViewHold, int i) {

        myViewHold.f_name.setText(lFurniture.get(i).getPname());
        myViewHold.furniture_img.setImageResource(lFurniture.get(i).getImgFurniture());
        myViewHold.f_price.setText(lFurniture.get(i).getP_price());
        myViewHold.f_rate.setText((lFurniture.get(i).getRating()));
//        addtocart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//            }
//        });

        //set click listener

        myViewHold.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FurnitureDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lFurniture.size();
    }

    public  class MyViewHold extends RecyclerView.ViewHolder{

        TextView f_name;
        TextView f_price;
        TextView f_rate;
        ImageView furniture_img;
        CardView cardView;

        public MyViewHold(@NonNull View itemView) {
            super(itemView);
            f_name=itemView.findViewById(R.id.p_name_id);
            f_price = itemView.findViewById(R.id.p_price_id);
            f_rate = itemView.findViewById(R.id.p_rate_id);
            furniture_img = itemView.findViewById(R.id.furniture_desc);

//            furniture_img = itemView.findViewById(R.id.);
//            furniture_img = itemView.findViewById(R.id.)
              cardView = itemView.findViewById(R.id.cardF_id);
        }
    }
}
