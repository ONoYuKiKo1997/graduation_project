package cn.edu.hebtu.software.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import cn.edu.hebtu.software.entity.Dish;
import cn.edu.hebtu.software.service.AllDishesServiceImpl;

@Controller

public class AllDishesController {
	@Resource
	private AllDishesServiceImpl allDishesServiceImpl;
	
	// 所有菜品
	@RequestMapping(value = "alldishtask" , produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String allDishes(Model model) {
		List<Dish> list=allDishesServiceImpl.allDishesTask();
		System.out.println(list);
		//Collections.reverse(list);
		
		model.addAttribute("AllDishesTask",list);
		Gson gson = new Gson();
		String temp=gson.toJson(list);
		System.out.println(list);
		return temp;
	}
	
	// 分类及搜索
	@RequestMapping(value = "dividedishtask" , produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String divideDishes(Model model,@RequestParam("searchContent")String searchContent) {
		List<Dish> list=allDishesServiceImpl.divideDishesTask(searchContent);
		System.out.println(list);
		//Collections.reverse(list);
		model.addAttribute("DivideDishesTask",list);
		Gson gson = new Gson();
		String temp=gson.toJson(list);
		System.out.println(list);
		return temp;
	}

	@RequestMapping(value = "findDish" , produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String findDishById(@RequestParam("dId")String dId) {
		Dish dish  = allDishesServiceImpl.findDishById(dId);
		Gson gson = new Gson();
		String temp=gson.toJson(dish);
		return temp;
	}

}
