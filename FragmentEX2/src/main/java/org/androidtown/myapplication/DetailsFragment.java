package org.androidtown.myapplication;


import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by CYSN on 2017-03-30.
 */

public class DetailsFragment extends Fragment{
    int imageLocation[] = {R.drawable.cat,R.drawable.dog,R.drawable.tiger,R.drawable.d1,R.drawable.d2,R.drawable.d3};
    TextView textView;
    ImageView imageView;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(int index) {
        DetailsFragment f = new DetailsFragment();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("position", index);
        f.setArguments(args);

        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.datailsfragment,container, false);
        textView = (TextView)viewGroup.findViewById(R.id.textView01);
        imageView = (ImageView)viewGroup.findViewById(R.id.imageView01);
        int position = getArguments().getInt("position");
        textView.setText(MainActivity.imageName[position]);
        if(position < imageLocation.length)
            imageView.setImageResource(imageLocation[position]);
        return viewGroup;
    }
}
