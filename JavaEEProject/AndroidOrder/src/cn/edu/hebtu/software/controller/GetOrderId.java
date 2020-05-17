package cn.edu.hebtu.software.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class GetOrderId {
	
	@RequestMapping("/getOrderId")
	@ResponseBody
	public String getOrderId() {
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");//可以方便地修改日期格式
		String hehe = dateFormat.format(now); 
		System.out.println(hehe);
		return hehe;
	}
}
