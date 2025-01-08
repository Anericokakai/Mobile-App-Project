package com.example.ecommerce_application_group;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ecommerce_application_group.databinding.ActivityMainBinding;
import com.example.ecommerce_application_group.databinding.ActivityProductsBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import models.Shoes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {
    ;
private RequestQueue requestQueue;
private ProductsAdapter productsAdapter ;
    private List<Shoes> shoesList =new ArrayList<>();
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        gridView=findViewById(R.id.gridView);

        fetchProducts();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              startActivity(new Intent(ProductsActivity.this,DetailedProductActivity.class).putExtra("data",shoesList.get(position)));
            }
        });

    }

   public  void  fetchProducts(){
       Call<List<Shoes>>  shoesResponse = ApiClient.getInterface().getAllShoes();
       shoesResponse.enqueue(new Callback<List<Shoes>>() {
           @Override
           public void onResponse(Call<List<Shoes>> call, Response<List<Shoes>> response) {
               if(response.isSuccessful()){
                   String message ="Success in Fetching request";
                   Toast.makeText(ProductsActivity.this,message,Toast.LENGTH_LONG).show();
                   shoesList=response.body();
                   productsAdapter = new ProductsAdapter(ProductsActivity.this, shoesList);
                   gridView.setAdapter(productsAdapter);
               }
               else {
                String message ="An error occurred Try Again Later";
                Toast.makeText(ProductsActivity.this,message,Toast.LENGTH_LONG).show();

               }

           }

           @Override
           public void onFailure(Call<List<Shoes>> call, Throwable throwable) {

               String message =throwable.getLocalizedMessage();
               Toast.makeText(ProductsActivity.this,message,Toast.LENGTH_LONG).show();
           }
       });

   }



}