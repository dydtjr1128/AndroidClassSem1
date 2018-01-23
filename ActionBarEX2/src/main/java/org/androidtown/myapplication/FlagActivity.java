package org.androidtown.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class FlagActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seond);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            Drawable drawable = getDrawable(R.drawable.ic_fast_rewind_black_24dp);
            if(drawable != null){
                drawable.setTint(Color.BLUE);
                actionBar.setHomeAsUpIndicator(drawable);
            }
        }
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        switch(item.getItemId()){
            case R.id.fragment1item:
                fragmentTransaction.replace(R.id.container,new Flagment1()).commit();
                return true;
            case R.id.fragment2item:
                fragmentTransaction.replace(R.id.container,new Flagment2()).commit();
                return true;
            case R.id.fragment3item:
                fragmentTransaction.replace(R.id.container,new Flagment3()).commit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
