package com.example.ffood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentFood extends Fragment {
    private RecyclerView rcvFood;
    private View mView;
    private MainActivity mainActivity;
    private likeAdapter LikeAdapter;

    public FragmentFood(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mView = inflater.inflate(R.layout.fragment_food,container,false);
        mainActivity = (MainActivity) getActivity();

        rcvFood = mView.findViewById(R.id.rcv_food);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
        rcvFood.setLayoutManager(linearLayoutManager);

        LikeAdapter = new likeAdapter();
        LikeAdapter.setData(getListFood(), new likeAdapter.IClickAddToLikeListener() {
            @Override
            public void onClickAddToLike(ImageView imgAddToLike, foods Foods) {

            }
        });
        rcvFood.setAdapter(LikeAdapter);


       return mView;

    }

    private List<foods> getListFood(){
        List<foods> list = new ArrayList<>();
        list.add(new foods(R.drawable.combo,"Sanpham1","40.000VND"));
        list.add(new foods(R.drawable.combo,"Sanpham2","40.000VND"));
        list.add(new foods(R.drawable.combo,"Sanpham3","40.000VND"));
        list.add(new foods(R.drawable.combo,"Sanpham4","40.000VND"));
        list.add(new foods(R.drawable.combo,"Sanpham5","40.000VND"));
        return list;
    }
}
