package com.designproject.onlinegrocery.PayHere;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.designproject.onlinegrocery.R;

public class Payment extends AppCompatActivity {

    private EditText cardNumber, expiryDate, cvv;
    private Button payHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        cardNumber = findViewById(R.id.card_number);
        expiryDate = findViewById(R.id.expiry_date);
        cvv = findViewById(R.id.cvv);
        payHere = findViewById(R.id.pay);

        payHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String crdNo = cardNumber.getText().toString().trim();
                String expDate = expiryDate.getText().toString().trim();
                String cvvNo = cvv.getText().toString().trim();

                boolean isValid = true;

                if (crdNo.isEmpty()) {
                    cardNumber.setError("Card Number can't be empty");
                    isValid = false;
                } else if (crdNo.length() != 16) {
                    cardNumber.setError("Invalid Card Number");
                    isValid = false;
                } else if (!isValidCardNumber(crdNo)) {
                    cardNumber.setError("Invalid Card Number");
                    isValid = false;
                }

                if (expDate.isEmpty()) {
                    expiryDate.setError("Expiry Date can't be empty");
                    isValid = false;
                } else if (expDate.length() != 5 || !isValidExpiryDate(expDate)) {
                    expiryDate.setError("Invalid Date (MM/YY)");
                    isValid = false;
                }


                if (cvvNo.isEmpty()) {
                    cvv.setError("CVV Number can't be empty");
                    isValid = false;
                } else if (cvvNo.length() != 3) {
                    cvv.setError("Invalid CVV Number");
                    isValid = false;
                }

                if (isValid) {
                    Toast.makeText(Payment.this, "Payment Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Payment.this, Pay_Success.class));
                }
            }
        });
    }

    private boolean isValidCardNumber(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
            alternate = !alternate;
        }
        return sum % 10 == 0;
    }

    private boolean isValidExpiryDate(String expiryDate) {
        String[] parts = expiryDate.split("/");
        if (parts.length == 2) {
            try {
                int month = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                return month >= 1 && month <= 12 && year >= 0 && year <= 99;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
