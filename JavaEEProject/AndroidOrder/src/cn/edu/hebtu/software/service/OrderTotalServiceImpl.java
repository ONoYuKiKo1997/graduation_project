package cn.edu.hebtu.software.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hebtu.software.dao.OrderTotalDaoImpl;
import cn.edu.hebtu.software.dao.UserDaoImpl;
import cn.edu.hebtu.software.entity.OrderTotal;

@Service
public class OrderTotalServiceImpl {
	@Resource
	private OrderTotalDaoImpl orderTotalDaoImpl;
	
	public List<OrderTotal> findTotalOrder(String uId) {
		return this.orderTotalDaoImpl.findOrderTotalByUId(uId);
	}
	
	public boolean addOrderTotal(OrderTotal orderTotal) {
		return this.orderTotalDaoImpl.addOrder(orderTotal);
	}
}
