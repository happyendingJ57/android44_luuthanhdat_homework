package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import function_home.HomeFragment;

public class MainActivity extends AppCompatActivity {
    Button btnHome,btnMenu,btnFavorites,btnChat;
    ImageButton btnCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHome = findViewById(R.id.idbtnHome);
        btnMenu = findViewById(R.id.idbtnMenu);
        btnCart = findViewById(R.id.idbtnCart);
        btnFavorites = findViewById(R.id.idbtnFavorites);
        btnChat = findViewById(R.id.idbtnChat);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 onFragment(HomeFragment.newInstance());
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 onFragment(MenuFragment.newInstance());
            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragment(CartFragment.newInstance());
            }
        });

        btnFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragment(FavoritesFragment.newInstance());
            }
        });

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragment(ChatFragment.newInstance());
            }
        });



    }
    //de goi class
    private void onFragment(Fragment fragment){

        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer,fragment)
                    .commit();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}