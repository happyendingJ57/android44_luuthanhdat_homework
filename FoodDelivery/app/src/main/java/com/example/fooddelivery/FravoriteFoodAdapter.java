package com.example.fooddelivery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import function_home.Food;


public class FravoriteFoodAdapter extends RecyclerView.Adapter<FravoriteFoodAdapter.Viewhoder> {

    List<FavortiesFood>favortiesFoodList;
    private Context mcontext;

    public FravoriteFoodAdapter(Context context,List<FavortiesFood> favortiesFoodList) {
        this.mcontext = context;
        this.favortiesFoodList = favortiesFoodList;
    }



    @Override
    public FravoriteFoodAdapter.Viewhoder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_favorites,parent,false);

        Viewhoder vh = new Viewhoder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder( FravoriteFoodAdapter.Viewhoder holder, int position) {

        final FavortiesFood favortiesFood = favortiesFoodList.get(position);
        if(favortiesFood == null){
            return;
        }

        holder.tvgiaFood.setText(""+favortiesFoodList.get(position).getGiaFood());
        holder.tvtenFood.setText(""+favortiesFoodList.get(position).getTenFood());
        holder.imgFood.setImageResource(favortiesFoodList.get(position).getImgID());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(favortiesFood);
            }
        });

    }

    private  void onClickGoToDetail(FavortiesFood favortiesFood){
        Intent intent = new Intent(mcontext,DeitalActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user",favortiesFood);

        intent.putExtras(bundle);

        mcontext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return favortiesFoodList.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {

        private RelativeLayout layoutItem;
        private ImageView imgFood;
        private TextView tvtenFood;
        private  TextView tvgiaFood;

        public Viewhoder( View itemView) {
            super(itemView);

            layoutItem = itemView.findViewById(R.id.layout_item);
            imgFood = itemView.findViewById(R.id.id_img_Food);
            tvtenFood = itemView.findViewById(R.id.id_Ten_Food);
            tvgiaFood = itemView.findViewById(R.id.id_GiaBan_Food);
        }
    }
}
