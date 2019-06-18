package com.example.madeinindiafurniture.notifications_pcg;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.madeinindiafurniture.R;

import java.util.List;

public class RecViewAdapterNotifications extends RecyclerView.Adapter<RecViewAdapterNotifications.MyViewHolder1> {
    private Context context;
    private List<Notification> lNotifications;

    public RecViewAdapterNotifications(Context context, List<Notification> lNotifications) {
        this.context = context;
        this.lNotifications = lNotifications;
    }

    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.card_notifications,viewGroup,false);
        return new MyViewHolder1(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 myViewHolder1, int i) {
        myViewHolder1.title.setText(lNotifications.get(i).getTitle1());
        myViewHolder1.about.setText(lNotifications.get(i).getContentN());
        myViewHolder1.nDate.setText(lNotifications.get(i).getDateN());

    }

    @Override
    public int getItemCount() {
        return lNotifications.size();
    }

    public static class MyViewHolder1 extends RecyclerView.ViewHolder{

        TextView title;
        TextView about;
        TextView nDate;
        CardView cardView;
        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title_id);
            about = itemView.findViewById(R.id.content_id);
            nDate = itemView.findViewById(R.id.dateN_id);
//            furniture_img = itemView.findViewById(R.id.);
//            furniture_img = itemView.findViewById(R.id.)
            cardView = itemView.findViewById(R.id.cardN_id);
        }
    }
}
