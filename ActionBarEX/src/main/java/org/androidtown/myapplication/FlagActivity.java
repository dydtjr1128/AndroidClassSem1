package org.androidtown.myapplication;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class FlagActivity extends AppCompatActivity {
    ActionBar actionBar;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            Drawable drawable = getDrawable(R.drawable.ic_chevron_left_black_24dp);
            drawable.setTint(Color.WHITE);
            actionBar.setHomeAsUpIndicator(drawable);
        }
        transaction  = getSupportFragmentManager().beginTransaction();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        transaction  = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        switch(item.getItemId()){
            case R.id.menu1:
                transaction.replace(R.id.fragmentlayout,new Fragment1()).commit();
                return true;
            case R.id.menu2:
                transaction.replace(R.id.fragmentlayout,new Fragment2()).commit();
                return true;
            case R.id.menu3:
                transaction.replace(R.id.fragmentlayout,new Fragment3()).commit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
