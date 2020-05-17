package cn.edu.hebtu.software.task;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.ListView;
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

import cn.edu.hebtu.software.adapter.OrderDetailAdapter;
import cn.edu.hebtu.software.adapter.TotalOrderAdapter;
import cn.edu.hebtu.software.bean.OrderDetail;
import cn.edu.hebtu.software.bean.OrderTotal;

import static android.content.Context.MODE_PRIVATE;

public class GetOrderDetailTask extends AsyncTask<String,Integer,List<OrderDetail>> {
    private Context mContext;
    private ListView mListView;
    private Gson gson;

    public GetOrderDetailTask(Context mContext, ListView mListView) {
        this.mContext = mContext;
        this.mListView = mListView;
    }
    @Override
    protected List<OrderDetail> doInBackground(String... strings) {
        List<OrderDetail> list = new ArrayList<>();
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences("myServer", MODE_PRIVATE);
            String serverUrl = sharedPreferences.getString("serverUrl", "");
            URL url = new URL(serverUrl + "/order/orderDetail?oId=" + strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //传入的参数中有中文字符，防止乱码出现
            connection.setRequestProperty("contentType", "utf-8");
            //获取输入流
            InputStream in = connection.getInputStream();
            //字节流转换为字符流
            InputStreamReader inputStreamReader = new InputStreamReader(in);//转换流
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String res = reader.readLine();
            gson = new Gson();
            list = gson.fromJson(res, new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void onPostExecute(List<OrderDetail> orderDetails) {
        if(orderDetails!=null && orderDetails.size()!=0){
            OrderDetailAdapter adapter=new OrderDetailAdapter(mListView, orderDetails, mContext);
            mListView.setAdapter(adapter);
        }else{
            Toast.makeText(mContext,"数据加载失败", Toast.LENGTH_SHORT).show();
        }
    }
}
