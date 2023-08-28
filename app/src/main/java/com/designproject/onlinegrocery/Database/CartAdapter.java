package com.designproject.onlinegrocery.Database;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.designproject.onlinegrocery.R;

public class CartAdapter extends CursorAdapter {


    //cursor adapter used to populate the items in the cart list.
    // It binds the data from the database cursor to the views in the cart list layout.

    private Context mContext;

    public CartAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
        mContext = context;
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cartlist, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView itemName, price, quantity;
        Button deleteButton;

        itemName = view.findViewById(R.id.itemNameInCart);
        price = view.findViewById(R.id.priceInCart);
        quantity = view.findViewById(R.id.quantityInCart);
        deleteButton = view.findViewById(R.id.Drop);

        // Getting the values by getting the position of their columns
        int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
        int priceofitem = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
        int quantityofitem = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);

        final String nameofitem = cursor.getString(name);
        final String pricesofitem = cursor.getString(priceofitem);
        final String quantitysofitem = cursor.getString(quantityofitem);

        itemName.setText(nameofitem);
        price.setText(pricesofitem);
        quantity.setText(quantitysofitem);

        // Set click listener for the delete button
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteItemFromDatabase(nameofitem, pricesofitem, quantitysofitem);
            }
        });
    }

    private void deleteItemFromDatabase(String name, String price, String quantity) {
        // Create the selection and selectionArgs for the delete query
        String selection = OrderContract.OrderEntry.COLUMN_NAME + " = ? AND " +
                OrderContract.OrderEntry.COLUMN_PRICE + " = ? AND " +
                OrderContract.OrderEntry.COLUMN_QUANTITY + " = ?";
        String[] selectionArgs = {name, price, quantity};

        // Perform the delete operation using the ContentResolver
        int rowsDeleted = mContext.getContentResolver().delete(
                OrderContract.OrderEntry.CONTENT_URI,
                selection,
                selectionArgs
        );

        if (rowsDeleted > 0) {
            Toast.makeText(mContext, "Item deleted from database", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "Failed to delete item from database", Toast.LENGTH_SHORT).show();
        }
    }
}
