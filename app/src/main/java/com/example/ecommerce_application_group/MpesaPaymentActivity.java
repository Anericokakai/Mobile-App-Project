package com.example.ecommerce_application_group;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ecommerce_application_group.databinding.ActivityMpesaPaymentBinding;

import models.AddUserRes;
import models.PaymentRequest;
import models.PaymentResponse;
import models.Shoes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MpesaPaymentActivity extends AppCompatActivity {

    ActivityMpesaPaymentBinding mpesaPaymentBinding;

    PaymentApiInterface  paymentApiInterface;
   Shoes shoes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mpesaPaymentBinding= ActivityMpesaPaymentBinding.inflate(getLayoutInflater());

        setContentView(mpesaPaymentBinding.getRoot());
        paymentApiInterface=ApiClient.getPaymentApiInterface();
         Intent intent=getIntent();
        shoes= (Shoes) intent.getSerializableExtra("data");

        if(shoes!=null){
          mpesaPaymentBinding.amount.setText(shoes.getPrice());
        }

        clickListener();
    }

    private void clickListener() {
        mpesaPaymentBinding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pay(v);
            }
        });
    }

    public void pay(View view) {
        String phoneNumber =mpesaPaymentBinding.phoneNumber.getText().toString();
        String amount = shoes.getPrice();

        if (phoneNumber.isEmpty()) {
            mpesaPaymentBinding.phoneNumber.setError("Phone number is required");
            return;
        }

        if (!phoneNumber.matches("^0\\d{9}$")) {
            mpesaPaymentBinding.phoneNumber.setError("Phone number must start with +254 and have 9 digits after it");
            return;
        }

        PaymentRequest paymentRequest=new PaymentRequest(phoneNumber,amount);


 Call<PaymentResponse> call = paymentApiInterface.makePayment(paymentRequest);
 call.enqueue(new Callback<PaymentResponse>() {
     @Override
     public void onResponse(Call<PaymentResponse> call, Response<PaymentResponse> response) {

         if(response.isSuccessful()){
             PaymentResponse paymentResponse=response.body();
             if (paymentResponse != null) {
                 // Handle the response (Success)
                 Toast.makeText(MpesaPaymentActivity.this, paymentResponse.getCustomerMessage(), Toast.LENGTH_LONG).show();
                 // Proceed with further action (e.g., redirect to a success screen)
             } else {
                 // Handle null response body
                 Toast.makeText(MpesaPaymentActivity.this, "Unexpected error occurred", Toast.LENGTH_LONG).show();
             }
         } else {
             Toast.makeText(MpesaPaymentActivity.this, "Payment failed. Please try again.", Toast.LENGTH_LONG).show();
         }
     }

     @Override
     public void onFailure(Call<PaymentResponse> call, Throwable throwable) {
         Toast.makeText(MpesaPaymentActivity.this, "Payment error: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
     }
 });

    }

}