package org.androidtown.myapplication;



import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ListFragment.OnMyItemClickListener{
    ImageFragment imageFragment;
    FragmentManager manager;
    FragmentTransaction ft;
    public static String imageName[] = {"Cat", "Dog", "Tiger","Elephant","Lion","Rabbit"};
    boolean isLand = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            isLand = false;
        }
        else {
            isLand = true;
        }
      //  ft.replace(R.id.frameLayout,listFragment).commit();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    @Override
    public void getPosition(int position, boolean saved) {
        Bundle bundle = new Bundle();
        bundle.putInt("position",position);
        imageFragment = new ImageFragment();
        imageFragment.setArguments(bundle);
        ft = manager.beginTransaction();
        ft.addToBackStack(null);

        if(isLand){
            ft.replace(R.id.imagefragment,imageFragment).commit();
        }
        else {//potrit
            if(saved  == false) {
                ft.replace(R.id.listfragment, imageFragment).commit();
            }
        }
    }
}
