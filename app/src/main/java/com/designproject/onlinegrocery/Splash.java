package com.designproject.onlinegrocery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash extends AppCompatActivity {

    public static int SPLASH_TIMER = 2000;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        firebaseAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Check if the user is already logged in
                FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                if (currentUser != null) {
                    // User is already logged in, redirect to Home activity
                    Intent intent = new Intent(Splash.this, Home.class);
                    startActivity(intent);
                } else {
                    // User is not logged in, redirect to MainActivity
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, SPLASH_TIMER);
    }
}

