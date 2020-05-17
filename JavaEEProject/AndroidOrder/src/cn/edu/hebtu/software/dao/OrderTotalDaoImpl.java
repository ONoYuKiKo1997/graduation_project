package cn.edu.hebtu.software.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.hebtu.software.entity.Dish;
import cn.edu.hebtu.software.entity.OrderTotal;
import cn.edu.hebtu.software.entity.User;
import cn.edu.hebtu.software.framework.BaseDao;

@Repository
public class OrderTotalDaoImpl extends BaseDao<OrderTotal, Integer> {

	// 添加一个订单
	public boolean addOrder(OrderTotal orderTotal) {
		try {
			this.save(orderTotal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Integer id = Integer.valueOf(orderTotal.getoId());
//		System.out.println("orderID:" + id);
		return true;
	}
	
	// 查询订单
	public List<OrderTotal> findOrderTotalByUId(String uId) {
		try {
			return super.findByProperty("from OrderTotal o where o.uId=?", new Object[]{uId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
}
