package org.androidtown.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String MY_PREFERENCES = "MY_PREFERENCES";
    String SAVE_MY_CODE = "SAVE_CODE";
    MenuItem internalItem, externalItem;
    TextView textView01;
    EditText editText01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView01 = (TextView) findViewById(R.id.textView01);
        editText01 = (EditText) findViewById(R.id.editText01);
        sharedPreferences = getSharedPreferences(MY_PREFERENCES, MODE_APPEND);
        editor = sharedPreferences.edit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);
        internalItem = menu.findItem(R.id.internal_storage);
        externalItem = menu.findItem(R.id.external_storage);
        int selectItem = sharedPreferences.getInt(SAVE_MY_CODE, 0);
        if (selectItem == R.id.internal_storage) {
            internalItem.setChecked(true);
        } else if (selectItem == R.id.external_storage) {
            externalItem.setChecked(true);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.external_storage) {
            externalItem.setChecked(true);
            editor.putInt(SAVE_MY_CODE, R.id.external_storage);
            editor.commit();
        } else if (item.getItemId() == R.id.internal_storage) {
            internalItem.setChecked(true);
            editor.putInt(SAVE_MY_CODE, R.id.internal_storage);
            editor.commit();
        }
        return super.onOptionsItemSelected(item);
    }

    public void mySave(View v) {
        String data = editText01.getText().toString();
        if (internalItem.isChecked()) {
            try {
                FileOutputStream fos = openFileOutput("my_file.txt", Context.MODE_APPEND);
                PrintWriter printWriter = new PrintWriter(fos);
                printWriter.println(data);
                printWriter.close();
                fos.close();
            } catch (Exception e) {
                return;
            }
        } else if (externalItem.isChecked()) {
            String state = Environment.getExternalStorageState();
            try {
                if (Environment.MEDIA_MOUNTED.equals(state)) {
                    File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                    File file = new File(path, "my_text.txt");
                    PrintWriter printWriter = new PrintWriter(new FileWriter(file,true));
                    printWriter.println(data);
                    printWriter.close();
                }
            } catch (Exception e) {
                return;
            }
        }

    }

    public void myLoad(View v) {
        if (internalItem.isChecked()) {
            try {
                textView01.setText(null);
                FileInputStream fis = openFileInput("my_file.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
                String data = bufferedReader.readLine();
                while (data != null) {
                    textView01.append(data + "\n");
                    data = bufferedReader.readLine();
                }
                fis.close();
                bufferedReader.close();
            } catch (Exception e) {
                return;
            }
        } else if (externalItem.isChecked()) {
            try {
                textView01.setText(null);
                String state = Environment.getExternalStorageState();
                if(Environment.MEDIA_MOUNTED.equals(state)) {
                    File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path, "my_text.txt")));
                    String data = bufferedReader.readLine();
                    while (data != null) {
                        textView01.append(data + "\n");
                        data = bufferedReader.readLine();
                    }
                    bufferedReader.close();
                }
            } catch (Exception e) {
                return;
            }
        }
    }
}