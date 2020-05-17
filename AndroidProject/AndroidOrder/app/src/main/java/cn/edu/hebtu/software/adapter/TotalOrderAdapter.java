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

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.activity.MyOrderDetailAcivity;
import cn.edu.hebtu.software.bean.OrderTotal;
import cn.edu.hebtu.software.util.ShowDishImage;

import static android.content.Context.MODE_PRIVATE;

public class TotalOrderAdapter extends BaseAdapter {
    private ListView mListView;
    private List<OrderTotal> list;
    private Context mContext;

    public TotalOrderAdapter(ListView mListView, List<OrderTotal> list, Context mContext){
        this.mListView = mListView;
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.order_total_item, null);
            holder.date = convertView.findViewById(R.id.tv_date);
            holder.oId = convertView.findViewById(R.id.o_id);
            holder.oTotal = convertView.findViewById(R.id.tv_total_price);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        OrderTotal orderTotal = list.get(position);

        holder.date.setText(
                orderTotal.getoId().substring(0, 4)+"年"
                +orderTotal.getoId().substring(4,6)+"月"
                +orderTotal.getoId().substring(6,8)+"日"
        );

        holder.oId.setText(orderTotal.getoId());
        holder.oTotal.setText("总价格：￥"+orderTotal.getoTotal());

        //点击每个item跳转到相应的详情页
        if(mListView!=null)
        {
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent();
                    intent.setClass(mContext, MyOrderDetailAcivity.class);
                    OrderTotal orderTotal1 = list.get(position);
                    intent.putExtra("oId",orderTotal1.getoId());
                    mContext.startActivity(intent);
                }
            });
        }
        return convertView;
    }

    class Holder {
        TextView date, oId, oTotal;
    }
}
