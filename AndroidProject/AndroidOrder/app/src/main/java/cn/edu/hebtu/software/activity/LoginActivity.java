package cn.edu.hebtu.software.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.task.FindPhoneTask;
import cn.edu.hebtu.software.task.LoginTask;

public class LoginActivity extends AppCompatActivity {
    private EditText etPhone, etPWD;
    private CheckBox cbRemPWD;
    private Button btnLogin;
    private ImageView ivReturn;
    private TextView tvForgetPWD, tvRegist, tvError;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        super.onCreate(savedInstanceState);

        ivReturn = findViewById(R.id.iv_return);
        etPhone = findViewById(R.id.et_login_phone_number);
        etPWD = findViewById(R.id.et_login_password);
        cbRemPWD = findViewById(R.id.cb_remember_password);
        btnLogin = findViewById(R.id.btn_login);
        tvForgetPWD = findViewById(R.id.tv_forget_password);
        tvRegist = findViewById(R.id.tv_register);
        tvError = findViewById(R.id.tv_error);

        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



        //若上次用户选择了记住密码，则在相应位置显示手机号和密码
        SharedPreferences sp = getSharedPreferences("userInfo", MODE_PRIVATE);
        boolean isRememberPwd = sp.getBoolean("isRemPWD",false);
        if(isRememberPwd){
            etPhone.setText(sp.getString("uPhone",""));
            Log.e("打印",sp.getString("uPhone",""));
            etPWD.setText(sp.getString("uPWD",""));
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        tvForgetPWD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etPhoneNum = findViewById(R.id.et_login_phone_number);
                String phone = etPhoneNum.getText().toString();

                if(phone==null || phone.equals("")){
                    tvError.setText("请填入电话号码");
                }else{//启动一个异步任务，判断该手机号是否已注册，若注册，则转到发送验证码界面，若没注册，提醒用户该号码尚未注册
                    FindPhoneTask findPhoneTask = new FindPhoneTask(getApplication(),tvError);
                    findPhoneTask.execute(phone);
                }
            }
        });

        tvRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login(){
        String phoneNum = etPhone.getText().toString();
        String password = etPWD.getText().toString();

        if(phoneNum==null || password==null || phoneNum.equals("") || password.equals("")){
            tvError.setText("用户名或密码不能为空");
        }else{
            LoginTask loginTask = new LoginTask(tvError,getApplication(),cbRemPWD);
            loginTask.execute(phoneNum,password);
        }
    }

    // 重写返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //点击完返回键，执行的动作
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        return true;
    }
}
