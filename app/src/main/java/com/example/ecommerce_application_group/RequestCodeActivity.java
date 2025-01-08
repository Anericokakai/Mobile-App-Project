package com.example.ecommerce_application_group;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RequestCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_code);
    }

    public void signup(View view) {
        startActivity(new Intent(RequestCodeActivity.this,RegisterActivity.class));
    }

    public void requestcode(View view) {

        startActivity(new Intent(RequestCodeActivity.this, Verify_codeActivity.class));
    }
}