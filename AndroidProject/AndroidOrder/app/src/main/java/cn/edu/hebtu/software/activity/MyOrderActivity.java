package cn.edu.hebtu.software.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.task.GetOrderTotalTask;

public class MyOrderActivity extends AppCompatActivity {
    ImageView ivReturn;
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);
        listView = findViewById(R.id.lv_my_order);

        ivReturn = findViewById(R.id.iv_return);
        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String uId = sharedPreferences.getString("uId","");
        GetOrderTotalTask getOrderTotalTask = new GetOrderTotalTask(this,listView);
        getOrderTotalTask.execute(uId);
    }
}
