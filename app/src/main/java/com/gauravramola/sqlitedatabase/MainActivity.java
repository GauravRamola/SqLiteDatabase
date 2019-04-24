package com.gauravramola.sqlitedatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);

        MyHelper helper = new MyHelper(this);
        SQLiteDatabase database = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("PRICE", 280.00);
        // update data
        database.update("PRODUCTS", values, "_id=?", new String[]{"1"});
        //delete Data
        database.delete("PRODUCTS", "_id=?", new String[]{"1"});

        Cursor cursor = database.rawQuery("SELECT NAME, PRICE FROM PRODUCTS", new String[]{});

        Cursor cursorl=database.rawQuery("SELECT NAME,SALARY FROM EMPLOYEE",new String[]{});

        if (cursor != null) {
            cursor.moveToFirst();
        }
        StringBuilder builder = new StringBuilder();
        do {
            String name = cursor.getString(0);
            Double price = cursor.getDouble(1);

            builder.append("NAME-" + name + "PRICE-" + price);
        } while (cursor.moveToNext());
        textView.setText(builder.toString());

        if (cursorl!=null){
            cursorl.moveToFirst();
        }
        StringBuilder stringBuilder=new StringBuilder();
        do {
            String name=cursorl.getString(0);
            double salary=cursorl.getDouble(1);
            stringBuilder.append("NAME- "+name+"SALARY- "+salary);
        }while (cursorl.moveToNext());
        textView2.setText(stringBuilder.toString());

    }
}
