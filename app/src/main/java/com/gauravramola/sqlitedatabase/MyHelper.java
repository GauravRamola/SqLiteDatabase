package com.gauravramola.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "myDatabase";
    private static final int VERSION = 2;

    public MyHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE PRODUCTS (_Id INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT,DESCRIPTION TEXT, PRICE REAL)";
        db.execSQL(sql);

        // insert data
        insertData("Jam", "Fruit Jam", 380.20, db);
        insertData("Bread", "Brown Bread", 35.0, db);
    }

    private void insertData(String name, String description, double price, SQLiteDatabase database) {
        ContentValues values = new ContentValues();
        values.put("NAME", name);
        values.put("DESCRIPTION", description);
        values.put("PRICE", price);
        database.insert("PRODUCTS", null, values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="CREATE TABLE EMPLOYEE (_Id INTEGER PRIMARY KEY AUTOINCREMENT ,NAME TEXT,EMAIL TEXT,SALARY REAL)";
        db.execSQL(sql);
        employeeData("Gaurav","gauravramola18@gmail.com",10000,db );
    }
    private void employeeData(String name,String email,double salary,SQLiteDatabase database){
        ContentValues values= new ContentValues();
        values.put("NAME",name);
        values.put("EMAIL",email);
        values.put("SALARY",salary);
        database.insert("EMPLOYEE",null,values);
    }
}
