package cn.edu.hebtu.software.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.hebtu.software.dao.OrderDetailDaoImpl;
import cn.edu.hebtu.software.dao.OrderTotalDaoImpl;
import cn.edu.hebtu.software.entity.OrderDetail;
import cn.edu.hebtu.software.entity.OrderTotal;

@Service
public class OrderDetailServiceImpl {
	@Resource
	private OrderDetailDaoImpl orderDetailDaoImpl;
	
	public List<OrderDetail> findDetailOrder(String oId) {
		return this.orderDetailDaoImpl.findOrderTotalByOId(oId);
	}
	
	public boolean addOrderTotal(String orderDetail) {
		return this.orderDetailDaoImpl.addOrderDetail(orderDetail);
	}
}
