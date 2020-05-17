package cn.edu.hebtu.software.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.activity.CommentActivity;
import cn.edu.hebtu.software.activity.DetailActivity;
import cn.edu.hebtu.software.bean.Dish;
import cn.edu.hebtu.software.bean.OrderDetail;
import cn.edu.hebtu.software.task.FindDishById;
import cn.edu.hebtu.software.util.ShowDishImage;

import static android.content.Context.MODE_PRIVATE;

public class OrderDetailAdapter extends BaseAdapter {

    private ListView mListView;
    private List<OrderDetail> detailList;
    private Context mContext;

    public OrderDetailAdapter(ListView mListView, List<OrderDetail> detailList, Context mContext){
        this.mListView = mListView;
        this.detailList = detailList;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return detailList.size();
    }

    @Override
    public Object getItem(int position) {
        return detailList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        final SharedPreferences sharedPreferences = mContext.getSharedPreferences("myServer", MODE_PRIVATE);
        String serverUrl = sharedPreferences.getString("serverUrl","");
        DecimalFormat format = new DecimalFormat("0.00");
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_order, null);
            holder.dImage = convertView.findViewById(R.id.iv_dish);
            holder.dCount = convertView.findViewById(R.id.tv_count);
            holder.dName = convertView.findViewById(R.id.tv_dish_name);
            holder.dTaste = convertView.findViewById(R.id.tv_taste);
            holder.dHunSu = convertView.findViewById(R.id.tv_hunsu);
            holder.dPrice = convertView.findViewById(R.id.tv_price);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        final OrderDetail orderDetail = detailList.get(position);
        String dId = orderDetail.getdId();

        ShowDishImage s = new ShowDishImage(holder.dImage,serverUrl+"/"+"images/"+dId+".jpg");
        s.execute();

        holder.dName.setText(orderDetail.getdName());
        //holder.dTaste.setText(dish.getdKouWei());
        // holder.dHunSu.setText(dish.getdHunSu());
        holder.dTaste.setVisibility(View.INVISIBLE);
        holder.dHunSu.setVisibility(View.INVISIBLE);
        holder.dPrice.setText("￥ " + Double.valueOf(orderDetail.getdPrice()));
        holder.dCount.setText("x"+orderDetail.getdCount());


        //点击每个item跳转到相应的评价页
        if(mListView!=null)
        {
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent();
                    intent.setClass(mContext, CommentActivity.class);
                    intent.putExtra("dId",orderDetail.getdId());
                    intent.putExtra("dName",orderDetail.getdName());
                    SharedPreferences sharedPreferences1 = mContext.getSharedPreferences("userInfo",MODE_PRIVATE);
                    intent.putExtra("uId",sharedPreferences1.getString("uId",""));
                    intent.putExtra("uNickname",sharedPreferences1.getString("uNickname",""));

                    mContext.startActivity(intent);
                }
            });
        }
        return convertView;
    }

    class Holder {
        ImageView dImage;
        TextView dName, dTaste, dHunSu, dPrice, dCount;
    }
}
