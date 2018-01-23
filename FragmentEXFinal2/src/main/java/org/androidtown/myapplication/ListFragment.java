package org.androidtown.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    int mySelectPosition = -1;
    interface OnMyItemSelectListener{
        public void getPosition(int position);
    }
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listfragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView) getView().findViewById(R.id.listView01);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1,MainActivity.animalName));
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setSmoothScrollbarEnabled(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mySelectPosition = position;
                ((OnMyItemSelectListener)getActivity()).getPosition(position);
            }
        });
        if(savedInstanceState != null){
            mySelectPosition = savedInstanceState.getInt("position");
            if(mySelectPosition > -1){
                ((OnMyItemSelectListener)getActivity()).getPosition(mySelectPosition);
            }
        }
        listView.smoothScrollToPosition(mySelectPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position",mySelectPosition);
    }
}
