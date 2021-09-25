package com.example.fooddelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.databinding.FavoritesFragmentBinding;

import java.util.ArrayList;
import java.util.List;

import function_home.Food;
import function_home.FoodAdapter;

public class FavoritesFragment extends Fragment {

    FavoritesFragmentBinding binding;
    List<FavortiesFood> favortiesFoods;
    FavortiesFood favortiesFood1,favortiesFood2,favortiesFood3,favortiesFood4,favortiesFood5,favortiesFood6,favortiesFood7,favortiesFood8,favortiesFood9,favortiesFood10;

    FravoriteFoodAdapter fravoriteFoodAdapter;

    public static FavoritesFragment newInstance() {

        Bundle args = new Bundle();

        FavoritesFragment fragment = new FavoritesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       binding = DataBindingUtil.inflate(inflater,R.layout.favorites_fragment,container,false);

        favortiesFoods = new ArrayList<>();

        favortiesFoods.add(new FavortiesFood(R.drawable.img_1,"mon an 1",12.03));
        favortiesFoods.add(new FavortiesFood(R.drawable.img_2,"mon an 2",5.03));
        favortiesFoods.add(new FavortiesFood(R.drawable.img_3,"mon an 3",12.05));
        favortiesFoods.add(new FavortiesFood(R.drawable.img_4,"mon an 4",12.04));
        favortiesFoods.add(new FavortiesFood(R.drawable.img_5,"mon an 5",4.03));
        favortiesFoods.add(new FavortiesFood(R.drawable.img_6,"mon an 6",12.02));
        favortiesFoods.add(new FavortiesFood(R.drawable.img_7,"mon an 7",11.06));
        favortiesFoods.add(new FavortiesFood(R.drawable.img_8,"mon an 8",15.83));
        favortiesFoods.add(new FavortiesFood(R.drawable.img_9,"mon an 9",15.07));
        favortiesFoods.add(new FavortiesFood(R.drawable.img_10,"mon an 10",14.09));


        fravoriteFoodAdapter = new FravoriteFoodAdapter(getContext(),favortiesFoods);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false);


        binding.rvFavorites.setLayoutManager(layoutManager);
        binding.rvFavorites.setAdapter(fravoriteFoodAdapter);


        binding.imgProfleFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), YourProfile.class));
            }
        });



        return binding.getRoot();
    }







    
}
