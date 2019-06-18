package com.example.madeinindiafurniture.home_pcg;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.madeinindiafurniture.R;
import com.example.madeinindiafurniture.furniture_list.Furniture;
import com.example.madeinindiafurniture.furniture_list.RecyclerViewAdapter;
import com.example.madeinindiafurniture.image_swiping.CustomSwipeAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {
    ViewPager viewPager;
    View view;
    View cards;
    Button view_all;
    List<Furniture> listFurniture;
    CircleIndicator circleIndicator;
    CustomSwipeAdapter customSwipeAdapter;

    int curr_pos = 0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.home_fragment_main,container,false);
         viewPager = view.findViewById(R.id.view_pager_img);
         circleIndicator = view.findViewById(R.id.indicator);
         view_all = view.findViewById(R.id.view_all_id);
//        PagerAdapter pagerAdapter = new CustomSwipeAdapter(getActivity(),)

         view_all.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 HomeExpandedFragment homeExpandedFragment = new HomeExpandedFragment();
                 FragmentManager fragmentManager = getFragmentManager();
                 FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                 HomeFragment homeFragment = new HomeFragment();
                 fragmentTransaction.replace(R.id.fragement_container, homeExpandedFragment,"home").addToBackStack(null);
//                 fragmentTransaction.addToBackStack(null);
                 fragmentTransaction.commit();
             }
         });

         circleIndicator.setViewPager(viewPager);
         listFurniture = new ArrayList<>();
        listFurniture.add(new Furniture("Indian Couch","28,000","4.8",R.drawable.diglipur));
        listFurniture.add(new Furniture("Indian Couch","28,000","4.8",R.drawable.diglipur));
        listFurniture.add(new Furniture("Indian Couch","28,000","4.8",R.drawable.diglipur));
        listFurniture.add(new Furniture("Indian Couch","28,000","4.8",R.drawable.diglipur));
        listFurniture.add(new Furniture("Indian Couch","28,000","4.8",R.drawable.diglipur));
        listFurniture.add(new Furniture("Indian Couch","28,000","4.8",R.drawable.diglipur));

         RecyclerView rcv = view.findViewById(R.id.rec_view_list);
         RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(),listFurniture);
         rcv.setLayoutManager(new GridLayoutManager(getActivity(),2));
         rcv.setAdapter(adapter);
//        viewPager.startAutoScroll();
//        viewPager.setInterval(5000);
//        viewPager.setCycle(true);
//        viewPager.setStopScrollWhenTouch(true);
         customSwipeAdapter = new CustomSwipeAdapter(getActivity());
         viewPager.setAdapter(customSwipeAdapter);
         createSlideShow();
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new MyTimer(),1000,2000);
         return view;
    }
    private void createSlideShow(){
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (curr_pos == 4){
                    curr_pos =0;
                    viewPager.setCurrentItem(curr_pos++,true);
                }

            }
        };
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },250,2000);
    }
//    public class MyTimer extends TimerTask{
//
//        @Override
//        public void run() {
//            getActivity().runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    if (viewPager.getCurrentItem() == 4){
//                        curr_pos = 0;
//                        viewPager.setCurrentItem(curr_pos++,true);
//                    }
//                    else if (viewPager.getCurrentItem() == curr_pos){
//                        viewPager.setCurrentItem(curr_pos++);
//                    }
//
//                }
//            });
//        }
//    }
}
