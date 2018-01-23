package org.androidtown.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LinearLayout priveous;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView01);
        ArrayList<Data> arrayList = new ArrayList<Data>();
        arrayList.add(new Data("안드로이드 프로그래밍","수2,3","B107"));
        arrayList.add(new Data("소프트웨어 설계패턴A","월5,6 수5","B105"));
        arrayList.add(new Data("소프트웨어 설계패턴N","월야2,3 수야1","B105"));
        arrayList.add(new Data("소프트웨어 공학N","월야4,5 수야2","B309"));
        MyAdapter adapter = new MyAdapter(getApplicationContext(),R.layout.items, arrayList);
        listView.setAdapter(adapter);

        listView.setDividerHeight(8);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView Lview = (ListView)parent;
                LinearLayout layout = (LinearLayout)view;
                layout.setBackgroundColor(Color.rgb(200,186,168));
                if(priveous != null) {
                    priveous.setBackgroundColor(Color.WHITE);
                }
                Data item = (Data)Lview.getItemAtPosition(position);

                if(toast != null){
                    toast.cancel();
                }
                toast = Toast.makeText(getApplicationContext(),item.className ,Toast.LENGTH_SHORT);
                toast.show();

                toast.show();
                priveous = layout;
            }
        });
    }
    private class Data{
        String className;
        String classTime;
        String classRoom;
        public Data(String className, String classTime, String classRoom){
            this.className = className;
            this.classTime = classTime;
            this.classRoom = classRoom;
        }
    }
    private class MyAdapter extends BaseAdapter{
        private Context context;
        private int resource;
        private ArrayList<Data> arrayList;
       public MyAdapter(Context context, int resource, ArrayList<Data> arrayList ){
            this.context = context;
            this.resource = resource;
            this.arrayList = arrayList;
        }
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(resource, parent, false);
            }
            TextView textView01 = (TextView) convertView.findViewById(R.id.textView01);
            TextView textView02 = (TextView) convertView.findViewById(R.id.textView02);
            TextView textView03 = (TextView) convertView.findViewById(R.id.textView03);
            textView01.setText(arrayList.get(position).className);
            textView02.setText(arrayList.get(position).classTime);
            textView03.setText(arrayList.get(position).classRoom);

            return convertView;
        }
    }
}
