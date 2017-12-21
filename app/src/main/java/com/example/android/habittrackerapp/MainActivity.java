package com.example.android.habittrackerapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private HabbitDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new HabbitDbHelper(this);

        // Insert habbit data into database
        pushHabbitData();

        // Retrieve habbit data from database
        pullHabbitData();

    }

    private void pushHabbitData() {

        dbHelper.insertHabbitIntoDatabase(HabbitContract.HabbitEntry.HABBIT_BADMINTON,
                "Sunday", "Stretching before play");

        dbHelper.insertHabbitIntoDatabase(HabbitContract.HabbitEntry.HABBIT_SWIMMING,
                "Saturday", "Not more than 50 minutes");

        dbHelper.insertHabbitIntoDatabase(HabbitContract.HabbitEntry.HABBIT_WATCHING_NETFLIX,
                "Friday", "American Gods");

        dbHelper.insertHabbitIntoDatabase(HabbitContract.HabbitEntry.HABBIT_PROGRAMMING,
                "Monday", "Only C++");

    }

    private void pullHabbitData() {
        Cursor cursor = dbHelper.readHabiitFromDatabase();

        int idColIndex = cursor.getColumnIndex(HabbitContract.HabbitEntry._ID);
        int nameColIndex = cursor.getColumnIndex(HabbitContract.HabbitEntry.COLUMN_HABBIT_NAME);
        int dayColIndex = cursor.getColumnIndex(HabbitContract.HabbitEntry.COLUMN_HABBIT_DAY);
        int notesColIndex = cursor.getColumnIndex(HabbitContract.HabbitEntry.COLUMN_HABBIT_NOTES);

        while (cursor.moveToNext()) {

            int cursorId = cursor.getInt(idColIndex);

            int habbit = cursor.getInt(nameColIndex);

            String day = cursor.getString(dayColIndex);

            String notes = cursor.getString(notesColIndex);

            Log.v(TAG, "Habbit: " + habbit + ", Day: " + day + ", Notes: " + notes);

        }
    }
}
