package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {
    final String TAG = "CYS";
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        editText = (EditText) findViewById(R.id.editText01);
        Intent intent = getIntent();
        String text = intent.getStringExtra("value");
        editText.setText(text);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("value",editText.getText().toString());
        setResult(RESULT_OK,intent);
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
