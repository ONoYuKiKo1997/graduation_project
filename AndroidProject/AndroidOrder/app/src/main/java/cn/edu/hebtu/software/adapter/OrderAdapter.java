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
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.activity.DetailActivity;
import cn.edu.hebtu.software.bean.Dish;
import cn.edu.hebtu.software.util.MyCartApplication;
import cn.edu.hebtu.software.util.ShowDishImage;

import static android.content.Context.MODE_PRIVATE;

public class OrderAdapter extends BaseAdapter {
    private ListView mListView;
    private List<HashMap<String, String>> sureList;
    private Context mContext;

    public OrderAdapter(ListView mListView, List<HashMap<String, String>> sureList, Context mContext){
        this.mListView = mListView;
        this.sureList = sureList;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return sureList.size();
    }

    @Override
    public Object getItem(int position) {
        return sureList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("myServer", MODE_PRIVATE);
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
        HashMap<String, String> map = sureList.get(position);

        ShowDishImage s = new ShowDishImage(holder.dImage,serverUrl+"/"+map.get("img"));
        s.execute();

        holder.dName.setText(map.get("name"));
        holder.dTaste.setText(map.get("kouwei"));
        holder.dHunSu.setText(map.get("hunsu"));
        holder.dPrice.setText("￥ " + Double.valueOf(map.get("price")));
        holder.dCount.setText("x"+map.get("count"));
//        //点击每个item跳转到相应的详情页
//        if(mListView!=null)
//        {
//            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Intent intent = new Intent();
//                    intent.setClass(mContext, DetailActivity.class);
//                    intent.putExtra("dId",mList.get(position).getdId());
//                    intent.putExtra("dName",mList.get(position).getdName());
//                    intent.putExtra("dHunSu",mList.get(position).getdHunSu());
//                    intent.putExtra("dKouWei",mList.get(position).getdKouWei());
//                    intent.putExtra("dPrice",mList.get(position).getdPrice());
//                    intent.putExtra("dImageUrl",mList.get(position).getDImageUrl());
//                    mContext.startActivity(intent);
//                    Toast.makeText(mContext ,mList.get(position).getdName(),Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
        return convertView;
    }

    class Holder {
        ImageView dImage;
        TextView dName, dTaste, dHunSu, dPrice, dCount;
    }
}
