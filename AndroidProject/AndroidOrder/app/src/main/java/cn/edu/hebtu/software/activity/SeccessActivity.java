package cn.edu.hebtu.software.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import cn.edu.hebtu.software.R;

public class SeccessActivity extends AppCompatActivity {

    private Button btnFirst, btnMyOrder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_seccess);
        super.onCreate(savedInstanceState);

        btnFirst = findViewById(R.id.back_to_first);
        btnMyOrder = findViewById(R.id.my_order);
        //返回箭头 返回上一个页面
        ImageView ivReturn = findViewById(R.id.iv_return);
        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SeccessActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SeccessActivity.this,MyOrderActivity.class);
                startActivity(intent);
            }
        });
    }
}
