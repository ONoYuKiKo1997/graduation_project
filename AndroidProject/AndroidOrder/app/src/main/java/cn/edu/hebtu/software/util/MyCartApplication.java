package cn.edu.hebtu.software.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mob.MobSDK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import cn.edu.hebtu.software.bean.Dish;

public class MyCartApplication extends Application {
    private List<HashMap<String, String>> goodsList;

    public List<HashMap<String, String>> getCartList(){
        return goodsList;
    };

    @Override
    public void onCreate() { // 初始化
        super.onCreate();
        MobSDK.init(this,"2f24655e42ecf","a5597be8462a469de0402ae2a362be72");
        goodsList = new ArrayList<>();
        SharedPreferences sp = getSharedPreferences("myCart", MODE_PRIVATE);
        String cart = sp.getString("cartList","");
        if (!cart.isEmpty()){
            Gson gson = new Gson();
            goodsList = gson.fromJson(cart,new TypeToken<List<HashMap<String, String>>>(){}.getType());
        }
    }

    public boolean addDishCount(Dish dish) {
        if (goodsList.isEmpty()) { // 如果购物车空 直接添加
            HashMap<String, String> map = new HashMap<>();
            map.put("id", dish.getdId());
            map.put("name",dish.getdName());
            map.put("hunsu",dish.getdHunSu());
            map.put("kouwei",dish.getdKouWei());
            map.put("price",dish.getdPrice());
            map.put("img",dish.getDImageUrl());
            map.put("count", 1 + "");
            goodsList.add(map);
            return true;
        }else {// 不为空
            for (HashMap<String, String> map : goodsList){
                if (map.get("id").equals(dish.getdId())) { // 列表里有这件商品
                    String strCount = map.get("count");
                    int count = Integer.valueOf(strCount);
                    count++;
                    Log.e("数量变化：",map.get("name")+"的数量从"+map.get("count")+"变成了");
                    map.put("count", count+"");
                    Log.e("变化后",map.get("count"));
                    return true;
                }
            }
            // 循环了一遍发现没有
            HashMap<String, String> map = new HashMap<>();
            map.put("id", dish.getdId());
            map.put("name",dish.getdName());
            map.put("hunsu",dish.getdHunSu());
            map.put("kouwei",dish.getdKouWei());
            map.put("price",dish.getdPrice());
            map.put("img",dish.getDImageUrl());
            map.put("count", 1 + "");
            goodsList.add(map);
            return true;
        }
        //return false;
    }

}
