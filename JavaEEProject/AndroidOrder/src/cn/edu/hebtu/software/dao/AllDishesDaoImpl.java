package cn.edu.hebtu.software.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.hebtu.software.entity.Dish;
import cn.edu.hebtu.software.framework.BaseDao;

@Repository
public class AllDishesDaoImpl extends BaseDao<Dish, Integer> {
	//查询所有菜品
	public List<Dish> findAllDishes(){
		try {	
			return super.findByProperty("from Dish d", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		
	// 分类获取
	public List<Dish> findDishesByType(String searchContent){
		try {
			switch (searchContent) {
				case "荤菜":
					return super.findByProperty("from Dish d where d.dHunSu=?", new Object[]{searchContent});
				case "素菜":
					return super.findByProperty("from Dish d where d.dHunSu=?", new Object[]{searchContent});
				case "主食":
					return super.findByProperty("from Dish d where d.dHunSu=?", new Object[]{searchContent});
				case "家常味":
					return super.findByProperty("from Dish d where d.dKouWei=?", new Object[]{searchContent});
				case "麻辣味":
					return super.findByProperty("from Dish d where d.dKouWei=?", new Object[]{searchContent});
				case "酸甜味":
					return super.findByProperty("from Dish d where d.dKouWei=?", new Object[]{searchContent});
				case "咸鲜味":
					return super.findByProperty("from Dish d where d.dKouWei=?", new Object[]{searchContent});
				default:
					return super.findByProperty("from Dish d where d.dName like '%'||?||'%'", new Object[]{searchContent});
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	
	public Dish findDishById(String dId) {
		Dish dish = null;
		try {
			dish = this.findOne("from Dish d where d.dId=?", new Object[] {dId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dish;
	}
	
}
