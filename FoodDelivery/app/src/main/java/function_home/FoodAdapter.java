package function_home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;

import java.util.List;

public class FoodAdapter extends  RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{

    private List<Food> mFoods;

    public void setData(List<Food> list){
        this.mFoods = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foodhome,parent,false);

        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
            Food food = mFoods.get(position);
            holder.imgFood.setImageResource(food.getImgID());
            holder.tvtenFood.setText(food.getTenFood());
            holder.tvgiaFood.setText(""+food.getGiaFood());
    }

    @Override
    public int getItemCount() {
        return mFoods.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFood;
        private TextView tvtenFood;
        private  TextView tvgiaFood;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFood = itemView.findViewById(R.id.id_img_Food);
            tvtenFood = itemView.findViewById(R.id.id_Ten_Food);
            tvgiaFood = itemView.findViewById(R.id.id_GiaBan_Food);

        }
    }
}
