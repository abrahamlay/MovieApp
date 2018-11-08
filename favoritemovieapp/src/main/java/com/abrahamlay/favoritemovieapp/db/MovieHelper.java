package com.abrahamlay.favoritemovieapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


import com.abrahamlay.favoritemovieapp.model.movie.ResultsItem;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static com.abrahamlay.favoritemovieapp.db.DatabaseContract.MovieColumns.*;

public class MovieHelper {
    private static String DATABASE_TABLE = TABLE_NAME;
    private Context context;
    private DatabaseHelper dataBaseHelper;

    private SQLiteDatabase database;

    public MovieHelper(Context context) {
        this.context = context;
    }

    public MovieHelper open() throws SQLException {
        dataBaseHelper = new DatabaseHelper(context);
        database = dataBaseHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dataBaseHelper.close();
    }

    /*
    METHOD DIBAWAH INI UNTUK QUERY YANG LAMA ATAU UNTUK PROJECT SQLITE
     */

    /**
     * Gunakan method ini untuk ambil semua movie yang ada
     * Otomatis di parsing ke dalam model movie
     *
     * @return hasil query berbentuk array model movie
     */
    public ArrayList<ResultsItem> query() {
        ArrayList<ResultsItem> arrayList = new ArrayList<ResultsItem>();
        Cursor cursor = database.query(DATABASE_TABLE
                , null
                , null
                , null
                , null
                , null, _ID + " DESC"
                , null);
        cursor.moveToFirst();
        ResultsItem item;
        if (cursor.getCount() > 0) {
            do {

                item = new ResultsItem();
                item.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                item.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(TITLE)));
                item.setOverview(cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)));
                item.setReleaseDate(cursor.getString(cursor.getColumnIndexOrThrow(DATE)));
                item.setPopularity(cursor.getDouble(cursor.getColumnIndexOrThrow(POPULARITY)));

                arrayList.add(item);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    /**
     * Gunakan method ini untuk query insert
     *
     * @param item model item yang akan dimasukkan
     * @return id dari data yang baru saja dimasukkan
     */
    public long insert(ResultsItem item) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(TITLE, item.getTitle());
        initialValues.put(DESCRIPTION, item.getOverview());
        initialValues.put(DATE, item.getReleaseDate());
        initialValues.put(POPULARITY,item.getPopularity());
        return database.insert(DATABASE_TABLE, null, initialValues);
    }

    /**
     * Gunakan method ini untuk query update
     *
     * @param item model item yang akan diubah
     * @return int jumlah dari row yang ter-update, jika tidak ada yang diupdate maka nilainya 0
     */
    public int update(ResultsItem item) {
        ContentValues args = new ContentValues();
        args.put(TITLE, item.getTitle());
        args.put(DESCRIPTION, item.getOverview());
        args.put(DATE, item.getReleaseDate());
        args.put(POPULARITY,item.getPopularity());
        return database.update(DATABASE_TABLE, args, _ID + "= '" + item.getId() + "'", null);
    }

    /**
     * Gunakan method ini untuk query delete
     *
     * @param id id yang akan di delete
     * @return int jumlah row yang di delete
     */
    public int delete(int id) {
        return database.delete(TABLE_NAME, _ID + " = '" + id + "'", null);
    }

    /*
    METHOD DI BAWAH INI ADALAH QUERY UNTUK CONTENT PROVIDER
    NILAI BALIK CURSOR
    */

    /**
     * Ambil data dari movie berdasarakan parameter id
     * Gunakan method ini untuk ambil data di dalam provider
     *
     * @param id id movie yang dicari
     * @return cursor hasil query
     */
    public Cursor queryByIdProvider(String id) {
        return database.query(DATABASE_TABLE, null
                , _ID + " = ?"
                , new String[]{id}
                , null
                , null
                , null
                , null);
    }

    /**
     * Ambil data dari semua Movie yang ada di dalam database
     * Gunakan method ini untuk ambil data di dalam provider
     *
     * @return cursor hasil query
     */
    public Cursor queryProvider() {
        return database.query(DATABASE_TABLE
                , null
                , null
                , null
                , null
                , null
                , _ID + " DESC");
    }

    /**
     * Simpan data ke dalam database
     * Gunakan method ini untuk query insert di dalam provider
     *
     * @param values nilai data yang akan di simpan
     * @return long id dari data yang baru saja di masukkan
     */
    public long insertProvider(ContentValues values) {
        return database.insert(DATABASE_TABLE, null, values);
    }

    /**
     * Update data dalam database
     *
     * @param id     data dengan id berapa yang akan di update
     * @param values nilai data baru
     * @return int jumlah data yang ter-update
     */
    public int updateProvider(String id, ContentValues values) {
        return database.update(DATABASE_TABLE, values, _ID + " = ?", new String[]{id});
    }

    /**
     * Delete data dalam database
     *
     * @param id data dengan id berapa yang akan di delete
     * @return int jumlah data yang ter-delete
     */
    public int deleteProvider(String id) {
        return database.delete(DATABASE_TABLE, _ID + " = ?", new String[]{id});
    }
}
