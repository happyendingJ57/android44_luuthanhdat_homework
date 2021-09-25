package function_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.YourProfile;
import com.example.fooddelivery.databinding.HomeFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    HomeFragmentBinding binding;

    private CategoryAdapter categoryAdapter;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment,container,false);

        categoryAdapter = new CategoryAdapter(getActivity());//ko truyen dc this

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        binding.rvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        binding.rvCategory.setAdapter(categoryAdapter);


        binding.imgProfileHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), YourProfile.class));
            }
        });

        return binding.getRoot();
    }

    private List<Category> getListCategory(){
        List<Category> list = new ArrayList<>();

        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food(R.drawable.img_1,"mon an  1",4.03));
        foodList.add(new Food(R.drawable.img_2,"mon an 2",9.04));
        foodList.add(new Food(R.drawable.img_3,"mon an 3",4.53));
        foodList.add(new Food(R.drawable.img_4,"mon an 4",5.54));
        foodList.add(new Food(R.drawable.img_5,"mon an 5",14.57));

        List<Food> foodList1 = new ArrayList<>();
        foodList1.add(new Food(R.drawable.img_6,"mon an 6",7.38));
        foodList1.add(new Food(R.drawable.img_8,"mon an 8",10.03));
        foodList1.add(new Food(R.drawable.img_7,"mon an 7",10.03));
        foodList1.add(new Food(R.drawable.img_9,"mon an 9",6.02));
        foodList1.add(new Food(R.drawable.img_10,"mon an 10",7.58));

        list.add(new Category("Recommended",foodList));
        list.add(new Category("View",foodList1));

        return  list;
    }
}
