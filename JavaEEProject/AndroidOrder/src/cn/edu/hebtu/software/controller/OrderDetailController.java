package cn.edu.hebtu.software.controller;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cn.edu.hebtu.software.entity.OrderDetail;
import cn.edu.hebtu.software.entity.OrderTotal;
import cn.edu.hebtu.software.service.OrderDetailServiceImpl;
import cn.edu.hebtu.software.service.OrderTotalServiceImpl;

@Controller
@RequestMapping("/order")
public class OrderDetailController {
	@Resource
	private OrderDetailServiceImpl orderDetailServiceImpl;
	
	@RequestMapping("/orderDetail")
	@ResponseBody
	public String orderDetail(Model model,@RequestParam("oId")String oId) {
		List<OrderDetail> list = orderDetailServiceImpl.findDetailOrder(oId);
		System.out.println(list);
		//Collections.reverse(list);
		model.addAttribute("orderDetail",list);
		Gson gson = new Gson();
		String temp=gson.toJson(list);
		System.out.println(list);
		return temp;
	}
	
	@RequestMapping("/addOrderDetail")
	@ResponseBody
	public boolean addOrderTotal(@RequestParam("data") String data) {
		return this.orderDetailServiceImpl.addOrderTotal(data);		
	}

}
