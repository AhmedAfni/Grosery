package com.designproject.onlinegrocery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.designproject.onlinegrocery.GroceryCategories.Bakery;
import com.designproject.onlinegrocery.GroceryCategories.Biscuits;
import com.designproject.onlinegrocery.GroceryCategories.Fruits;
import com.designproject.onlinegrocery.GroceryCategories.Juices;
import com.designproject.onlinegrocery.GroceryCategories.SeaFood;
import com.designproject.onlinegrocery.GroceryCategories.Vegetables;

public class Categories extends AppCompatActivity {

    private CardView fruits;
    private CardView vegetables;
    private CardView bakery;
    private CardView biscuits;
    private CardView seafood;
    private CardView juices;
    private ImageView cart;
    private ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        fruits = findViewById(R.id.fruits);
        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFruits();
            }
        });

        vegetables = findViewById(R.id.vegetables);
        vegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVegetables();
            }
        });

        bakery = findViewById(R.id.bakery);
        bakery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBakery();
            }
        });

        biscuits = findViewById(R.id.biscuits);
        biscuits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBiscuits();
            }
        });

        seafood = findViewById(R.id.seafood);
        seafood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSeaFood();
            }
        });

        juices = findViewById(R.id.juices);
        juices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJuices();
            }
        });

        cart = findViewById(R.id.CartIcon);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCart();
            }
        });

        home = findViewById(R.id.HomeIcon);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
    }

    private void openFruits() {
        Intent intent = new Intent(this, Fruits.class);
        startActivity(intent);
    }

    private void openVegetables() {
        Intent intent = new Intent(this, Vegetables.class);
        startActivity(intent);
    }

    private void openBakery() {
        Intent intent = new Intent(this, Bakery.class);
        startActivity(intent);
    }

    private void openBiscuits() {
        Intent intent = new Intent(this, Biscuits.class);
        startActivity(intent);
    }

    private void openSeaFood() {
        Intent intent = new Intent(this, SeaFood.class);
        startActivity(intent);
    }

    private void openJuices() {
        Intent intent = new Intent(this, Juices.class);
        startActivity(intent);
    }

    private void openCart() {
        Intent intent = new Intent(this, My_Cart.class);
        startActivity(intent);
    }

    private void openHome() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}