package org.androidtown.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String text[] = {"item1","item2","item3","item4","item5","item6","item7","item8"};

        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,text);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.item,text);
       // MyAdapter arrayAdapter = new MyAdapter(this,R.layout.item,text);
        //ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.items,android.R.layout.simple_list_item_1);

        ListView listView = (ListView) findViewById(R.id.listView01);
        listView.setAdapter(arrayAdapter);
    }
    class MyAdapter extends BaseAdapter{
        String message[];
        Context context;
        int resource;
        MyAdapter(Context context, int resource, String message[]){
           this.message = message;
           this.context = context;
           this.resource = resource;
       }

        @Override
        public int getCount() {
            return message.length;
        }

        @Override
        public Object getItem(int position) {
            //return arrayList.get(position);
            return message[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(resource,parent,false);
            }
            TextView textView = (TextView) findViewById(R.id.textView01);
            textView.setText(message[position]);
            return convertView;
        }
    }
}
