package com.example.administrator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.entity.PhonenumberList;
import com.example.administrator.phoneserve.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/4.
 */
public class SecondListAdapter extends BaseAdapter{

    ArrayList<PhonenumberList> list1=new ArrayList<PhonenumberList>();

    public void addDateToList(ArrayList<PhonenumberList> listinfo){
        list1.addAll(listinfo);
    }

    public void delete(int position){
        list1.remove(position);
    }

    Context context;
    public SecondListAdapter(Context c) {
        super();
        context=c;
    }

    @Override
    public int getCount() {
        return list1.size();
    }

    @Override
    public Object getItem(int position) {
        return list1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.adaper_second_list,null);
        }

        TextView tv1= (TextView) convertView.findViewById(R.id.tv_name);
        TextView tv2= (TextView) convertView.findViewById(R.id.tv_number);
        PhonenumberList pnl=list1.get(position);
        tv1.setText(pnl.name);
        tv2.setText(pnl.number);

        return convertView;
    }
}
