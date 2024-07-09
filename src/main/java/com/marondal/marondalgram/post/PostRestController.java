package com.marondal.marondalgram.post;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.marondal.marondalgram.post.domain.Post;
import com.marondal.marondalgram.post.service.PostService;

import jakarta.servlet.http.HttpSession;


@RequestMapping("/post")
@RestController
public class PostRestController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/create")
	public Map<String, String> createPost(
			@RequestParam("contents") String contents
			, @RequestParam("imageFile") MultipartFile imageFile
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		Post post = postService.addPost(userId, contents, imageFile);
		
		Map<String, String> resultMap = new HashMap<>();
		if(post != null) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	@DeleteMapping("/delete")
	public Map<String, String> deletePost(
			@RequestParam("id") int id) {
		
		Post post = postService.deletePost(id);
		
		Map<String, String> resultMap = new HashMap<>();
		if(post != null) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

}
