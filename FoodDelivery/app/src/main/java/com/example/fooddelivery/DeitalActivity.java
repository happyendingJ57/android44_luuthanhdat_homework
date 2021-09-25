package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DeitalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deital);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }

        FavortiesFood favortiesFood =(FavortiesFood) bundle.get("object_user");
        TextView tvTenspDetail = findViewById(R.id.tv_tensp_detail);
        ImageView imgDetail = findViewById(R.id.img_detail);
        TextView tvMoneydetail = findViewById(R.id.tv_money_detail);

        tvTenspDetail.setText(favortiesFood.getTenFood());
        imgDetail.setImageResource(favortiesFood.getImgID());
        tvMoneydetail.setText(""+favortiesFood.getGiaFood());



    }
}