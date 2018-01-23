package org.androidtown.myapplication;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by CYSN on 2017-03-31.
 */

public class                                                                ImageActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageactivity);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
        }
        else{
            ImageFragment imageFragment = new ImageFragment();
            imageFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.imagefragment,imageFragment).commit();
        }
    }
}
