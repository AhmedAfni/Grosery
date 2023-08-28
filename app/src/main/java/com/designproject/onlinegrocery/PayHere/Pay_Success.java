package com.designproject.onlinegrocery.PayHere;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.designproject.onlinegrocery.Categories;
import com.designproject.onlinegrocery.R;

public class Pay_Success extends AppCompatActivity {

    private TextView shopRedirectText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_success);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        shopRedirectText = findViewById(R.id.ShopRedirectText);
        shopRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Pay_Success.this, Categories.class));
            }
        });
    }
}