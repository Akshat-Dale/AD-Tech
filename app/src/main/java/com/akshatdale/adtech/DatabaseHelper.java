package com.akshatdale.adtech;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

//    ADDING DATA
    public void signUpData(String name,String email ,String password){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_EMAIL,email);
        values.put(COLUMN_PASSWORD,password);

        sqLiteDatabase.insert(TABLE_NAME,null,values);

    }

//    FETCHING DATA
    public ArrayList<UserDetails> fetchData(){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME,null);
        ArrayList<UserDetails> userDetailsArrayList = new ArrayList<>();

//        MOVING CURSOR AND GET DATA
        while (cursor.moveToNext()){
            UserDetails userDetails = new UserDetails();
            userDetails.name = cursor.getString(1);
            userDetails.email = cursor.getString(2);
            userDetails.password = cursor.getString(3);

            userDetailsArrayList.add(userDetails);
        }
        return  userDetailsArrayList;
    }

//    UPDATE DATA
    public void forgotPasswordData(UserDetails userDetails){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PASSWORD,userDetails.password);
        sqLiteDatabase.update(TABLE_NAME,values,COLUMN_EMAIL + "=?" ,new String[]{userDetails.email});
    }


}
