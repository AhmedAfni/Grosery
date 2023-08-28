package com.designproject.onlinegrocery.FruitsItems;

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

import com.designproject.onlinegrocery.Database.OrderContract;
import com.designproject.onlinegrocery.GroceryCategories.Fruits;
import com.designproject.onlinegrocery.My_Cart;
import com.designproject.onlinegrocery.R;

public class WaterMelon_Des extends AppCompatActivity {

    TextView quantityNumber, MelonName, MelonPrice;
    private ImageView Back;
    Button buttonMinus, buttonPlus, cartButton ;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_melon);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        quantityNumber = findViewById(R.id.quantityNumber);
        MelonName = findViewById(R.id.ItemMelon);
        MelonPrice = findViewById(R.id.WaterMelonPrice);

        MelonName.setText("Watermelon");

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int basePrice = 200;
                quantity++;
                displayQuantity();
                int Water_Melon_Price = basePrice * quantity;
                String setnewPrice = String.valueOf(Water_Melon_Price);
                MelonPrice.setText(setnewPrice);
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int basePrice = 200;

                //because we don't want the quantity go less than 0
                if (quantity == 0) {
                    Toast.makeText(WaterMelon_Des.this, "Can't decrease quantity < 0", Toast.LENGTH_SHORT).show();
                }else {
                    quantity--;
                    displayQuantity();
                    int Water_Melon_Price = basePrice * quantity;
                    String setnewPrice = String.valueOf(Water_Melon_Price);
                    MelonPrice.setText(setnewPrice);
                }

            }
        });

        Back = findViewById(R.id.BackButton);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WaterMelon_Des.this, Fruits.class);
                startActivity(intent);
                finish();
            }
        });

        cartButton = findViewById(R.id.CartButton);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WaterMelon_Des.this, My_Cart.class);
                startActivity(intent);
                saveCart();
            }
        });
    }

    private boolean saveCart() {
        String name = MelonName.getText().toString();
        String price = MelonPrice.getText().toString();
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

            MelonName.setText(nameofItem);
            MelonPrice.setText(priceofItem);
            quantityNumber.setText(quantityofItem);
        }
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        MelonName.setText("");
        MelonPrice.setText("");
        quantityNumber.setText("");


    }
}