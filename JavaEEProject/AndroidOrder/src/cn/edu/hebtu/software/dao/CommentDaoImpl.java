package cn.edu.hebtu.software.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.hebtu.software.entity.Comment;
import cn.edu.hebtu.software.entity.User;
import cn.edu.hebtu.software.framework.BaseDao;

@Repository
public class CommentDaoImpl extends BaseDao<Comment, Integer>{
	// 提交
	public int addComment(Comment comment) {
		try {
			this.save(comment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	
	// 浏览
	public List<Comment> read(Integer dId) {
		
		try {
			return super.findByProperty("from Comment c where c.dId=?",new Object[]{dId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
