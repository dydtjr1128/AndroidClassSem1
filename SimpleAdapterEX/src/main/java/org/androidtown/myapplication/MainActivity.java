package org.androidtown.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String className[] = {"소프트웨어 프로그래밍","안드로이드 프로그래밍","소프트웨어 공학","운영체제"};
    String classRoom[] = {"B106","B306","B506","B304"};
    String classTime[] = {"수12","수67","화12","목456"};
    String []from = new String[]{"className", "classRoom","classTime"};
    int []to = new int[]{R.id.textView01,R.id.textView02,R.id.textView03};
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView) findViewById(R.id.listView01);
        ArrayList<HashMap<String,String>> arrayList = new ArrayList<HashMap<String,String>>();
        HashMap<String,String> map;
        for(int i=0; i<className.length; i++){
            map = new HashMap<String,String>();
            map.put(from[0],className[i]);
            map.put(from[1],classRoom[i]);
            map.put(from[2],classTime[i]);
            arrayList.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, arrayList, R.layout.item, from, to);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if(toast != null){
                    toast.cancel();
                }
                toast = Toast.makeText(getApplicationContext(),className[position] ,Toast.LENGTH_SHORT);
                toast.show();

            }
        });
    }
}
