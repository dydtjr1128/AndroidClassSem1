package org.androidtown.myapplication;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ImageActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageactivity);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            finish();
        else {
            ImageFragment imageFragment = new ImageFragment();
            imageFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.imageFragment,imageFragment).commit();
        }
    }
}
