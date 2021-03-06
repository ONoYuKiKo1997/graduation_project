package cn.edu.hebtu.software.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.edu.hebtu.software.activity.LoginActivity;
import cn.edu.hebtu.software.adapter.LoopViewAdapter;
import cn.edu.hebtu.software.PagerOnClickListener;
import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.task.AllDishTask;

public class BannerFragment extends Fragment{

        private ViewPager viewPager;  //轮播图模块
        private int[] mImg;
        private int[] mImg_id;
        private String[] mDec;
        private ArrayList<ImageView> mImgList;
        private LinearLayout ll_dots_container;
        private TextView loop_dec,linshi;
        private int previousSelectedPosition = 0;
        // 下方菜品展示
        private ListView listView;
        boolean isRunning = false;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_banner, container, false);
            viewPager = view.findViewById(R.id.loopviewpager);
            ll_dots_container = view.findViewById(R.id.ll_dots_loop);
            //loop_dec = (TextView)findViewById(R.id.loop_dec);
            listView = view.findViewById(R.id.lv_index);
            linshi = view.findViewById(R.id.tv_linshi);
            linshi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            });
            AllDishTask allDishTask = new AllDishTask(getActivity(),listView);
            allDishTask.execute();

            return view;

        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            // 图片资源id数组
            mImg = new int[]{
                    R.drawable.test3,
                    R.drawable.test3,
                    R.drawable.test3,
                    R.drawable.test3,
                    R.drawable.test3
            };

            // 文本描述
            mDec = new String[]{
                    "Test1",
                    "Test2",
                    "Test3",
                    "Test4",
                    "Test5"
            };

            mImg_id = new int[]{
                    R.id.pager_img1,
                    R.id.pager_img2,
                    R.id.pager_img3,
                    R.id.pager_img4,
                    R.id.pager_img5
            };

            // 初始化要展示的5个ImageView
            mImgList = new ArrayList<ImageView>();
            ImageView imageView;
            View dotView;
            LinearLayout.LayoutParams layoutParams;
            for(int i=0;i<mImg.length;i++){
                //初始化要显示的图片对象
                imageView = new ImageView(getActivity());
                imageView.setBackgroundResource(mImg[i]);
                imageView.setId(mImg_id[i]);
                imageView.setOnClickListener(new PagerOnClickListener(getActivity().getApplicationContext()));
                mImgList.add(imageView);
                //加引导点
                dotView = new View(getActivity());
                dotView.setBackgroundResource(R.drawable.dot);
                layoutParams = new LinearLayout.LayoutParams(10,10);
                if(i!=0){
                    layoutParams.leftMargin=10;
                }
                //设置默认所有都不可用
                dotView.setEnabled(false);
                ll_dots_container.addView(dotView,layoutParams);
            }

            ll_dots_container.getChildAt(0).setEnabled(true);
//        loop_dec.setText(mDec[0]);
            previousSelectedPosition=0;
            //设置适配器
            viewPager.setAdapter(new LoopViewAdapter(mImgList));
            // 把ViewPager设置为默认选中Integer.MAX_VALUE / t2，从十几亿次开始轮播图片，达到无限循环目的;
            int m = (Integer.MAX_VALUE / 2) %mImgList.size();
            int currentPosition = Integer.MAX_VALUE / 2 - m;
            viewPager.setCurrentItem(currentPosition);

            viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {
                    int newPosition = i % mImgList.size();
                    //loop_dec.setText(mDec[newPosition]);
                    ll_dots_container.getChildAt(previousSelectedPosition).setEnabled(false);
                    ll_dots_container.getChildAt(newPosition).setEnabled(true);
                    previousSelectedPosition = newPosition;
                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });

            // 开启轮询
            new Thread(){
                public void run(){
                    isRunning = true;
                    while(isRunning){
                        try{
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //下一条
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                            }
                        });
                    }
                }
            }.start();
        }
}
