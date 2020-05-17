package cn.edu.hebtu.software.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.hebtu.software.dao.CommentDaoImpl;
import cn.edu.hebtu.software.dao.UserDaoImpl;
import cn.edu.hebtu.software.entity.Comment;
import cn.edu.hebtu.software.entity.User;

@Service
public class CommentServiceImpl {
	
	@Resource
	private CommentDaoImpl commentDaoImpl;
	
	public int addComment(Comment comment) {
		return commentDaoImpl.addComment(comment);
	}
	
	public List<Comment> read(Integer dId) {
		return commentDaoImpl.read(dId);
	}

}
