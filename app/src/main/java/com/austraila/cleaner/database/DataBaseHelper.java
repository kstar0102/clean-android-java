package com.austraila.cleaner.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Bin.db";
    public static final String TABLE_NAME="BinTable";
    public static final String COL_1="ID";
    public static final String COL_2="BinCycle";
    public static final String COL_3="BinColour";
    public static final String COL_4="BinDate";
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,BinCycle TEXT,BinColour TEXT,BinDate TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }
}
