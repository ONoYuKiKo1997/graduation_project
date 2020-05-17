package cn.edu.hebtu.software.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.BindView;
import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.task.DivideDetailTask;

public class DivideDetailActivity extends AppCompatActivity {
    public ImageView imageView;
    public TextView textView;
    public ListView listView;

    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_divide);
        super.onCreate(savedInstanceState);

        textView = findViewById(R.id.tv_divide_title);
        listView = findViewById(R.id.lv_divide);
        //设置返回按钮
        imageView = findViewById(R.id.iv_return);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        intent = getIntent();
        String didideStr = intent.getStringExtra("type");
        textView.setText(didideStr);
        DivideDetailTask divideDetailTask = new DivideDetailTask(this,listView);
        divideDetailTask.execute(didideStr);

    }
}
