package org.androidtown.myapplication;

import android.content.Context;
import android.content.res.Configuration;
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
    ViewGroup group;
    ImageView imageView;
    TextView textView;
    int imageLocation[] = {R.drawable.d1,R.drawable.d2,R.drawable.d3};

    boolean isLand = false;
    public static ImageFragment newInstance(int index) {
        ImageFragment f = new ImageFragment();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);

        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        group = (ViewGroup) inflater.inflate(R.layout.imagfragment, container, false);
        imageView = (ImageView) group.findViewById(R.id.imageView01);
        textView = (TextView) group.findViewById(R.id.textView01);
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT)
            isLand = false;
        else
            isLand = true;

            int position = getArguments().getInt("position");
            if (position != -1) {
                changeImage(position);

        }
        return group;
    }
    public void changeImage(int position){
        textView.setText(MainActivity.imageName[position]);
        if(position < imageLocation.length)
            imageView.setImageResource(imageLocation[position]);
    }
}
