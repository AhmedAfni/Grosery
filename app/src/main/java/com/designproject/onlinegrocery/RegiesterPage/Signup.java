package com.designproject.onlinegrocery.RegiesterPage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.designproject.onlinegrocery.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    private FirebaseAuth auth;
    private Button signupButton;
    private TextView loginRedirectText;
    private EditText signupEmail, signupPassword, signupAddress, signupPhone;
    private DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        auth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference(); // Reference to the root of the database

        signupEmail = findViewById(R.id.signup_email);
        signupPassword = findViewById(R.id.signup_password);
        signupAddress = findViewById(R.id.signup_address);
        signupPhone = findViewById(R.id.signup_phone_Number);

        signupButton = findViewById(R.id.signup_button);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = signupEmail.getText().toString().trim();
                String pass = signupPassword.getText().toString().trim();
                String add = signupAddress.getText().toString().trim();
                String PhNo = signupPhone.getText().toString().trim();

                if (user.isEmpty()) {
                    signupEmail.setError("Email can't be empty");
                } else if (pass.isEmpty()) {
                    signupPassword.setError("Password can't be empty");
                } else if (add.isEmpty()) {
                    signupAddress.setError("Address can't be empty");
                } else if (PhNo.isEmpty()) {
                    signupPhone.setError("Phone Number can't be empty");
                } else {
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                String userId = auth.getCurrentUser().getUid();
                                DatabaseReference currentUserRef = databaseReference.child("Users").child(userId);
                                currentUserRef.child("email").setValue(user);
                                currentUserRef.child("phone").setValue(PhNo);
                                currentUserRef.child("address").setValue(add);

                                Toast.makeText(Signup.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Signup.this, Login.class));
                            } else {
                                Toast.makeText(Signup.this, "SignUp Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        loginRedirectText = findViewById(R.id.loginRedirectText);
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }

    private void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}

