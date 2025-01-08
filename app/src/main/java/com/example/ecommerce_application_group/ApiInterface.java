package com.example.ecommerce_application_group;

import java.util.List;

import models.AddUserRequest;
import models.AddUserRes;
import models.Shoes;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {
@GET("categoryProduct?category=teens")
    Call<List<Shoes>> getAllShoes();

@POST("add_user")
    Call<AddUserRes> addNewUser(@Body AddUserRequest addUserRequest);
}