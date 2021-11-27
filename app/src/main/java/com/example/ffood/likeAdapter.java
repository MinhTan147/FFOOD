package com.example.ffood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class likeAdapter extends RecyclerView.Adapter<likeAdapter.LikeViewHolder> {

    private List<foods> mListfood;
    private IClickAddToLikeListener iClickAddToLikeListener;

    public interface IClickAddToLikeListener{
        void onClickAddToLike(ImageView imgAddToLike, foods Foods);
    }

    public void setData (List<foods> list, IClickAddToLikeListener listener){
        this.mListfood = list;
        this.iClickAddToLikeListener = listener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LikeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_like,parent,false);

        return new LikeViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull LikeViewHolder holder, int position) {
        foods foods = mListfood.get(position);
        if (foods == null ){
            return;
        }
        holder.imglike.setImageResource(foods.getResourceId());
        holder.pricelike.setText(foods.getPrice());
        holder.namelike.setText(foods.getName());

        holder.imgbtnlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickAddToLikeListener.onClickAddToLike(holder.imgbtnlike, foods);
            }
        });
    }


    @Override
    public int getItemCount() {
        if (mListfood != null){
            return mListfood.size();
    }
        return 0;
    }

    public class LikeViewHolder extends RecyclerView.ViewHolder{

        private ImageView imglike;
        private TextView namelike;
        private TextView pricelike;
        private ImageView imgbtnlike;

        public LikeViewHolder(@NonNull View itemView) {

            super(itemView);
            imglike = itemView.findViewById(R.id.img_hinhlike);
            namelike = itemView.findViewById(R.id.tv_namelike);
            pricelike = itemView.findViewById(R.id.tv_pricelike);
            imgbtnlike = itemView.findViewById(R.id.img_btnlike);
        }
    }
}
