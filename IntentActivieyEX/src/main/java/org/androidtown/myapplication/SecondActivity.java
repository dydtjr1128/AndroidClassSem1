package org.androidtown.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class SecondActivity extends AppCompatActivity {
    final String TAG = "CYS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Log.i(TAG, getLocalClassName() + ".onCreate");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, getLocalClassName() + ".onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, getLocalClassName() + ".onResume");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, getLocalClassName() + ".onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, getLocalClassName() + ".onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, getLocalClassName() + ".onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, getLocalClassName() + ".onRestart");
        super.onRestart();
    }
}
