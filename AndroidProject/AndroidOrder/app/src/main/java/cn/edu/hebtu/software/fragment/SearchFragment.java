package cn.edu.hebtu.software.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.activity.DivideDetailActivity;
import cn.edu.hebtu.software.activity.SearchActivity;

public class SearchFragment extends Fragment{
    public Button btnHun,btnSu,btnZhu,btnJia,btnLa,btnTian,btnXian;
    public TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_divide,container,false);
        btnHun = view.findViewById(R.id.btn_hun);
        btnSu = view.findViewById(R.id.btn_su);
        btnZhu = view.findViewById(R.id.btn_zhu);
        btnJia = view.findViewById(R.id.btn_jia);
        btnLa = view.findViewById(R.id.btn_la);
        btnTian = view.findViewById(R.id.btn_tian);
        btnXian = view.findViewById(R.id.btn_xian);
        textView = view.findViewById(R.id.et_divide);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        btnHun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("type","荤菜");
                intent.setClass(getActivity(), DivideDetailActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(),"我被点击了",Toast.LENGTH_SHORT).show();
            }
        });

        btnSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("type","素菜");
                intent.setClass(getActivity(), DivideDetailActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(),"我被点击了",Toast.LENGTH_SHORT).show();
            }
        });

        btnZhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("type","主食");
                intent.setClass(getActivity(), DivideDetailActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(),"我被点击了",Toast.LENGTH_SHORT).show();
            }
        });

        btnJia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("type","家常味");
                intent.setClass(getActivity(), DivideDetailActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(),"我被点击了",Toast.LENGTH_SHORT).show();
            }
        });

        btnLa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("type","麻辣味");
                intent.setClass(getActivity(), DivideDetailActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(),"我被点击了",Toast.LENGTH_SHORT).show();
            }
        });

        btnTian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("type","酸甜味");
                intent.setClass(getActivity(), DivideDetailActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(),"我被点击了",Toast.LENGTH_SHORT).show();
            }
        });

        btnXian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("type","咸鲜味");
                intent.setClass(getActivity(), DivideDetailActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(),"我被点击了",Toast.LENGTH_SHORT).show();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),SearchActivity.class);
                startActivity(intent);
            }
        });

    }
}