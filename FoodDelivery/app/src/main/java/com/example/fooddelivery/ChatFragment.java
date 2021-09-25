package com.example.fooddelivery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.fooddelivery.databinding.ChatFragmentBinding;

public class ChatFragment extends Fragment {

    ChatFragmentBinding binding;
    public static ChatFragment newInstance() {
        Bundle args = new Bundle();
        ChatFragment fragment = new ChatFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.chat_fragment,container,false);
        return binding.getRoot();
    }
}
