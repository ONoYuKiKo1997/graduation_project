package cn.edu.hebtu.software.task;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import static android.content.Context.MODE_PRIVATE;

public class SubmitComment extends AsyncTask<String,Integer,Boolean> {

    private Context mContext;
    public SubmitComment(Context mContext){
        this.mContext = mContext;
    };
    @Override
    protected Boolean doInBackground(String... strings) {
        URL url = null;
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences("myServer", MODE_PRIVATE);
            String serverUrl = sharedPreferences.getString("serverUrl","");
            String urlStr = serverUrl+"/comment/submit?comment="+ URLEncoder.encode(strings[0],"utf-8");
            Log.e("测试",urlStr);
            url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("contentType","UTF-8");//如果给服务器端传的字符有中文，防止字符乱码问题
            InputStream is = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is);//转换流
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String res = reader.readLine();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
