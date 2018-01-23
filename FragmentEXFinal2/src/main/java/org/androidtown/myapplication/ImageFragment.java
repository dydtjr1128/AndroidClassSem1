package org.androidtown.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ImageFragment extends Fragment {

    ImageView imageView;
    TextView textView;
    int imageLocation[] = {R.drawable.dog,R.drawable.cat,R.drawable.elephant, R.drawable.tiger, R.drawable.lion, R.drawable.pigeon, R.drawable.zebra, R.drawable.monkey, R.drawable.panda, R.drawable.dragon, R.drawable.d1,R.drawable.d2,R.drawable.d3};
    // String animalName[] ={"Dog","Cat","Elephant","Tiger","Lion","Pigeon","Zebra","Monkey","Panda","Dragon"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup group = (ViewGroup)inflater.inflate(R.layout.imagefragment,container,false);
        imageView = (ImageView) group.findViewById(R.id.imageView01);
        textView = (TextView)group.findViewById(R.id.textview01);
        int position = getArguments().getInt("position");
        textView.setText(MainActivity.animalName[position]);
        if(position < imageLocation.length){
            imageView.setImageResource(imageLocation[position]);
        }
        return group;
    }
}
