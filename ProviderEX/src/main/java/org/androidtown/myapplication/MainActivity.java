package org.androidtown.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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


public class MainActivity extends AppCompatActivity {
    String CHECK_CODE="1111";
    String PREFERENCES_GROUP="MyPreference";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView textView01;
    EditText editText01;
    MenuItem interMenu,exterMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView01 = (TextView) findViewById(R.id.textView01);
        editText01 = (EditText) findViewById(R.id.editText01);
        sharedPreferences = getSharedPreferences(PREFERENCES_GROUP,MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);

        interMenu = menu.findItem(R.id.internalStorage);
        exterMenu = menu.findItem(R.id.externalStorage);
        int check_id = sharedPreferences.getInt(CHECK_CODE,0);
        if(check_id == R.id.internalStorage){
            //menu.findItem(R.id.internalStorage).setChecked(true);
            interMenu.setChecked(true);
        }
        else if(check_id == R.id.externalStorage){
            //menu.findItem(R.id.externalStorage).setChecked(true);
            exterMenu.setChecked(true);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        editor.commit();
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String myPermission[] = {"android.permission.READ_EXTERNAL_STORAGE","android.permission.WRITE_EXTERNAL_STORAGE"};
        if(item.getItemId() == R.id.internalStorage){
            interMenu.setChecked(true);
            editor.putInt(CHECK_CODE,R.id.internalStorage);
        }
        else if(item.getItemId() == R.id.externalStorage) {
            exterMenu.setChecked(true);
            editor.putInt(CHECK_CODE,R.id.externalStorage);
            if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,myPermission,1);

            }

        }
        return super.onOptionsItemSelected(item);
    }
    public void saveMyData(View v){
        String data = editText01.getText().toString();
        if(interMenu.isChecked()) {
            try {
                FileOutputStream fos = openFileOutput("myfile.txt", Context.MODE_APPEND);///data/data/패키지명/files/
                PrintWriter printWriter = new PrintWriter(fos);
                printWriter.println(data);
                printWriter.close();
            } catch (Exception e) {
                return;
            }
        }
        else if(exterMenu.isChecked()){
            try {
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                Log.e("rrrr",path + " save");
                File file = new File(path,"myfile.txt");
                PrintWriter printWriter = new PrintWriter(new FileWriter(file,true));
                printWriter.println(data);
                printWriter.close();
            } catch (Exception e) {
                return;
            }
        }
    }
    public void loadMyData(View v){
        if(interMenu.isChecked()) {
            try {
                textView01.setText(null);
                FileInputStream fis = openFileInput("myfile.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                String text = reader.readLine();
                while (text != null) {
                    textView01.append(text + "\n");
                    text = reader.readLine();
                }
                reader.close();
                fis.close();
            } catch (Exception e) {
                return;
            }
        }
        else if(exterMenu.isChecked()){
            String state = Environment.getExternalStorageState();
            if(Environment.MEDIA_MOUNTED.equals(state)) {
                try {
                    File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                    Log.e("rrrr", path + "load");
                    textView01.setText(null);
                    BufferedReader reader = new BufferedReader(new FileReader(new File(path, "myfile.txt")));
                    String text = reader.readLine();
                    while (text != null) {
                        textView01.append(text + "\n");
                        text = reader.readLine();
                    }
                    reader.close();
                } catch (Exception e) {
                    return;
                }
            }
        }
    }
    //외부저장소도 분리 안됨 외부저장소는 SD카드일수도 있지만 아닌경우가 최근에는 많음(착탈식이 아니라 내장)
}

