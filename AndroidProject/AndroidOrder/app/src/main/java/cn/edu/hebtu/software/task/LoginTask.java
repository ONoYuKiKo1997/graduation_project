package cn.edu.hebtu.software.task;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import cn.edu.hebtu.software.activity.MainActivity;
import cn.edu.hebtu.software.bean.User;

import static android.content.Context.MODE_PRIVATE;

public class LoginTask extends AsyncTask<String,Object,User> {
    private TextView tvError;
    private Context mContext;
    private CheckBox cbRemPWD;

    private String phoneNum;
    private String password;


    public LoginTask(TextView tvError,Context mContext,CheckBox cbRemPWD){
        this.mContext = mContext;
        this.tvError = tvError;
        this.cbRemPWD = cbRemPWD;
    }
    @Override
    protected User doInBackground(String... strings) {
        User user = null;
        phoneNum = strings[0];
        password = strings[1];
        Boolean isLoginSuccessful = false;
        //通过网络访问服务器端登录功能
        URL url = null;
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences("myServer", MODE_PRIVATE);
            String serverUrl = sharedPreferences.getString("serverUrl","");
            String urlStr = serverUrl+"/user/login?phoneNum="+phoneNum+"&password="+password;
            url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("contentType","UTF-8");//如果给服务器端传的字符有中文，防止字符乱码问题
            InputStream is = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is);//转换流
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String res = reader.readLine();

            Gson gson = new Gson();
            user = gson.fromJson(res,User.class);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    protected void onPostExecute(User user) {
        if(user!=null) {//登录成功
            // 创建一个新的SharedPreferences
            SharedPreferences sharedPreferences = mContext.getSharedPreferences("userInfo", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isRemPWD",cbRemPWD.isChecked());//保存该用户是否勾选记住密码，true表示记住密码，false表示不记住密码
            String uPWD = "";
            String uId = "";


            uPWD = user.getuPassword();
            uId = user.getuId();
            editor.putString("uId",uId);
            editor.putString("uPhone",user.getuPhone());
            editor.putString("uAddress",user.getuAddress());
            editor.putString("uNickname",user.getuNickname());
            // 获取头像全地址
            SharedPreferences sp = mContext.getSharedPreferences("myServer", MODE_PRIVATE);
            editor.putString("uImageUrl",sp.getString("serverUrl","")+user.getuImageUrl());
            editor.putString("uPWD",uPWD);
            // 保存
            editor.commit();



            Intent intent = new Intent(mContext,MainActivity.class);
            mContext.startActivity(intent);
        }
    }
}
