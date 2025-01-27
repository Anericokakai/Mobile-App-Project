package com.example.ecommerce_application_group;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit getRetrofit(){
        HttpLoggingInterceptor  httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient= new OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build();
        return new Retrofit.Builder()
                .baseUrl("https://coolcicks.onrender.com/api/coolcicks/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient).build();

    }

    public  static  ApiInterface getInterface (){
        return getRetrofit().create(ApiInterface.class);
    }


    public  static  Retrofit getPaymentApiRetrofit ()
    {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build();

        return new Retrofit.Builder()
                .baseUrl("https://e1de-2c0f-fe38-2011-c35b-c7f0-9b40-6f15-7242.ngrok-free.app/api/")  // Payment API base URL
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
    public  static  PaymentApiInterface getPaymentApiInterface(){
        return getPaymentApiRetrofit().create(PaymentApiInterface.class);
    }
}
