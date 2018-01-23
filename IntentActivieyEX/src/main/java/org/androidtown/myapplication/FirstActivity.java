package org.androidtown.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class FirstActivity extends AppCompatActivity {
    final String TAG = "CYS";
    final int REQUEST_CODE = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Log.i(TAG, getLocalClassName() + ".onCreate");
    }

    public void button1Clicked(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.button01:
                intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.button02:
                intent = new Intent(getApplicationContext(),ThirdActivity.class);
                intent.putExtra("value","Hello My Name is FirstActivity");
                startActivityForResult(intent,REQUEST_CODE);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String text = data.getStringExtra("value");
                Log.i(TAG, text);
            }
        }
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
