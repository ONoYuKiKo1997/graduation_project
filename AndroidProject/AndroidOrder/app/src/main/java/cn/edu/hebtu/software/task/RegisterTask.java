package cn.edu.hebtu.software.task;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import cn.edu.hebtu.software.activity.LoginActivity;

import static android.content.Context.MODE_PRIVATE;

public class RegisterTask extends AsyncTask {
    private Context context;
    private String petName;
    private String phone;
    private String password;

    public RegisterTask(Context context){
        this.context=context;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        petName=(String)objects[0];
        phone=(String)objects[1];
        password=(String)objects[2];
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("myServer", MODE_PRIVATE);
            String serverUrl = sharedPreferences.getString("serverUrl","");
            URL url=new URL(serverUrl+"/user/regist?petName="+petName+
                    "&phone="+phone+"&password="+password);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("contentType","UTF-8");
            InputStream is = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String res = reader.readLine();
            Gson gson = new Gson();
            // 获取id
            String id = gson.fromJson(res,int.class) + "";
            Log.e("注册id：",id);
            Intent intent=new Intent();
            intent.setClass(context,LoginActivity.class);
            context.startActivity(intent);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
