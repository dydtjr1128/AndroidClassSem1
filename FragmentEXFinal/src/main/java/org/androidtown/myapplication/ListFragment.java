package org.androidtown.myapplication;

import android.Manifest;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListFragment extends Fragment {
    int mySelectPositon = -1;
    ListView listView;
    String from[] = {"animalName"};
    int to[] = {R.id.textView02};
    View previous = null;
    interface OnMyItemClickListener{
        public void getPosition(int positon);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listfragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView)getView().findViewById(R.id.listView01);
   /*     ArrayList<HashMap<String,String>> arrayList = new ArrayList<HashMap<String,String>>();
        for(int i=0; i<MainActivity.animalName.length; i++){
            HashMap<String,String> map = new HashMap<String,String>();
            map.put(from[0], MainActivity.animalName[i]);
            arrayList.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), arrayList, R.layout.simpleadapter, from, to);*/
        listView.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1,MainActivity.animalName));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //view1.setBackgroundColor(Color.rgb(146,235,188));
               /* if(previous != null){
                    previous.setBackgroundColor(Color.rgb(101,219,236));
                }
                view.setBackgroundColor(Color.rgb(146,235,188));
                previous = view;*/
                mySelectPositon = position;
                ((OnMyItemClickListener)getActivity()).getPosition(position);
            }
        });
        if(savedInstanceState != null){
            mySelectPositon = savedInstanceState.getInt("position");
            if(mySelectPositon > -1) {
                ((OnMyItemClickListener) getActivity()).getPosition(mySelectPositon);
            }
        }
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setSelection(mySelectPositon);
        listView.smoothScrollToPosition(mySelectPositon);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position",mySelectPositon);
    }
}
