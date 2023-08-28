package com.designproject.onlinegrocery.Database;

import android.net.Uri;
import android.provider.BaseColumns;

public class OrderContract {

    //defines the contract between the application and the database.
    // It contains constants for the content authority, base URI, table name, column names, and the content URI.

    public OrderContract() {

    }

    public static final String CONTENT_AUTHORITY = "com.designproject.onlinegrocery";
    public static final Uri BASE_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH = "ordering";

    public static abstract class OrderEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_URI, PATH);

        public static final String TABLE_NAME = "ordering";
        public static final String _ID = BaseColumns. _ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_PRICE = "price";

    }
}
