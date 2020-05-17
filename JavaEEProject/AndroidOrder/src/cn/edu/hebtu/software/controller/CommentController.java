package cn.edu.hebtu.software.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.FacesRequestAttributes;

import com.google.gson.Gson;

import cn.edu.hebtu.software.entity.Comment;
import cn.edu.hebtu.software.service.CommentServiceImpl;
import cn.edu.hebtu.software.service.UserServiceImpl;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Resource
	private CommentServiceImpl commentServiceImpl;
	
	@RequestMapping("/submit")
	@ResponseBody
	public boolean regist(@RequestParam("comment") String comment) {
		Gson gson = new Gson();
		Comment comment2 = gson.fromJson(comment, Comment.class);
		this.commentServiceImpl.addComment(comment2);	
		return true;
	}
	
	@RequestMapping("/read")
	@ResponseBody
	public String read(@RequestParam("dId") Integer dId) {
		List<Comment> list = this.commentServiceImpl.read(dId);
		Gson gson = new Gson();
		return gson.toJson(list);
	}
}
