package com.designproject.onlinegrocery.GroceryCategories;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.designproject.onlinegrocery.BiscuitsItems.Cracker_Des;
import com.designproject.onlinegrocery.BiscuitsItems.Milk_Des;
import com.designproject.onlinegrocery.BiscuitsItems.Puff_Des;
import com.designproject.onlinegrocery.BiscuitsItems.Shock_Des;
import com.designproject.onlinegrocery.BiscuitsItems.Tifin_Des;
import com.designproject.onlinegrocery.Categories;
import com.designproject.onlinegrocery.BiscuitsItems.Cookies_Des;
import com.designproject.onlinegrocery.R;

public class Biscuits extends AppCompatActivity {

    private ImageView Back;
    private CardView Cookies;
    private CardView Milk;
    private CardView Tifin;
    private CardView Cracker;
    private CardView Shock;
    private CardView Puff;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biscuits);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Back = findViewById(R.id.BackButton);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategories();
            }
        });

        Cookies = findViewById(R.id.HawaiianInfo);
        Cookies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCookies();
            }
        });

        Milk = findViewById(R.id.MilkInfo);
        Milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMilk();
            }
        });

        Tifin = findViewById(R.id.TifinInfo);
        Tifin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTifin();
            }
        });

        Cracker = findViewById(R.id.CrackerInfo);
        Cracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCracker();
            }
        });

        Shock = findViewById(R.id.chocInfo);
        Shock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChoc();
            }
        });

        Puff = findViewById(R.id.PuffInfo);
        Puff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPuff();
            }
        });
    }

    private void openCategories() {
        Intent intent = new Intent(this, Categories.class);
        startActivity(intent);
    }

    private void openCookies() {
        Intent intent = new Intent(this, Cookies_Des.class);
        startActivity(intent);
    }

    private void openMilk() {
        Intent intent = new Intent(this, Milk_Des.class);
        startActivity(intent);
    }

    private void openTifin() {
        Intent intent = new Intent(this, Tifin_Des.class);
        startActivity(intent);
    }

    private void openCracker() {
        Intent intent = new Intent(this, Cracker_Des.class);
        startActivity(intent);
    }

    private void openChoc() {
        Intent intent = new Intent(this, Shock_Des.class);
        startActivity(intent);
    }

    private void openPuff() {
        Intent intent = new Intent(this, Puff_Des.class);
        startActivity(intent);
    }
}