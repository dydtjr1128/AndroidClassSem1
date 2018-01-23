package org.androidtown.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.OnMyItemSelectListener {
    final static String animalName[] = {"Dog","Cat","Elephant","Tiger","Lion","Pigeon","Zebra","Monkey","Panda","Dragon"};
    boolean isBaseOrientation = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.imagefragment) == null)
            isBaseOrientation = true;
        else // land or large
            isBaseOrientation = false;
    }

    @Override
    public void getPosition(int position) {
        if(isBaseOrientation){//potriot
            Intent intent = new Intent(this, ImageActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        }
        else {//land or large
            ImageFragment imageFragment = new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position",position);
            imageFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.imagefragment,imageFragment).commit();
        }
    }
}
