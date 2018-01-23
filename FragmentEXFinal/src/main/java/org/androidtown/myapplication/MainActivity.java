package org.androidtown.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.OnMyItemClickListener{

    final static String animalName[] = {"Dog","Cat","Elephant","Tiger","Lion","Pigeon","Zebra","Monkey","Panda","Dragon"};
    boolean isBaseOri = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.imageFragment) == null)//land || large
            isBaseOri = true;
        else
            isBaseOri = false;
    }

    @Override
    public void getPosition(int positon) {
        if(isBaseOri){
            Intent intent = new Intent(this, ImageActivity.class);
            intent.putExtra("position", positon);
            startActivity(intent);
        }
        else{
            ImageFragment imageFragment = new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position",positon);
            imageFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.imageFragment,imageFragment).commit();
        }
    }
}
