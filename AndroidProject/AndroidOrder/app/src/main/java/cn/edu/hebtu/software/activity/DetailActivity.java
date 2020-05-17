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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.bean.Dish;
import cn.edu.hebtu.software.task.ReadCommentTask;
import cn.edu.hebtu.software.util.MyCartApplication;
import cn.edu.hebtu.software.util.ShowDishImage;

public class DetailActivity extends AppCompatActivity {
    public ImageView imageView,ivReturn;
    public TextView tvName,tvHunSu,tvKouWei,tvPrice;
    public Button btnAddToCart;

    private Intent intent;
    private MyCartApplication app;
    private ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_detail);
        super.onCreate(savedInstanceState);
        ivReturn = findViewById(R.id.iv_return);
        imageView = findViewById(R.id.iv_detail);
        tvName = findViewById(R.id.tv_detail_name);
        tvHunSu = findViewById(R.id.tv_detail_hunsu);
        tvKouWei = findViewById(R.id.tv_detail_taste);
        tvPrice = findViewById(R.id.tv_detail_price);
        btnAddToCart = findViewById(R.id.btn_add_to_cart);
        listView = findViewById(R.id.lv_comment);
        app = (MyCartApplication)getApplication();
        //获取对象信息
        intent = getIntent();

        // 将信息实例化一个对象 方便加购物车
        final Dish d = new Dish(
                intent.getStringExtra("dId"),
                intent.getStringExtra("dName"),
                intent.getStringExtra("dHunSu"),
                intent.getStringExtra("dKouWei"),
                intent.getStringExtra("dPrice"),
                intent.getStringExtra("dImageUrl"));
        Log.e("测试",d.toString());
        // 显示大图
        SharedPreferences sharedPreferences = getSharedPreferences("myServer", MODE_PRIVATE);
        String serverUrl = sharedPreferences.getString("serverUrl","");
        ShowDishImage s = new ShowDishImage(imageView,serverUrl+"/"+d.getDImageUrl());
        s.execute();

        //详情
        DecimalFormat format = new DecimalFormat("0.00");
        tvName.setText(d.getdName());
        tvHunSu.setText(d.getdHunSu());
        tvKouWei.setText(d.getdKouWei());
        tvPrice.setText("￥"+format.format(new BigDecimal(d.getdPrice())));

        Log.e("lll",d.getdPrice());

        // 加入购物车按钮
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("myCart", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                app.addDishCount(d);
                Toast.makeText(DetailActivity.this,"添加购物车成功",Toast.LENGTH_SHORT).show();
            }
        });

        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ReadCommentTask readCommentTask = new ReadCommentTask(DetailActivity.this,listView);
        readCommentTask.execute(Integer.valueOf(d.getdId()));
    }
}
