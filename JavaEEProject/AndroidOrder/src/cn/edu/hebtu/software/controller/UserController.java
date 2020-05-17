package cn.edu.hebtu.software.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.edu.hebtu.software.entity.User;
import cn.edu.hebtu.software.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestParam("phoneNum") String phoneNum,
			@RequestParam("password") String pwd,HttpSession session){
		
		System.out.println("loginController");
		User user = this.userServiceImpl.login(phoneNum, pwd);
		
		Gson gson = new Gson();
		String json = gson.toJson(user);
		System.out.println("鐧诲綍" + json);
		
		return json;
	}
	
	@RequestMapping("/regist")
	@ResponseBody
	public String regist(@RequestParam("petName") String petName,
			@RequestParam("phone") String phone,@RequestParam("password") String password) {
		int userId = this.userServiceImpl.regist(petName,phone,password);
		
		Gson gson = new Gson();
		String json = gson.toJson(userId);
		
		return json;		
	}
	
	@RequestMapping("/findPhone")
	@ResponseBody
	public String findPhone(@RequestParam("phone") String phone) {
		User u = this.userServiceImpl.findPhone(phone);
		
		Gson gson = new Gson();
		String json = gson.toJson(u);
		System.out.println("鏄惁鏈夎鎵嬫満鍙�"+json);
		return json;
	}
	
	@RequestMapping("/updatePhoneByUid")
	@ResponseBody
	public String updatePhoneByUid(@RequestParam("uid") String uid,@RequestParam("phone") String phone) {
		int updatePhoneByUid = this.userServiceImpl.updatePhoneByUid(uid,phone);
		Gson gson = new Gson();
		String json = gson.toJson(updatePhoneByUid);
		return json;
	}
	
	@RequestMapping("/updatePasswordByPhone")
	@ResponseBody
	public String updatePasswordByPhone(@RequestParam("phone") String phone,@RequestParam("password") String password) {
		int updatePasswordByPhone = this.userServiceImpl.updatePasswordByPhone(phone, password);
		Gson gson = new Gson();
		String json = gson.toJson(updatePasswordByPhone);
		return json;
	}
	
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
