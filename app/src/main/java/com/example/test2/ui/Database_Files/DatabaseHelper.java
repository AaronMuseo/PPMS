package com.example.test2.ui.Database_Files;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper{

    private Context context;
    private static final String DATABASE_NAME = "PPMS.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Consumer";
    private static final String TABLE_NAME2 = "Meter";

    //Consumer Table Columns
    private static final String COLUMN_ID = "Consumer_ID";
    private static final String COLUMN_NAME = "Username";
    private static final String COLUMN_PASSWORD = "Password";
    private static final String COLUMN_MTR = "Meter_Number";
    private static final String COLUMN_LOCATION = "Location";

    //Meter Table Columns
    private static final String COLUMN_MTR_NUMBER = "Meter_Number";
    private static final String COLUMN_MTR_CUSTOMER = "Consumer_ID";
    private static final String COLUMN_MTR_QUANTITY = "Token_Quantity";
    private static final String COLUMN_MTR_USAGE = "Token_Usage";
    private static final String COLUMN_MTR_LOCATION = "Location";

    public DatabaseHelper(@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String query = "CREATE TABLE " + TABLE_NAME +
                    " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT, " +
                    COLUMN_MTR + " INTEGER, " +
                    COLUMN_LOCATION + " TEXT);";

            String query2 = "CREATE TABLE " + TABLE_NAME2 +
                    " (" + COLUMN_MTR_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_MTR_CUSTOMER + " INTEGER, " +
                    COLUMN_MTR_QUANTITY + " INTEGER, " +
                    COLUMN_MTR_USAGE + " INTEGER, " +
                    COLUMN_MTR_LOCATION + " TEXT);";

            db.execSQL(query);
            db.execSQL(query2);
        } catch (Exception e) {
            // Log the exception to help with debugging
            e.printStackTrace();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate((db));

    }

    public void addConsumer(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, username);
        cv.put(COLUMN_PASSWORD, password);

        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
    }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }


}
