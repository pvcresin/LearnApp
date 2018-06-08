package com.example.leica.learnapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class SQLiteActivity extends ActionBarActivity {
    MyOpenHelper helper;
    SQLiteDatabase db;
    EditText nameText, ageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        helper = new MyOpenHelper(this);
        db = helper.getWritableDatabase();

        nameText = (EditText) findViewById(R.id.editName);
        ageText = (EditText) findViewById(R.id.editAge);

        showDB();
    }

    public void showDB(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        Cursor c = db.query("person", new String[] { "name", "age" }, null, null, null, null, null); // query

        boolean mov = c.moveToFirst();

        while (mov) {
            String formatted = String.format("%s : %d", c.getString(0), c.getInt(1));
            adapter.add( formatted );

            mov = c.moveToNext();
        }

        ListView listView = (ListView) findViewById(R.id.dataList);

        listView.setAdapter(adapter);

        c.close();
        //db.close();
    }

    public void Clicked(View v){
        int buttonId = v.getId();

        String name = nameText.getText().toString();
        String age = ageText.getText().toString();

        if (buttonId == R.id.insert){
            ContentValues insertValues = new ContentValues();

            if (name.equals("") || age.equals("")){
                Toast.makeText(SQLiteActivity.this, "input name", Toast.LENGTH_SHORT).show();

            } else {
                insertValues.put("name", name);
                insertValues.put("age", age);

                db.insert("person", "no data", insertValues);

                Toast.makeText(SQLiteActivity.this, "inserted", Toast.LENGTH_SHORT).show();
            }

        } else if (buttonId == R.id.update){
            if (name.equals("")) {
                Toast.makeText(SQLiteActivity.this, "input name", Toast.LENGTH_SHORT).show();

            } else {
                ContentValues updateValues = new ContentValues();
                updateValues.put("age", age);
                db.update("person", updateValues, "name=?", new String[] { name });

                Toast.makeText(SQLiteActivity.this, "updated", Toast.LENGTH_SHORT).show();
            }
        } else if (buttonId == R.id.delete){
            if (name.equals("")) {
                Toast.makeText(SQLiteActivity.this, "input name", Toast.LENGTH_SHORT).show();

            } else {
                db.delete("person", "name=?", new String[] { name });
                Toast.makeText(SQLiteActivity.this, "deleted", Toast.LENGTH_SHORT).show();
            }
        } else if (buttonId == R.id.deleteAll){
            db.delete("person", null, null);
            Toast.makeText(SQLiteActivity.this, "deleted all", Toast.LENGTH_SHORT).show();
        }
        showDB();
    }
}

class MyOpenHelper extends SQLiteOpenHelper {

    public MyOpenHelper(Context context) {
        super(context, "NameAgeDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table person(" + " name text not null," + "age text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  }
}