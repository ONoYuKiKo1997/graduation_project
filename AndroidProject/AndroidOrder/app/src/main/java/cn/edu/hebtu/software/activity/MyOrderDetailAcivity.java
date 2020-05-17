package cn.edu.hebtu.software.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.adapter.OrderDetailAdapter;
import cn.edu.hebtu.software.bean.OrderDetail;
import cn.edu.hebtu.software.task.GetOrderDetailTask;

public class MyOrderDetailAcivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_order_detail);
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String oId = intent.getStringExtra("oId");

        listView = findViewById(R.id.listview);

        GetOrderDetailTask getOrderDetailTask = new GetOrderDetailTask(MyOrderDetailAcivity.this,listView);
        getOrderDetailTask.execute(oId);
    }
}
