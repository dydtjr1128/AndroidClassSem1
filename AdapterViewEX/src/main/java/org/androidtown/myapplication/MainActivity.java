package org.androidtown.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> tt;
    EditText editText;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView01);
        ArrayList<MyItem> items = new ArrayList<MyItem>();
        items.add(new MyItem("안드로이드 프로그래밍", "수2,3","B107"));
        items.add(new MyItem("소프트웨어 설계패턴 A", "월5,6,수5","B105"));
        items.add(new MyItem("소프트웨어 설계패턴 N", "월야2,3수야1","B105"));
        final MyAdapter myAdapter = new MyAdapter(this,R.layout.item,items);
        ArrayList<String> rr = new ArrayList<String>();
        tt = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,rr);
        listView.setAdapter(tt);
        listView.setDividerHeight(3);
        btn = (Button) findViewById(R.id.myButton);
        editText = (EditText) findViewById(R.id.editText01);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"sfsf",Toast.LENGTH_LONG).show();
                tt.add(editText.getText().toString());
            }
        });

    }
    class MyItem{
        String className;
        String classDate;
        String classLocation;
        MyItem(String className, String classDate, String classLocation){
            this.className = className;
            this.classDate = classDate;
            this.classLocation = classLocation;
        }

    }
    class MyAdapter extends BaseAdapter{
        ArrayList<MyItem> items;
        Context context;
        int resource;
        MyAdapter(Context context, int resource, ArrayList<MyItem> items){
            this.context = context;
            this.resource = resource;
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                Log.i("cys","tt");
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item,parent,false);
            }
            Log.i("cys","ttt");
            TextView textView01 = (TextView) convertView.findViewById(R.id.textView01);
            TextView textView02 = (TextView) convertView.findViewById(R.id.textView02);
            TextView textView03 = (TextView) convertView.findViewById(R.id.textView03);
            textView01.setText(items.get(position).className);
            textView02.setText(items.get(position).classDate);
            textView03.setText(items.get(position).classLocation);

            return convertView;
        }
    }
}
