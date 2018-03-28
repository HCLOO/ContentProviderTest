package com.example.think.contentprovidertest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Think on 2018/3/23.
 */

public class MyAdapter extends ArrayAdapter<Data> {

    int mresource;

    public MyAdapter(@NonNull Context context, int resource, @NonNull List<Data> objects) {
        super(context, resource, objects);

        mresource=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Data data=getItem(position);
        View view;
        ViewHolder holder;
        if(convertView==null) {
           view= LayoutInflater.from(getContext()).inflate(mresource,parent,false);
           holder=new ViewHolder(view);
           view.setTag(holder);
        } else {
            view=convertView;
            holder=(ViewHolder)view.getTag();
        }
        holder.textView1.setText(data.getName());
        holder.textView2.setText(data.getPhnumber());
        return view;
    }

    class ViewHolder {
        TextView textView1;
        TextView textView2;
        public ViewHolder(View view) {
            textView1=(TextView)view.findViewById(R.id.text_name);
            textView2=(TextView)view.findViewById(R.id.text_phnumber);
        }
    }
}
