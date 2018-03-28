package com.example.think.contentprovidertest;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyAdapter adapter;
    ListView listView;
    List<Data> dataList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.list_view);
        adapter=new MyAdapter(MainActivity.this,R.layout.item_layout,dataList);
        listView.setAdapter(adapter);

        initDatas();
    }

    public void initDatas() {
        Cursor cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,null,null,null);
        if(cursor!=null) {
            while(cursor.moveToNext()) {
                String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phnumber=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                Data data=new Data(name,phnumber);
                dataList.add(data);
            }
            cursor.close();
        }
        adapter.notifyDataSetChanged();
    }
}
