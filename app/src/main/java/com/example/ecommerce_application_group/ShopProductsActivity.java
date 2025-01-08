package com.example.ecommerce_application_group;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.android.volley.RequestQueue;

public class ShopProductsActivity extends AppCompatActivity {

    private  GridView gridView;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_products);
        gridView= findViewById(R.id.gridView);

    }
}