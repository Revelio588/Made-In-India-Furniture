package com.example.madeinindiafurniture;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.madeinindiafurniture.furniture_list.FurnitureDetailActivity;

public class OrderHistoryFragment extends Fragment {
    View view;
    ImageView expand_detail;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.card_history,container,false);
        expand_detail = view.findViewById(R.id.expand_info_id);
        expand_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                Intent intent = new Intent(getActivity(), FurnitureDetailActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
