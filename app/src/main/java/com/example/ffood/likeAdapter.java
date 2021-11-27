package com.example.ffood;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class likeAdapter {

    public class LikeViewHolder extends RecyclerView.ViewHolder{

        private ImageView imglike;

        public LikeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
