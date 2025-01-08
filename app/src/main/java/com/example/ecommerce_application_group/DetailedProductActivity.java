package com.example.ecommerce_application_group;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import models.Shoes;

public class DetailedProductActivity extends AppCompatActivity {

Shoes shoes;
TextView title,description,price;
        ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_product);
        Intent intent =getIntent();
        title=findViewById(R.id.selected_title);
        description =findViewById(R.id.selected_description);
        price =findViewById(R.id.selected_price);
        imageView =findViewById(R.id.selected_image);

        if(intent.getExtras()!=null){
            shoes= (Shoes) intent.getSerializableExtra("data");

            if(shoes != null) {
                title.setText(shoes.getShoeName());
                description.setText(shoes.getShoeDescription());
                price.setText(shoes.getPrice());

                GlideApp.with(this).load(shoes.getImages().get(0)).into(imageView);
            }


        }
    }

    public void redirectToPay(View view) {
        startActivity(new Intent(DetailedProductActivity.this,MpesaPaymentActivity.class).putExtra("data", shoes));
    }
}