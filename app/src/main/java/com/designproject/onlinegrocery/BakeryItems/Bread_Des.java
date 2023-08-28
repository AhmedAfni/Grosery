package com.designproject.onlinegrocery.BakeryItems;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import com.designproject.onlinegrocery.GroceryCategories.Bakery;
import com.designproject.onlinegrocery.My_Cart;
import com.designproject.onlinegrocery.Database.OrderContract;
import com.designproject.onlinegrocery.R;

public class Bread_Des extends AppCompatActivity {

    TextView quantityNumber, itemName, itemPrice;
    private ImageView Back;
    private Button buttonMinus, buttonPlus, cartButton ;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        quantityNumber = findViewById(R.id.quantityNumber);
        itemName = findViewById(R.id.ItemBread);
        itemPrice = findViewById(R.id.BreadPrice);


        itemName.setText("Bread");

        // Get reference to Firebase Realtime Database

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int basePrice = 200;
                quantity++;
                displayQuantity();
                int Bread_Price = basePrice * quantity;
                String setnewPrice = String.valueOf(Bread_Price);
                itemPrice.setText(setnewPrice);


            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int basePrice = 200;

                //because we don't want the quantity go less than 0
                if (quantity == 0) {
                    Toast.makeText(Bread_Des.this, "Can't decrease quantity < 0", Toast.LENGTH_SHORT).show();
                }else {
                    quantity--;
                    displayQuantity();
                    int Bread_Price = basePrice * quantity;
                    String setnewPrice = String.valueOf(Bread_Price);
                    itemPrice.setText(setnewPrice);

                }

            }
        });

        Back = findViewById(R.id.BackButton);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bread_Des.this, Bakery.class);
                startActivity(intent);
                finish();
            }
        });


        cartButton = findViewById(R.id.CartButton);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bread_Des.this, My_Cart.class);
                startActivity(intent);
                saveCart();
            }
        });
    }

    private boolean saveCart() {
        String name = itemName.getText().toString();
        String price = itemPrice.getText().toString();
        String quantity = quantityNumber.getText().toString();

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);

        if (mCurrentCartUri == null) {
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if (newUri == null) {
                Toast.makeText(this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Successfully addedd to Cart", Toast.LENGTH_SHORT).show();
            }
        }
        hasAllRequiredValues = true;
        return true;
    }

    private void displayQuantity() {
        quantityNumber.setText(String.valueOf(quantity));
    }


    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY
        };

        return new CursorLoader(this, mCurrentCartUri, projection, null, null, null);
}
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if (cursor == null || cursor.getCount() < 1) {
            return;
        }
        if (cursor.moveToFirst()) {

            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);

            String nameofItem = cursor.getString(name);
            String priceofItem = cursor.getString(price);
            String quantityofItem = cursor.getString(quantity);

            itemName.setText(nameofItem);
            itemPrice.setText(priceofItem);
            quantityNumber.setText(quantityofItem);
        }
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        itemName.setText("");
        itemPrice.setText("");
        quantityNumber.setText("");


    }
}