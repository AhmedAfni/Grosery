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
import com.designproject.onlinegrocery.R;
import com.designproject.onlinegrocery.SeaFoodItems.CatFish_Des;
import com.designproject.onlinegrocery.SeaFoodItems.Clams_Des;
import com.designproject.onlinegrocery.SeaFoodItems.Crab_Des;
import com.designproject.onlinegrocery.SeaFoodItems.Salmon_Des;
import com.designproject.onlinegrocery.SeaFoodItems.Shrimp_Des;
import com.designproject.onlinegrocery.SeaFoodItems.Tuna_Des;

public class SeaFood extends AppCompatActivity {

    private ImageView Back;
    private CardView Shrimp;
    private CardView Crab;
    private CardView salmon;
    private CardView Tuna;
    private CardView catFish;
    private CardView Clams;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sea_food);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Back = findViewById(R.id.BackButton);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategories();
            }
        });

        Shrimp = findViewById(R.id.ShrimpInfo);
        Shrimp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShrimp();
            }
        });

        Crab = findViewById(R.id.CrabInfo);
        Crab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCrab();
            }
        });

        salmon = findViewById(R.id.SalmonInfo);
        salmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSalmon();
            }
        });

        Tuna = findViewById(R.id.TunaInfo);
        Tuna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTuna();
            }
        });

        catFish = findViewById(R.id.CatfishInfo);
        catFish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCatFish();
            }
        });

        Clams = findViewById(R.id.ClamsInfo);
        Clams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClasm();
            }
        });
    }

    private void openCategories() {
        Intent intent = new Intent(this, Categories.class);
        startActivity(intent);
    }

    private void openShrimp() {
        Intent intent = new Intent(this, Shrimp_Des.class);
        startActivity(intent);
    }

    private void openCrab() {
        Intent intent = new Intent(this, Crab_Des.class);
        startActivity(intent);
    }

    private void openSalmon() {
        Intent intent = new Intent(this, Salmon_Des.class);
        startActivity(intent);
    }

    private void openTuna() {
        Intent intent = new Intent(this, Tuna_Des.class);
        startActivity(intent);
    }

    private void openCatFish() {
        Intent intent = new Intent(this, CatFish_Des.class);
        startActivity(intent);
    }

    private void openClasm() {
        Intent intent = new Intent(this, Clams_Des.class);
        startActivity(intent);
    }
}