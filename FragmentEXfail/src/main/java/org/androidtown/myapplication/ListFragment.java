package org.androidtown.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

public class ListFragment extends Fragment {
    ListView listView;
    View previousView = null;
    int myCheckPosition = -1;
    public interface OnMyItemClickListener{
        public void getPosition(int position, boolean saved);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup group =(ViewGroup) inflater.inflate(R.layout.listfragment,container,false);
        listView = (ListView)group.findViewById(R.id.listView);


        return group;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_activated_1,MainActivity.imageName));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.rgb(130,187,236));
                if(previousView != null){
                    previousView.setBackgroundColor(Color.WHITE);
                }
                previousView = view;
                myCheckPosition = position;
                ((OnMyItemClickListener)getActivity()).getPosition(position, false);
            }
        });
        if(savedInstanceState != null) {
            myCheckPosition = savedInstanceState.getInt("curChoice", -1);
            if (myCheckPosition > -1) {
               // previousView = (View) listView.getItemAtPosition(myCheckPosition);
              //  previousView.setBackgroundColor(Color.rgb(130, 187, 236));
                ((OnMyItemClickListener)getActivity()).getPosition(myCheckPosition, true);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", myCheckPosition);
    }
}
