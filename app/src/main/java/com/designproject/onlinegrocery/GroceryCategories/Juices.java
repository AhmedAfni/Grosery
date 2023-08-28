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
import com.designproject.onlinegrocery.JuicesItems.AppleJuice_Des;
import com.designproject.onlinegrocery.JuicesItems.Faluda_Des;
import com.designproject.onlinegrocery.JuicesItems.Fito_Des;
import com.designproject.onlinegrocery.JuicesItems.Milo_Des;
import com.designproject.onlinegrocery.JuicesItems.MixedFruit_Des;
import com.designproject.onlinegrocery.JuicesItems.Vanilla_Des;
import com.designproject.onlinegrocery.R;

public class Juices extends AppCompatActivity {

    private ImageView Back;
    private CardView Nectar;
    private CardView Fito;
    private CardView Milo;
    private CardView AppleNectar;
    private CardView Vanilla;
    private CardView Faluda;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juices);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Back = findViewById(R.id.BackButton);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategories();
            }
        });

        Nectar = findViewById(R.id.MixedFruitInfo);
        Nectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNectar();
            }
        });

        Fito = findViewById(R.id.FitoInfo);
        Fito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFito();
            }
        });

        Milo = findViewById(R.id.MiloInfo);
        Milo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openMilo();
            }
        });

        AppleNectar = findViewById(R.id.AppleNectarInfo);
        AppleNectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAppleNectar();
            }
        });

        Vanilla = findViewById(R.id.AnchorVanillaInfo);
        Vanilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVanilla();
            }
        });

        Faluda = findViewById(R.id.DailyFaludaInfo);
        Faluda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFaluda();
            }
        });
    }

    private void openCategories() {
        Intent intent = new Intent(this, Categories.class);
        startActivity(intent);
    }

    private void openNectar() {
        Intent intent = new Intent(this, MixedFruit_Des.class);
        startActivity(intent);
    }

    private void openFito() {
        Intent intent = new Intent(this, Fito_Des.class);
        startActivity(intent);
    }

    private void openMilo() {
        Intent intent = new Intent(this, Milo_Des.class);
        startActivity(intent);
    }

    private void openAppleNectar() {
        Intent intent = new Intent(this, AppleJuice_Des.class);
        startActivity(intent);
    }

    private void openVanilla() {
        Intent intent = new Intent(this, Vanilla_Des.class);
        startActivity(intent);
    }

    private void openFaluda() {
        Intent intent = new Intent(this, Faluda_Des.class);
        startActivity(intent);
    }
}