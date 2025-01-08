package com.example.ecommerce_application_group;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.ecommerce_application_group.databinding.ActivityRegisterBinding;

import models.AddUserRequest;
import models.AddUserRes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding registerBinding;
   private   ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerBinding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(registerBinding.getRoot());
         apiInterface=ApiClient.getInterface();
        registerBinding.button2.setOnClickListener(v -> signup());
    }

    public void signup() {
        String name = registerBinding.editText.getText().toString().trim();
        String email = registerBinding.editText2.getText().toString().trim();
        String password = registerBinding.editText3.getText().toString().trim();
        // Validate inputs
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "All fields are required.", Toast.LENGTH_LONG).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Please enter a valid email address.", Toast.LENGTH_LONG).show();
            return;
        }

        AddUserRequest addUserRequest= new AddUserRequest(password,email,name);

        apiInterface.addNewUser(addUserRequest).enqueue(new Callback<AddUserRes>() {
            @Override
            public void onResponse(Call<AddUserRes> call, Response<AddUserRes> response) {

                if(response.isSuccessful()){
                    AddUserRes res =response.body();
                    Log.d("RegisterActivity", "Response Body: " + res.toString());

                    if(res.getMessage().endsWith("user already exists")){
                        Toast.makeText(RegisterActivity.this, "User already exists. Please try with a different email.", Toast.LENGTH_LONG).show();
                    } else if(res.getUser()!=null) {
                        AddUserRes.User user=res.getUser();
                        Toast.makeText(RegisterActivity.this,"Registration successful! User name: "+user.getUserName(),Toast.LENGTH_LONG).show();
                        startActivity(new Intent(RegisterActivity.this,ProductsActivity.class));
                    } else {
                        Toast.makeText(RegisterActivity.this, "Error: User data is missing", Toast.LENGTH_LONG).show();
                    }


                }
            }

            @Override
            public void onFailure(Call<AddUserRes> call, Throwable throwable) {
Toast.makeText(RegisterActivity.this,"Error: "+throwable.getMessage(),Toast.LENGTH_LONG).show();
            }
        });




    }

    public void signIn(View view) {
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
    }
}