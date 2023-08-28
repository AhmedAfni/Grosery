package com.designproject.onlinegrocery;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.designproject.onlinegrocery.Location.Gps;
import com.designproject.onlinegrocery.Location.GroceryMap;
import com.designproject.onlinegrocery.User.Profile;

public class Home extends AppCompatActivity {

    private Button buttonMap;
    private Button buttonGps;
    private Button buttonCategories;
    private ImageView profile;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Hide the action bar
        getSupportActionBar().hide();

        // Set the window to full screen
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Find the "Map" button in the layout by its ID
        buttonMap = findViewById(R.id.Mapbutton);

        // Set an OnClickListener for the "Map" button
        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the openMap() method when the button is clicked
                openMap();
            }
        });

        // Find the "GPS" button in the layout by its ID
        buttonGps = findViewById(R.id.button);

        // Set an OnClickListener for the "GPS" button
        buttonGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the openGps() method when the button is clicked
                openGps();
            }
        });

        // Find the "Categories" button in the layout by its ID
        buttonCategories = findViewById(R.id.getIntoShop);

        // Set an OnClickListener for the "Categories" button
        buttonCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the openCategories() method when the button is clicked
                openCategories();
            }
        });

        profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }
        });
    }

    private void openMap() {
        // Create an intent to start the GroceryMap activity
        Intent intent = new Intent(this, GroceryMap.class);
        startActivity(intent); // Start the GroceryMap activity
    }

    private void openGps() {
        // Create an intent to start the Gps activity
        Intent intent = new Intent(this, Gps.class);
        startActivity(intent); // Start the Gps activity
    }

    private void openCategories() {
        // Create an intent to start the Categories activity
        Intent intent = new Intent(this, Categories.class);
        startActivity(intent); // Start the Categories activity
    }

    private void openProfile() {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}
