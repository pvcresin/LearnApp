package com.example.leica.learnapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ListActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = (ListView) findViewById(R.id.listView);

        String [] Names = { "Name0", "Name1", "Name2", "Name3", "Name4", "Name5", "Name6", "Name7", "Name8", "Name9", "Name10", "Name11", "Name12", "Name13", "Name14" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Names );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {                        // tap
            @Override
            public void onItemClick( AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;

                String item = (String) listView.getItemAtPosition(position);
                Toast.makeText( ListActivity.this, item + " clicked", Toast.LENGTH_SHORT ).show();
            }
        });

        listView.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {                  // select
            @Override
            public void onItemSelected( AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;

                String item = (String) listView.getSelectedItem();
                Toast.makeText( ListActivity.this, item + " selected", Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onNothingSelected( AdapterView<?> parent) {
            }
        });

        listView.setOnItemLongClickListener( new AdapterView.OnItemLongClickListener() {                // long tap
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;

                String item = (String) listView.getItemAtPosition(position);
                Toast.makeText( ListActivity.this, item + " long clicked", Toast.LENGTH_SHORT ).show();
                return false;
            }
        });
    }

}