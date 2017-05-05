package com.example.administrator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.entity.PhoneList;
import com.example.administrator.phoneserve.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/4.
 */
public class FirstListAdapter extends BaseAdapter{

    ArrayList<PhoneList> list=new ArrayList<PhoneList>();

    public void addDateToList(ArrayList<PhoneList> listinfo){
        list.addAll(listinfo);
    }

    public void delete(int position){
        list.remove(position);
    }

    Context context;
    public FirstListAdapter(Context c) {
        super();
        context=c;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.adapter_first_list,null);
        }

        TextView tv= (TextView) convertView.findViewById(R.id.tv_type);
        ImageView iv= (ImageView) convertView.findViewById(R.id.iv_image);
        PhoneList pl=list.get(position);
        tv.setText(pl.type);
        iv.setImageResource(pl.image);

        return convertView;
    }
}
