package org.androidtown.myapplication;


import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by CYSN on 2017-03-30.
 */

public class DetailsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datailsactivity);

        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        DetailsFragment details = new DetailsFragment();
        details.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().replace(R.id.details, details).commit();
    }
}
