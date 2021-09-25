package function_home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;

import java.util.List;

public class CategoryAdapter extends  RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    private Context mContext;
    private List<Category> mListCategory;

    public CategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public  void setData (List<Category> list){
        this.mListCategory = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_fragment_ngang,parent,false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = mListCategory.get(position);

        if(category == null){
            return;
        }

        holder.tvNameCategory.setText(category.getNameCatery());


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext , RecyclerView.HORIZONTAL,false);
        holder.rvFood.setLayoutManager(linearLayoutManager);

        FoodAdapter foodAdapter = new FoodAdapter();
        foodAdapter.setData(category.getFoods());

        holder.rvFood.setAdapter(foodAdapter);
    }

    @Override
    public int getItemCount() {
        return mListCategory.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{


        private TextView tvNameCategory;
        private RecyclerView rvFood;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNameCategory = itemView.findViewById(R.id.tv_name_catery);
            rvFood = itemView.findViewById(R.id.rv_Food);
        }
    }
}
