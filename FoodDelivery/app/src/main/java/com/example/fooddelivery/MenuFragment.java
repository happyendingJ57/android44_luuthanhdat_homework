package com.example.fooddelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.fooddelivery.databinding.MenuFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {

    MenuFragmentBinding binding;

    public static MenuFragment newInstance() {
        Bundle args = new Bundle();
        MenuFragment fragment = new MenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = DataBindingUtil.inflate(inflater,R.layout.menu_fragment,container,false);

        binding.imgProfleMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), YourProfile.class));
            }
        });


        return binding.getRoot();
    }
}
