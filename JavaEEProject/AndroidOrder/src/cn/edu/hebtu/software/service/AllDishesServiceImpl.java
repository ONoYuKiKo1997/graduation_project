package cn.edu.hebtu.software.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.edu.hebtu.software.dao.AllDishesDaoImpl;
import cn.edu.hebtu.software.entity.Dish;

@Service
@Transactional(readOnly=true)
public class AllDishesServiceImpl {
	@Resource
	private AllDishesDaoImpl allDishesDaoImpl;
	
	public List<Dish> allDishesTask(){
		return this.allDishesDaoImpl.findAllDishes();
	}
	
	public List<Dish> divideDishesTask(String searchContent) {
		return this.allDishesDaoImpl.findDishesByType(searchContent);
	}
	
	public Dish findDishById(String dId){
		return this.allDishesDaoImpl.findDishById(dId);
	}
		
}
