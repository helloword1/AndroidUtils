package cxx.androidutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cxx.androidutils.adapter.MyAdapter;
import cxx.androidutils.bean.MyBean;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.RecyclerView recycleView;
    private List<MyBean> datas;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.recycleView = (RecyclerView) findViewById(R.id.recycleView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(manager);
        datas = new ArrayList<>();
        adapter = new MyAdapter(R.layout.adapter_layout, datas,this);
        recycleView.setAdapter(adapter);
        boolean li=true;
        for (int i = 0; i < 10; i++) {
            if (i%3==0){
                li=false;
            }else{
                li=true;
            }
            datas.add(new MyBean("张三" + (i + 11), i + 1, "http://avatar.csdn.net/F/2/F/1_return_code.jpg", li));
        }
        adapter.notifyDataSetChanged();
    }

}
