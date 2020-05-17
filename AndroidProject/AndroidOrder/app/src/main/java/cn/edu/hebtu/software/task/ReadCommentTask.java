package cn.edu.hebtu.software.task;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import cn.edu.hebtu.software.adapter.CommentAdapter;
import cn.edu.hebtu.software.bean.Comment;
import cn.edu.hebtu.software.bean.Dish;

import static android.content.Context.MODE_PRIVATE;

public class ReadCommentTask extends AsyncTask<Integer,Integer,List<Comment>> {

    private Context mContext;
    private ListView mListView;
    public ReadCommentTask(Context mContext, ListView mListView){
        this.mContext = mContext;
        this.mListView = mListView;
    };
    @Override
    protected List<Comment> doInBackground(Integer... integers) {
        URL url = null;
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences("myServer", MODE_PRIVATE);
            String serverUrl = sharedPreferences.getString("serverUrl","");
            String urlStr = serverUrl+"/comment/read?dId="+ integers[0];
            Log.e("测试",urlStr);
            url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("contentType","UTF-8");//如果给服务器端传的字符有中文，防止字符乱码问题
            InputStream is = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is);//转换流
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String res = reader.readLine();
            Gson gson = new Gson();
            List<Comment> list = gson.fromJson(res,new TypeToken<List<Comment>>(){}.getType());
            return list;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Comment> comments) {
        super.onPostExecute(comments);
        CommentAdapter adapter = new CommentAdapter(comments, mContext);
        mListView.setAdapter(adapter);
    }
}
