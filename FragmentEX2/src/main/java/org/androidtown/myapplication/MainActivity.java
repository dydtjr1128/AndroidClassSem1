package org.androidtown.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TitlesFragment.OnTitleSelectedListener {
    public static String imageName[] = {"Cat", "Dog", "Tiger","Elephant","Lion","Rabbit","bear","horse"};
    boolean isLand = false;//po
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.details) != null)
            isLand = true;
        else
            isLand = false;
      /*  if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            isLand = false;
        }
        else {
            isLand = true;
        }*/

    }

    @Override
    public void onTitleSelected(int position, boolean saved) {
        if(isLand){
            DetailsFragment detailsFragment = DetailsFragment.newInstance(position);
            getSupportFragmentManager().beginTransaction().replace(R.id.details,detailsFragment).commit();
        }
        else{
            if(saved == false) {
                Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
            /*transaction = fragmentManager.beginTransaction();
            transaction.addToBackStack(null);
            detailsFragment = new DetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("positon",position);
            detailsFragment.setArguments(bundle);
           transaction.replace(R.id.mainfragmentxx,detailsFragment).commit();*/

        }
    }
}
