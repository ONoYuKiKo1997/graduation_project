package cn.edu.hebtu.software.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
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
import java.util.Random;

import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.activity.DetailActivity;
import cn.edu.hebtu.software.bean.Dish;
import cn.edu.hebtu.software.util.MyCartApplication;
import cn.edu.hebtu.software.util.ShowDishImage;

import static android.content.Context.MODE_PRIVATE;

public class IndexAdapter extends BaseAdapter {

    private ListView mListView;
    private List<Dish> mList;
    private Context mContext;
    private MyCartApplication app;

    public IndexAdapter(ListView mListView, List<Dish> mList, Context mContext){
        this.mListView = mListView;
        this.mList = mList;
        this.mContext = mContext;
        this.app = (MyCartApplication)this.mContext.getApplicationContext();
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_index, null);
            holder.dImage = convertView.findViewById(R.id.iv_dish);
            holder.addToCart = convertView.findViewById(R.id.iv_add);
            holder.dName = convertView.findViewById(R.id.tv_dish_name);
            holder.dTaste = convertView.findViewById(R.id.tv_taste);
            holder.dHunSu = convertView.findViewById(R.id.tv_hunsu);
            holder.dPrice = convertView.findViewById(R.id.tv_price);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        final Dish dish = mList.get(position);
//        URL picUrl = null;
//        try {
//            picUrl = new URL(dish.getDImageUrl());
//            holder.dImage.setImageBitmap(BitmapFactory.decodeStream(picUrl.openStream()));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ShowDishImage s = new ShowDishImage(holder.dImage,serverUrl+"/"+dish.getDImageUrl());
        s.execute();

        holder.dName.setText(dish.getdName());
        holder.dTaste.setText(dish.getdKouWei());
        holder.dHunSu.setText(dish.getdHunSu());
        holder.dPrice.setText("￥ "+format.format(new BigDecimal(dish.getdPrice())));
        // 添加购物车
        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = mContext.getSharedPreferences("myCart", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                app.addDishCount(dish);
                Toast.makeText(mContext,"添加购物车成功!",Toast.LENGTH_SHORT).show();
            }
        });
        //点击每个item跳转到相应的详情页
        if(mListView!=null)
        {
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent();
                    intent.setClass(mContext, DetailActivity.class);
                    intent.putExtra("dId",mList.get(position).getdId());
                    intent.putExtra("dName",mList.get(position).getdName());
                    intent.putExtra("dHunSu",mList.get(position).getdHunSu());
                    intent.putExtra("dKouWei",mList.get(position).getdKouWei());
                    intent.putExtra("dPrice",mList.get(position).getdPrice());
                    intent.putExtra("dImageUrl",mList.get(position).getDImageUrl());
                    mContext.startActivity(intent);
                    Toast.makeText(mContext ,mList.get(position).getdName(),Toast.LENGTH_SHORT).show();
                }
            });
        }
        return convertView;
    }

    class Holder {
        ImageView dImage, addToCart;
        TextView dName, dTaste, dHunSu, dPrice;
    }
}
