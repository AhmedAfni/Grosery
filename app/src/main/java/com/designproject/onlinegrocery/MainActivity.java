package com.designproject.onlinegrocery;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.designproject.onlinegrocery.RegiesterPage.Login;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the action bar
        getSupportActionBar().hide();

        // Set the window to full screen
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Find the "Get" button in the layout by its ID
        button = findViewById(R.id.Getbutton);

        // Set an OnClickListener for the "Get" button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the openRegistration() method when the button is clicked
                openRegistration();
            }
        });
    }

    private void openRegistration() {
        // Create an intent to start the Registration activity
        Intent intent = new Intent(this, Login.class);
        startActivity(intent); // Start the Registration activity
    }
}
