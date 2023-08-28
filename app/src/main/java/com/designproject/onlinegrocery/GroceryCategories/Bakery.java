package com.designproject.onlinegrocery.GroceryCategories;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.designproject.onlinegrocery.BakeryItems.Bread_Des;
import com.designproject.onlinegrocery.BakeryItems.Breadbun_Des;
import com.designproject.onlinegrocery.BakeryItems.ChocCake_Des;
import com.designproject.onlinegrocery.BakeryItems.CupCake_Des;
import com.designproject.onlinegrocery.BakeryItems.HotDog_Des;
import com.designproject.onlinegrocery.BakeryItems.Sausage_Des;
import com.designproject.onlinegrocery.Categories;
import com.designproject.onlinegrocery.R;

public class Bakery extends AppCompatActivity {

    private ImageView Back;
    private CardView Bread;
    private CardView CupCake;
    private CardView ChoclateCake;
    private CardView BreadBun;
    private CardView HotDog;

    private CardView Sausage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakery);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Back = findViewById(R.id.BackButton);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategories();
            }
        });

        Bread = findViewById(R.id.BreadInfo);
        Bread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBread();
            }
        });

        CupCake = findViewById(R.id.CupcakeInfo);
        CupCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCupCake();
            }
        });

        ChoclateCake = findViewById(R.id.CakeInfo);
        ChoclateCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChoclateCake();
            }
        });

        BreadBun = findViewById(R.id.BreadBunInfo);
        BreadBun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBreadbun();
            }
        });

        HotDog = findViewById(R.id.HotdogInfo);
        HotDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHotDog();
            }
        });

        Sausage = findViewById(R.id.SausageInfo);
        Sausage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSausage();
            }
        });
    }

    private void openCategories() {
        Intent intent = new Intent(this, Categories.class);
        startActivity(intent);
    }

    private void openBread() {
        Intent intent = new Intent(this, Bread_Des.class);
        startActivity(intent);
    }

    private void openCupCake() {
        Intent intent = new Intent(this, CupCake_Des.class);
        startActivity(intent);
    }

    private void openChoclateCake() {
        Intent intent = new Intent(this, ChocCake_Des.class);
        startActivity(intent);
    }

    private void openBreadbun() {
        Intent intent = new Intent(this, Breadbun_Des.class);
        startActivity(intent);
    }

    private void openHotDog() {
        Intent intent = new Intent(this, HotDog_Des.class);
        startActivity(intent);
    }

    private void openSausage() {
        Intent intent = new Intent(this, Sausage_Des.class);
        startActivity(intent);
    }

}