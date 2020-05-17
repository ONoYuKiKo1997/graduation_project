package cn.edu.hebtu.software.activity;

import cn.edu.hebtu.software.fragment.*;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.util.MyCartApplication;


public class MainActivity extends AppCompatActivity {
    //创建一个列表，保存选项卡视图
    private List<View> viewList = new ArrayList<>();
    FragmentTabHost mfragmentTabHost;

    // tab图片
    private int mImages[] = {
            R.drawable.tab_first,
            R.drawable.tab_second,
            R.drawable.tab_third,
            R.drawable.tab_forth
    };

    // tab标题
    private String mFragmentTags[] = {"首页", "搜索", "购物车", "我的"};

    // tab页数组
    private Class[] fragmentArr = {BannerFragment.class,SearchFragment.class,CartFragment.class,MineFragment.class};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //该APP一启动就将要访问的服务器地址保存在getSharedPreferences，方便以后修改只修改这一个地方
        SharedPreferences sharedPreferences = getSharedPreferences("myServer", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("serverUrl","http://192.168.1.107:8080/AndroidOrder");
        editor.commit();

        //初始化FragmentTabHost
        initTabHost();

    }

    // 退出时
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 购物车保存到Sharedpreference
        SharedPreferences sp = getSharedPreferences("myCart", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        MyCartApplication app = (MyCartApplication)getApplication();
        List<HashMap<String, String>> goodsList = app.getCartList();
        Gson gson = new Gson();
        String cart = gson.toJson(goodsList);
        editor.putString("cartList",cart);
        editor.commit();
    }

    private void initTabHost(){

        mfragmentTabHost = findViewById(android.R.id.tabhost);
        // frag主体
        mfragmentTabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);
        mfragmentTabHost.getTabWidget().setDividerDrawable(null);

//        SharedPreferences sp=getSharedPreferences("userInfo", MODE_PRIVATE);
//        if(sp.getInt("userId",0)==0) {//若该用户没有登录
//            fragmentArr[2] =BannerActivity.class;
//            Toast.makeText(getApplicationContext(),"请先登录再发布任务！", Toast.LENGTH_SHORT).show();
//        }
        for(int i = 0 ; i < fragmentArr.length ; i++){
            // 添加标签
            TabHost.TabSpec tabSpec = mfragmentTabHost.newTabSpec(mFragmentTags[i]).setIndicator(getTabHostView(i));
            // 标签页详情
            mfragmentTabHost.addTab(tabSpec,fragmentArr[i],null);
        }

//        //给tabHost控件增加事件监听器
//        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
//            @Override
//            public void onTabChanged(String tabId) {
//                setTabHostIcon(tabId);
//            }
//        });
        //如果从“我的”Activity访问MainActivity，则显示我的选项卡（即在“我的”点击登录、退出登录依旧在“我的”选项卡
//        SharedPreferences sharedPreferences = getSharedPreferences("isFromMy",MODE_PRIVATE);
//        if(sharedPreferences.getBoolean("fromMy",false)){
//            mfragmentTabHost.setCurrentTabByTag("我的");
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.remove("fromMy");
//            editor.commit();
//        }
//        SharedPreferences sharedPreferences1=getSharedPreferences("isFromMy",MODE_PRIVATE);
//        if(sharedPreferences.getBoolean("isFromQuanZi",false)){
//            mfragmentTabHost.setCurrentTabByTag("圈子");
//            SharedPreferences.Editor editor=sharedPreferences1.edit();
//            editor.remove("isFromQuanZi");
//            editor.commit();
//        }
    }

    private View getTabHostView(int index){
        View view = getLayoutInflater().inflate(R.layout.fragment_tabs,null);
        TextView textView = view.findViewById(R.id.tab_tv_text);
        ImageView imageView = view.findViewById(R.id.tab_iv_image);
        textView.setText(mFragmentTags[index]);
        imageView.setImageResource(mImages[index]);
        viewList.add(view);
        return view;
    }
}
