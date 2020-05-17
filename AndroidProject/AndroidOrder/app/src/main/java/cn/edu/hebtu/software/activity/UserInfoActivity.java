package cn.edu.hebtu.software.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.OnClick;
import cn.edu.hebtu.software.R;

public class UserInfoActivity extends AppCompatActivity {
    private LinearLayout llUpdatePhone,llUpdateNickname,llUpdateAddress;
    private TextView tvMyId,tvPhone,tvNickname,tvAddress;
    private ImageView ivReturn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);

        llUpdatePhone = findViewById(R.id.ll_update_phone);
        llUpdateNickname = findViewById(R.id.ll_update_nickname);
        llUpdateAddress = findViewById(R.id.ll_update_address);
        tvMyId =findViewById(R.id.tv_myid);
        tvPhone = findViewById(R.id.tv_phone);
        tvNickname = findViewById(R.id.tv_nickname);
        tvAddress = findViewById(R.id.tv_address);
        ivReturn = findViewById(R.id.iv_return);
        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        SharedPreferences sp = getSharedPreferences("userInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        tvMyId.setText(sp.getString("uId",""));
        tvPhone.setText(sp.getString("uPhone",""));
        tvNickname.setText(sp.getString("uNickname",""));
        tvAddress.setText(sp.getString("uAddress",""));

        llUpdatePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        llUpdateNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        llUpdateAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
