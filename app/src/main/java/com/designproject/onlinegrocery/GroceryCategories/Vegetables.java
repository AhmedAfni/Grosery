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
import com.designproject.onlinegrocery.VegetablesItems.Cabbage_Des;
import com.designproject.onlinegrocery.VegetablesItems.Carrot_Des;
import com.designproject.onlinegrocery.VegetablesItems.Chilli_Des;
import com.designproject.onlinegrocery.VegetablesItems.Onion_Des;
import com.designproject.onlinegrocery.VegetablesItems.Potato_Des;
import com.designproject.onlinegrocery.VegetablesItems.Tomato_Des;

public class Vegetables extends AppCompatActivity {

    private ImageView Back;
    private CardView Cabbage;
    private CardView Carrot;
    private CardView Potato;
    private CardView Chilli;
    private CardView Tomato;
    private CardView Onion;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Back = findViewById(R.id.BackButton);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategories();
            }
        });

        Cabbage = findViewById(R.id.CabbageInfo);
        Cabbage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCabbage();
            }
        });

        Carrot = findViewById(R.id.CarrotInfo);
        Carrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCarrot();
            }
        });

        Potato = findViewById(R.id.PotatosInfo);
        Potato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPotato();
            }
        });

        Chilli = findViewById(R.id.ChilliInfo);
        Chilli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChilli();
            }
        });

        Tomato = findViewById(R.id.TomatoInfo);
        Tomato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTomato();
            }
        });

        Onion = findViewById(R.id.OnionInfo);
        Onion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOnion();
            }
        });
    }

    private void openCategories() {
        Intent intent = new Intent(this, Categories.class);
        startActivity(intent);
    }

    private void openCabbage() {
        Intent intent = new Intent(this, Cabbage_Des.class);
        startActivity(intent);
    }

    private void openCarrot() {
        Intent intent = new Intent(this, Carrot_Des.class);
        startActivity(intent);
    }

    private void openPotato() {
        Intent intent = new Intent(this, Potato_Des.class);
        startActivity(intent);
    }

    private void openChilli() {
        Intent intent = new Intent(this, Chilli_Des.class);
        startActivity(intent);
    }

    private void openTomato() {
        Intent intent = new Intent(this, Tomato_Des.class);
        startActivity(intent);
    }

    private void openOnion() {
        Intent intent = new Intent(this, Onion_Des.class);
        startActivity(intent);
    }
}