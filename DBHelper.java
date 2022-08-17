package com.example.nyumbani;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
    DB.execSQL("create Table Userdetails(Title TEXT primary key, Description TEXT, Date DATE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
    DB.execSQL("drop table if exists Userdetails");
    }

    public Boolean insertdata(String title,String desc,String date) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Title", title);
        contentValues.put("Description", desc);
        contentValues.put("Date", date);
        long result = DB.insert("Userdetails", null, contentValues);
        if (result ==-1) {
            return false;
        } else {
            return true;
        }
    }
        public Cursor getdata()
        {
            SQLiteDatabase DB= this.getWritableDatabase();
            Cursor cursor= DB.rawQuery("Select * from Userdetails",null);
            return cursor;
        }
    public Boolean deleteuserdata(String title)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where title = ?", new String[]{title});
        if(cursor.getCount()>0)
        {
            long result = DB.delete("Userdetails", "title=?", new String[]{title});
            if(result==-1)
            {
                return  false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }

    }

}



