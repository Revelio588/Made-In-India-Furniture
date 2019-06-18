package com.example.madeinindiafurniture.home_pcg;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

public class HomeExpandedFragment extends Fragment{
    ViewPager viewPager;
    View view;
    View cards;
    Button view_all;
    List<Furniture> listFurniture;
    CustomSwipeAdapter customSwipeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_expanded,container,false);
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

        return view;

    }

}
