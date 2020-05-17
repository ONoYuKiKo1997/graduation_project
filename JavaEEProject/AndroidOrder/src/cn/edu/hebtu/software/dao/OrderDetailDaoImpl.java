package cn.edu.hebtu.software.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cn.edu.hebtu.software.entity.OrderDetail;
import cn.edu.hebtu.software.entity.OrderTotal;
import cn.edu.hebtu.software.framework.BaseDao;

@Repository
public class OrderDetailDaoImpl extends BaseDao<OrderDetail, Integer>{
	
	// 添加一组订单详情列
		public boolean addOrderDetail(String orderDetail) {
			Gson gson = new Gson();
			List<OrderDetail> list = gson.fromJson(orderDetail, new TypeToken<List<OrderDetail>>(){}.getType());
			for (int i = 0; i < list.size(); i++) {
				try {
					OrderDetail orderDetail2 = list.get(i);
					this.save(orderDetail2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return true;
		}
		
		// 查询订单详情
		public List<OrderDetail> findOrderTotalByOId(String oId) {
			try {
				return super.findByProperty("from OrderDetail o where o.oId=?", new Object[]{oId});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;		
		}
}
