package com.example.ecommerce_application_group;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import models.Shoes;

public class ProductsAdapter extends BaseAdapter {
   private Context context;
   private List<Shoes> productList;
  private LayoutInflater layoutInflater;

   public  ProductsAdapter(Context context,List<Shoes> productList){
       this.context=context;
       this.productList =productList;
       this.layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
   }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return  productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView productPrice,productName;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_item,parent,false);
        }


        Shoes shoes= productList.get(position);
        ImageView imageView=convertView.findViewById(R.id.grid_image);
         productName =convertView.findViewById(R.id.product_name);
       productPrice  =convertView.findViewById(R.id.product_price);
       productName.setText( shoes.getShoeName());;
       productPrice.setText(shoes.getPrice());

        if (shoes.getImages() != null && !shoes.getImages().isEmpty()) {
            GlideApp.with(context).load(shoes.getImages().get(0)).into(imageView);
        } else {
            imageView.setImageResource(R.drawable.eye_off);
        }



        return convertView;
    }
}
