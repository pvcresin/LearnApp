package com.example.leica.learnapp;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NavigationActivity extends ActionBarActivity {

    private DrawerLayout vDrawerLayout;
    private ActionBarDrawerToggle vDrawerToggle;
    private ListView vListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        vDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        initDrawer();


        vListView = (ListView) findViewById(R.id.navilist);
        vListView.setAdapter( new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"menu 1", "menu 2", "menu 3"}) );

    }

    // Menu が無いと動かなくなる！！
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return vDrawerToggle.onOptionsItemSelected(item);
    }

    private void initDrawer() {
        // （3本線の）切り替えボタンの生成
        vDrawerToggle = new ActionBarDrawerToggle(this, vDrawerLayout, R.string.app_name, R.string.app_name);
        vDrawerToggle.setDrawerIndicatorEnabled(true);
        vDrawerLayout.setDrawerListener(vDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        vDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        vDrawerToggle.onConfigurationChanged(newConfig);
    }
}