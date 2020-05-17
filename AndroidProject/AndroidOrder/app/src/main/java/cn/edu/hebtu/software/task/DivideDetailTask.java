package cn.edu.hebtu.software.task;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.adapter.IndexAdapter;
import cn.edu.hebtu.software.bean.Dish;

import static android.content.Context.MODE_PRIVATE;

public class DivideDetailTask extends AsyncTask<String, Void, List<Dish>> {
    private String searchContent;
    private Context mContext;
    private ListView mListView;
    private Gson gson;

    public DivideDetailTask(Context mContext, ListView mListView){
        this.mContext = mContext;
        this.mListView = mListView;
    }

    @Override
    protected List<Dish> doInBackground(String... strings) {
        List<Dish> dishesList = new ArrayList<>();
        searchContent= strings[0];
        //通过网络访问服务器端实现获取分类列表
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences("myServer", MODE_PRIVATE);
            String serverUrl = sharedPreferences.getString("serverUrl","");
            // 传入搜索关键字
            URL url=new URL(serverUrl+"/dividedishtask?searchContent="+searchContent);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            //传入的参数中有中文字符，防止乱码出现
            connection.setRequestProperty("contentType","utf-8");
            //获取输入流
            InputStream in=connection.getInputStream();
            //字节流转换为字符流
            InputStreamReader inputStreamReader=new InputStreamReader(in);//转换流
            BufferedReader reader=new BufferedReader(inputStreamReader);
            String res=reader.readLine();
            gson = new Gson();
            dishesList = gson.fromJson(res,new TypeToken<List<Dish>>(){}.getType());
            //Log.e("数据",dishesList.get(0).getdName());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dishesList;
    }

    @Override
    protected void onPostExecute(List<Dish> dishes) {
        if(dishes!=null && dishes.size()!=0){
            IndexAdapter adapter=new IndexAdapter(mListView, dishes, mContext);
            mListView.setAdapter(adapter);
        }else{
            Toast.makeText(mContext,"数据加载失败", Toast.LENGTH_SHORT).show();
        }
    }
}
