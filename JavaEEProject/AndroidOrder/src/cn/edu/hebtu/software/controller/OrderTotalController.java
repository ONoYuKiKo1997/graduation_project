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

import cn.edu.hebtu.software.entity.OrderTotal;

import cn.edu.hebtu.software.service.OrderTotalServiceImpl;

@Controller
@RequestMapping("/order")
public class OrderTotalController {
	@Resource
	private OrderTotalServiceImpl orderTotalServiceImpl;
	
	@RequestMapping("/allOrderTotal")
	@ResponseBody
	public String allOrderTotal(Model model,@RequestParam("uId")String uId) {
		List<OrderTotal> list = orderTotalServiceImpl.findTotalOrder(uId);
		System.out.println(list);
		Collections.reverse(list);
		model.addAttribute("orderTotal",list);
		Gson gson = new Gson();
		String temp=gson.toJson(list);
		System.out.println(list);
		return temp;
	}
	
	@RequestMapping("/addOrderTotal")
	@ResponseBody
	public boolean addOrderTotal(@RequestParam("data") String data) {
		Gson gson = new Gson();
		OrderTotal orderTotal = gson.fromJson(data,OrderTotal.class);
		return this.orderTotalServiceImpl.addOrderTotal(orderTotal);		
	}

}
