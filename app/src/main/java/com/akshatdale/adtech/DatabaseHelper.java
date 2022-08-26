package com.akshatdale.adtech;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "AD_Technologies_DB";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "UserData";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_EMAIL = "Email";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (" + COLUMN_ID + " integer primary key autoincrement , " +
                "" + COLUMN_NAME + " text , " +
                COLUMN_EMAIL + " text , " + COLUMN_PASSWORD + " text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists " +TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void signUpData(String name,String email ,String password){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_EMAIL,email);
        values.put(COLUMN_PASSWORD,password);

        sqLiteDatabase.insert(TABLE_NAME,null,values);

    }
}
