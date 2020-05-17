package cn.edu.hebtu.software.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.activity.AboutHelpActivity;
import cn.edu.hebtu.software.activity.ChangePwdActivity;
import cn.edu.hebtu.software.activity.LoginActivity;
import cn.edu.hebtu.software.activity.MainActivity;
import cn.edu.hebtu.software.activity.MyOrderActivity;
import cn.edu.hebtu.software.activity.UserInfoActivity;
import cn.edu.hebtu.software.util.ShowDishImage;

public class MineFragment extends Fragment {
    private SharedPreferences sp;
    private ImageView imageView; // 暂不获取
    private TextView uNickname, uAddress;
    LinearLayout llUserInfo, llMyOrder, llUpdatePWD,llAboutHelp, llLogOff;
    //当创建View时调用
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine,container,false);
        uNickname = view.findViewById(R.id.tv_u_nickname);
        uAddress = view.findViewById(R.id.tv_u_address);
        imageView = view.findViewById(R.id.iv_u_head);
        llUserInfo = view.findViewById(R.id.ll_user_info);
        llMyOrder = view.findViewById(R.id.ll_my_order);
        llUpdatePWD = view.findViewById(R.id.ll_update_password);
        llAboutHelp = view.findViewById(R.id.ll_about_help);
        llLogOff = view.findViewById(R.id.ll_log_off);

        sp = getContext().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        if(sp.getString("uId","")==null||
                sp.getString("uId","").isEmpty()){//若该用户未登录，跳转
            Intent intent = new Intent();
            intent.setClass(getContext(), LoginActivity.class);
            startActivity(intent);
        }
        return view;
    }
    //当View创建完成

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(!sp.getString("uId","").isEmpty()){//若该用户已登录，显示该用户的头像等相关信息


            String imgUrl = sp.getString("uImageUrl",null);
            if (imgUrl!=null){
                // 显示图像通用
                new ShowDishImage(imageView,imgUrl).execute();
            }

            uNickname.setText("欢迎："+sp.getString("uNickname",""));
            uAddress.setText("收货地址："+sp.getString("uAddress",""));
        }

        llUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), UserInfoActivity.class);
                startActivity(intent);
            }
        });

        llMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MyOrderActivity.class);
                startActivity(intent);
            }
        });

        llUpdatePWD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChangePwdActivity.class);
                startActivity(intent);
            }
        });

        llAboutHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AboutHelpActivity.class);
                startActivity(intent);
            }
        });

        llLogOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOff();
            }
        });
    }

    public void logOff(){
        String userId = sp.getString("uId","");
        if(!userId.isEmpty()) {//如果用户已经登录，退出登录，删除相关用户信息，跳到首页
            SharedPreferences.Editor editor = sp.edit();
            editor.remove("uId");
            editor.remove("uNickname");
            editor.remove("uAddress");
//                    editor.remove("uImage");不删除头像信息，以便下次登录时显示用户上次的头像
            //如果该次登录时勾选了记住密码，则不删除手机号和密码信息，用于下次登录显示在界面上
            if (sp.getBoolean("isRemPWD", false) == false) {//没有记住密码则删除相关信息
                editor.remove("uPhone");
                editor.remove("uPWD");
//                        editor.remove("isRememberPwd");
            }
            editor.commit();
            Intent intent=new Intent(getContext(),MainActivity.class);
            startActivity(intent);
        }
    }
}
