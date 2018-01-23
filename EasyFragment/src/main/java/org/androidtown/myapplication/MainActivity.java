package org.androidtown.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button1Clicked(View v){
        if(v.getId() == R.id.button01){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new fragement1()).commit();
        }
        else if(v.getId() == R.id.button02){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new fragement2()).commit();
        }
    }
}
