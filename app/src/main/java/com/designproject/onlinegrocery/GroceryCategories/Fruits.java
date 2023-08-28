package com.designproject.onlinegrocery.GroceryCategories;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.designproject.onlinegrocery.Categories;
import com.designproject.onlinegrocery.FruitsItems.Apple_Des;
import com.designproject.onlinegrocery.FruitsItems.Avocado_Des;
import com.designproject.onlinegrocery.FruitsItems.Banana_Des;
import com.designproject.onlinegrocery.FruitsItems.Grape_Des;
import com.designproject.onlinegrocery.FruitsItems.Guava_Des;
import com.designproject.onlinegrocery.FruitsItems.WaterMelon_Des;
import com.designproject.onlinegrocery.R;

public class Fruits extends AppCompatActivity {

    private ImageView Back;
    private CardView Banana;
    private CardView Apple;
    private CardView Grape;
    private CardView WaterMelon;
    private CardView Avocado;
    private CardView Guava;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Back = findViewById(R.id.BackButton);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategories();
            }
        });

        Banana = findViewById(R.id.BananaInfo);
        Banana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBanana();
            }
        });

        Apple = findViewById(R.id.AppleInfo);
        Apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApple();
            }
        });

        Grape = findViewById(R.id.GrapesInfo);
        Grape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGrape();
            }
        });

        WaterMelon = findViewById(R.id.WatermelonInfo);
        WaterMelon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWatermelon();
            }
        });

        Avocado = findViewById(R.id.AvocadoInfo);
        Avocado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opneAvocado();
            }
        });

        Guava = findViewById(R.id.GuavaInfo);
        Guava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGuava();
            }
        });

    }

    private void openCategories() {
        Intent intent = new Intent(this, Categories.class);
        startActivity(intent);
    }

    private void openBanana() {
        Intent intent = new Intent(this, Banana_Des.class);
        startActivity(intent);
    }

    private void openApple() {
        Intent intent = new Intent(this, Apple_Des.class);
        startActivity(intent);
    }

    private void openGrape() {
        Intent intent = new Intent(this, Grape_Des.class);
        startActivity(intent);
    }

    private void openWatermelon() {
        Intent intent = new Intent(this, WaterMelon_Des.class);
        startActivity(intent);
    }

    private void opneAvocado() {
        Intent intent = new Intent(this, Avocado_Des.class);
        startActivity(intent);
    }

    private void openGuava() {
        Intent intent = new Intent(this, Guava_Des.class);
        startActivity(intent);
    }

}