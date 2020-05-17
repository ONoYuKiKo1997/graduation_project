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

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.activity.CommentActivity;
import cn.edu.hebtu.software.bean.Comment;
import cn.edu.hebtu.software.bean.OrderDetail;
import cn.edu.hebtu.software.util.ShowDishImage;

import static android.content.Context.MODE_PRIVATE;

public class CommentAdapter extends BaseAdapter {
    private List<Comment> commentList;
    private Context mContext;

    public CommentAdapter(List<Comment> commentList, Context mContext){
        this.commentList = commentList;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return commentList.size();
    }

    @Override
    public Object getItem(int position) {
        return commentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_comment, null);
            holder.uName = convertView.findViewById(R.id.uName);
            holder.cDate = convertView.findViewById(R.id.cDate);
            holder.cContent = convertView.findViewById(R.id.tv_comment);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        final Comment comment = commentList.get(position);

        holder.uName.setText(comment.getuNickName());
        holder.cDate.setText(comment.getcDate());
        holder.cContent.setText(comment.getcContent());

        return convertView;
    }

    class Holder {
        TextView uName, cDate, cContent;
    }
}
