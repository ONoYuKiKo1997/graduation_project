package cn.edu.hebtu.software.dao;

import org.springframework.stereotype.Repository;

import cn.edu.hebtu.software.entity.User;

import cn.edu.hebtu.software.framework.BaseDao;

@Repository
public class UserDaoImpl extends BaseDao<User, Integer>{
	
	public User findByPhoneAndPwd(String phone,String pwd) {
		User user = null;
		try {
			user = this.findOne("from User u where u.uPhone=? and u.uPassword=?", new Object[]{phone,pwd});
			System.out.println("UserDaoImpl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;		
	}
	
	public int addUser(User user) {
		try {
			this.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer id = Integer.valueOf(user.getuId());
		System.out.println("娉ㄥ唽锛屾彃鍏ヤ竴涓猽ser锛岃繑鍥瀠serId" + id);
		return id;
	}
	
	public User findPhone(String phone) {
		User user = null;
		try {
			user = this.findOne("from User u where u.uPhone=?",new Object[] {phone});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	public int updatePhoneByUid(String uid, String phone) {
		String sql = "update user set u_phone =? where u_id=?";
		int bySql=0;
		try {
			bySql = this.excuteBySql(sql, new Object[] {phone,Integer.parseInt(uid)});
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bySql;
		
	}

	public int updatePasswordByPhone(String phone, String password) {
		String sql = "update user set u_password =? where u_phone=?";
		int bySql=0;
		try {
			bySql = this.excuteBySql(sql, new Object[] {password,phone});
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bySql;
	}
}
