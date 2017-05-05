package com.example.administrator.phoneserve;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.adapter.SecondListAdapter;
import com.example.administrator.entity.PhonenumberList;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv1;
    SecondListAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lv1= (ListView) findViewById(R.id.lv_phonenumber);

        adapter1=new SecondListAdapter(this);
        lv1.setAdapter(adapter1);

        ArrayList<PhonenumberList> list1=new ArrayList<PhonenumberList>();
        list1.add(new PhonenumberList("歌华有线电视","96196"));
        list1.add(new PhonenumberList("供电服务热线","95598"));
        list1.add(new PhonenumberList("医疗保险查询","96102"));
        list1.add(new PhonenumberList("短信报警号码","12110"));
        list1.add(new PhonenumberList("报时服务","12117"));
        list1.add(new PhonenumberList("天气预报","12121"));
        list1.add(new PhonenumberList("交通事故报警","122"));
        list1.add(new PhonenumberList("匪警台","110"));
        list1.add(new PhonenumberList("电话报障","112"));
        list1.add(new PhonenumberList("查号台","114"));
        list1.add(new PhonenumberList("火警","119"));
        list1.add(new PhonenumberList("中国移动客服","10086"));
        list1.add(new PhonenumberList("供电局","95598"));
        list1.add(new PhonenumberList("价格监督举报","12358"));

        adapter1.addDateToList(list1);
        adapter1.notifyDataSetChanged();

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(SecondActivity.this);
                dialog.setTitle("删除提示");
                dialog.setMessage("是否删除?");
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter1.delete(position);
                        adapter1.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("取消",null);
                dialog.create();
                dialog.show();
                return true;
            }
        });

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                PhonenumberList pnl= (PhonenumberList) adapter1.getItem(position);
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+pnl.number));
                startActivity(intent);
            }
        });



    }
}
