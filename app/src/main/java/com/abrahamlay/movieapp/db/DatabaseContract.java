package com.abrahamlay.movieapp.db;

import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

public final class DatabaseContract {

        // Authority yang digunakan
        public static final String AUTHORITY = "com.abrahamlay.movieapp";
        public static final String SCHEME = "content";

        //
        private DatabaseContract(){}

        /*
        Penggunaan Base Columns akan memudahkan dalam penggunaan suatu table
        Untuk id yang autoincrement sudah default ada di dalam kelas BaseColumns dengan nama field _ID
         */
        public static final class MovieColumns implements BaseColumns {
            // Movie table name
            public static String TABLE_NAME = "movie";

            // Movie title
            public static String TITLE = "title";
            // Movie description
            public static String DESCRIPTION = "description";
            // Movie date
            public static String DATE = "date";
            // Movie Popularity
            public static String POPULARITY="popularity";

            // Base content yang digunakan untuk akses content provider
            public static final Uri CONTENT_URI = new Uri.Builder().scheme(SCHEME)
                    .authority(AUTHORITY)
                    .appendPath(TABLE_NAME)
                    .build();
        }

        /*
        Digunakan untuk mempermudah akses data di dalam cursor dengan parameter nama column
        */
        public static String getColumnString(Cursor cursor, String columnName) {
            return cursor.getString(cursor.getColumnIndex(columnName));
        }

        public static int getColumnInt(Cursor cursor, String columnName) {
            return cursor.getInt(cursor.getColumnIndex(columnName));
        }

        public static long getColumnLong(Cursor cursor, String columnName) {
            return cursor.getLong(cursor.getColumnIndex(columnName));
        }

    }
