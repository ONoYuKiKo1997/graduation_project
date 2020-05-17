package cn.edu.hebtu.software.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.hebtu.software.entity.User;

import cn.edu.hebtu.software.dao.UserDaoImpl;

@Service
public class UserServiceImpl {
	
	@Resource
	private UserDaoImpl userDaoImpl;
	
	public User login(String phoneNum, String upwd) {
		return userDaoImpl.findByPhoneAndPwd(phoneNum, upwd);
	}
	
	public int regist(String petName, String phone, String password) {
		User user = new User("", petName, phone, "", "", password);
		return userDaoImpl.addUser(user);
	}
	
	public User findPhone(String phone) {
		return userDaoImpl.findPhone(phone);
	}

	public int updatePhoneByUid(String uid, String phone) {
		return userDaoImpl.updatePhoneByUid(uid,phone);
		
	}

	public int updatePasswordByPhone(String phone, String password) {
		// TODO Auto-generated method stub
		return userDaoImpl.updatePasswordByPhone(phone,password);
	}

}
