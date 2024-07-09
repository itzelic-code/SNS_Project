package com.marondal.marondalgram.comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marondal.marondalgram.comment.domain.Comment;
import com.marondal.marondalgram.comment.service.CommentService;

import jakarta.servlet.http.HttpSession;

@RestController
public class CommentRestConroller {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/post/comment/create")
	public Map<String, String> createCommnet(
			@RequestParam("postId") int postId
			, @RequestParam("contents") String contents
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		Comment comment = commentService.addComment(userId, postId, contents);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(comment != null) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}

}
