package com.example.nyumbani;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dhelper extends SQLiteOpenHelper {
    public dhelper(Context context) {
        super(context, "Users.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Gb(Housenumber CHAR primary key, Status TEXT, Date DATE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists Gb");
    }

    public Boolean insertdata(String hnumber, String status, String date) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Housenumber", hnumber);
        contentValues.put("Status", status);
        contentValues.put("Date", date);
        long result = DB.insert("Gb", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Gb", null);
        return cursor;
    }
}