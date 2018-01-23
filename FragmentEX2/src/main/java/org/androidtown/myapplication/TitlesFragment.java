package org.androidtown.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by CYSN on 2017-03-30.
 */

public class TitlesFragment extends Fragment {
    int mCurCheckPosition = -1;

    public TitlesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.titlesfragment, container, false);
    }

    public interface OnTitleSelectedListener {
        public void onTitleSelected(int i, boolean restoreSaved);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView lv = (ListView)getView().findViewById(R.id.listView01);

        lv.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1, MainActivity.imageName));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCurCheckPosition = i;

                ((OnTitleSelectedListener)getActivity()).onTitleSelected(i, false);
            }
        });

        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        if (savedInstanceState != null) {
            mCurCheckPosition = savedInstanceState.getInt("curChoice", -1);
            if (mCurCheckPosition >= 0)
                ((OnTitleSelectedListener)getActivity()).onTitleSelected(mCurCheckPosition, true);
        }

        lv.setSelection(mCurCheckPosition);
        lv.smoothScrollToPosition(mCurCheckPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }
}
