package com.example.ecommerce_application_group;

import models.PaymentRequest;
import models.PaymentResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PaymentApiInterface {
    @POST("stk")
    Call<PaymentResponse> makePayment(@Body PaymentRequest paymentRequest);

}
