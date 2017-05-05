package com.example.administrator.phoneserve;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.adapter.FirstListAdapter;
import com.example.administrator.entity.PhoneList;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    ListView lv;
    FirstListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        lv= (ListView) findViewById(R.id.lv_phonelist);

        adapter=new FirstListAdapter(this);
        lv.setAdapter(adapter);

        ArrayList<PhoneList> list=new ArrayList<PhoneList>();
        list.add(new PhoneList("本地电话",1,R.drawable.a));
        list.add(new PhoneList("订餐电话",2,R.drawable.a));
        list.add(new PhoneList("公共服务",3,R.drawable.a));
        list.add(new PhoneList("运营商",4,R.drawable.a));
        list.add(new PhoneList("快递服务",5,R.drawable.a));
        list.add(new PhoneList("滴滴电话",6,R.drawable.a));
        list.add(new PhoneList("旅游热线",7,R.drawable.a));
        list.add(new PhoneList("特种服务",8,R.drawable.a));
        list.add(new PhoneList("银行服务",9,R.drawable.a));
        list.add(new PhoneList("投诉举报",10,R.drawable.a));

        adapter.addDateToList(list);
        adapter.notifyDataSetChanged();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(FirstActivity.this);
                dialog.setTitle("删除提示");
                dialog.setMessage("是否删除？");
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.delete(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("取消",null);
                dialog.create();
                dialog.show();
                return true;
            }
        });
    }
}
