package org.androidtown.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ImageFragment extends Fragment {
    int imageLocation[] = {R.drawable.dog,R.drawable.cat,R.drawable.elephant, R.drawable.tiger, R.drawable.lion, R.drawable.pigeon, R.drawable.zebra, R.drawable.monkey, R.drawable.panda, R.drawable.dragon, R.drawable.d1,R.drawable.d2,R.drawable.d3};
    // String animalName[] ={"Dog","Cat","Elephant","Tiger","Lion","Pigeon","Zebra","Monkey","Panda","Dragon"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup group = (ViewGroup)inflater.inflate(R.layout.imagefragmnet, container, false);
        ImageView imageView = (ImageView)group.findViewById(R.id.imageView01);
        TextView textView = (TextView)group.findViewById(R.id.textView01);
        int position = getArguments().getInt("position");
        textView.setText(MainActivity.animalName[position]);
        if(position < imageLocation.length) {
            imageView.setImageResource(imageLocation[position]);
        }
        return group;
    }

}
