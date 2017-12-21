package com.example.android.habittrackerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by UFO_24 on 19-12-2017.
 */

public class HabbitDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = HabbitDbHelper.class.getSimpleName();

    //Name of the database file
    private static final String DATABASE_NAME = "habbit.db";

    private static final int DATABASE_VERSION = 1;

    public HabbitDbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // CREATE TABLE tablename (_id INTEGER PRIMARY KEY AUTOINCREMENT, name INTEGER NOT NULL, day TEXT NOT NULL)

        String SQL_CREATE_HABBIT_TABLE = "CREATE TABLE " + HabbitContract.HabbitEntry.TABLE_NAME + " (" +
                HabbitContract.HabbitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HabbitContract.HabbitEntry.COLUMN_HABBIT_NAME + " INTEGER NOT NULL, " +
                HabbitContract.HabbitEntry.COLUMN_HABBIT_DAY + " TEXT NOT NULL, " +
                HabbitContract.HabbitEntry.COLUMN_HABBIT_NOTES + " TEXT);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_HABBIT_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // The database is still at version 1, so there's nothing to do be done here.

    }

    public void insertHabbitIntoDatabase(int habbitName, String habbitDay, String habbitNotes) {

        // Gets the database in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and habbit's attributes are the values.
        ContentValues contentValues = new ContentValues();
        contentValues.put(HabbitContract.HabbitEntry.COLUMN_HABBIT_NAME, habbitName);
        contentValues.put(HabbitContract.HabbitEntry.COLUMN_HABBIT_DAY, habbitDay);
        contentValues.put(HabbitContract.HabbitEntry.COLUMN_HABBIT_NOTES, habbitNotes);

        db.insert(HabbitContract.HabbitEntry.TABLE_NAME, null, contentValues);

    }

    public Cursor readHabiitFromDatabase() {

        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {HabbitContract.HabbitEntry._ID,
                HabbitContract.HabbitEntry.COLUMN_HABBIT_NAME,
                HabbitContract.HabbitEntry.COLUMN_HABBIT_DAY,
                HabbitContract.HabbitEntry.COLUMN_HABBIT_NOTES

        };

        Cursor cursor = db.query(
                HabbitContract.HabbitEntry.TABLE_NAME,// The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // The sort order
        return cursor;
    }
}
