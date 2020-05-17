package cn.edu.hebtu.software.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.adapter.OrderAdapter;
import cn.edu.hebtu.software.bean.Dish;
import cn.edu.hebtu.software.bean.OrderDetail;
import cn.edu.hebtu.software.bean.OrderTotal;
import cn.edu.hebtu.software.task.GetOrderIdTask;
import cn.edu.hebtu.software.task.GetOrderIdTask;
import cn.edu.hebtu.software.task.SureOrderDetailTask;
import cn.edu.hebtu.software.task.SureOrderTask;

public class SureOrderActivity extends AppCompatActivity {

    private TextView oId, uAddress, totalPrice, sure;
    private ListView listView;
    private List<HashMap<String, String>> sureList;
    private SharedPreferences sp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_sure_order);
        super.onCreate(savedInstanceState);

        oId = findViewById(R.id.o_id);
        uAddress = findViewById(R.id.tv_address);
        totalPrice = findViewById(R.id.tv_total_price);
        sure = findViewById(R.id.tv_pay);

        listView = findViewById(R.id.listview);

        final Intent intent = getIntent();
        final String sureStr = intent.getStringExtra("sureList");
        sureList = new ArrayList<>();
        final Gson gson = new Gson();
        sureList = gson.fromJson(sureStr,new TypeToken<List<HashMap<String, String>>>(){}.getType());
        OrderAdapter orderAdapter = new OrderAdapter(listView, sureList ,this);
        listView.setAdapter(orderAdapter);

        // 确认订单号
        GetOrderIdTask getOrderIdTask = new GetOrderIdTask(oId,this);
        getOrderIdTask.execute();

        sp = getSharedPreferences("userInfo", MODE_PRIVATE);
        uAddress.setText("收货地址："+sp.getString("uAddress",""));

        // 总价
        double tPrice = 0.00;
        for (int i = 0; i < sureList.size(); i++) {
            double goodsPrice = Integer.valueOf(sureList.get(i).get("count")) * Double.valueOf(sureList.get(i).get("price"));
            tPrice = tPrice + goodsPrice;
        }
        totalPrice.setText("￥ " + tPrice);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SureOrderActivity.this, "钱就是另一回事了~", Toast.LENGTH_SHORT).show();


                // 总表
                OrderTotal orderTotal = new OrderTotal(
                        oId.getText().toString().substring(4),
                        sp.getString("uId",""),
                        sp.getString("uNickname",""),
                        totalPrice.getText().toString().substring(2),
                        "已支付",
                        sp.getString("uPhone",""),
                        sp.getString("uAddress","")
                );

                // 详细表
                List<OrderDetail> orderList = new ArrayList<>();
                for (int i = 0; i < sureList.size(); i++){
                    OrderDetail orderDetail = new OrderDetail(
                            oId.getText().toString().substring(4),
                            sureList.get(i).get("id"),
                            sureList.get(i).get("name"),
                            sureList.get(i).get("price"),
                            sureList.get(i).get("count")
                    );
                    orderList.add(orderDetail);
                }

                String strOrderTotal = gson.toJson(orderTotal);
                Log.e("测试",strOrderTotal);
                String strOrderDetail = gson.toJson(orderList);

                SureOrderTask sureOrderTask = new SureOrderTask(SureOrderActivity.this);
                sureOrderTask.execute(strOrderTotal);

                SureOrderDetailTask sureOrderDetailTask = new SureOrderDetailTask(SureOrderActivity.this);
                sureOrderDetailTask.execute(strOrderDetail);

                Intent intent1 = new Intent();
                intent1.setClass(SureOrderActivity.this, SeccessActivity.class);
                startActivity(intent1);
            }
        });
    }
}
