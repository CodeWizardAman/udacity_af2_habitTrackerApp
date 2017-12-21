package com.example.android.habittrackerapp;

/**
 * Created by UFO_24 on 18-12-2017.
 */

import android.provider.BaseColumns;

/**
 * API Contract for the Habbit app.
 */
public final class HabbitContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private HabbitContract() {
    }

    ;

    /**
     * Inner class that defines constant values for the habbits database table.
     * Each entry in the table represents a single habbit.
     */
    public static final class HabbitEntry implements BaseColumns {

        /**
         * Name of database table for habbits
         */
        public final static String TABLE_NAME = "habbits";

        /**
         * Unique ID number for the habbits (only for use in the database table).
         * <p>
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the habbit.
         * <p>
         * The only possible values are {@link #HABBIT_BADMINTON}, {@link #HABBIT_SWIMMING},
         * ,{@link #HABBIT_WATCHING_NETFLIX} or {@link #HABBIT_PROGRAMMING}.
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_HABBIT_NAME = "name";

        /**
         * day of the habbit to be followed.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_HABBIT_DAY = "days";


        public final static String COLUMN_HABBIT_NOTES = "notes";

        /**
         * Possible values for the name of the habbit.
         */
        public static final int HABBIT_BADMINTON = 0;
        public static final int HABBIT_SWIMMING = 1;
        public static final int HABBIT_WATCHING_NETFLIX = 2;
        public static final int HABBIT_PROGRAMMING = 3;

    }
}
