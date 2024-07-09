package com.marondal.marondalgram.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marondal.marondalgram.user.domain.User;
import com.marondal.marondalgram.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@RequestMapping("/user")
@RestController
@Validated
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/join")
	public Map<String, String> join(
			@Size(min=4, max=8) @RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, @RequestParam("name") String name
			, @Email @RequestParam("email") String email) {
				
		int count = userService.addUser(loginId, password, name, email);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("reslut", "fail");
		}
		
		return resultMap;
	}
	
	// id 중복확인 API
	@GetMapping("/duplicate-id")
	public Map<String, Boolean> idDuplicateId(@RequestParam("loginId") String loginId) {
		
		boolean isDuplicate = userService.isDuplicateId(loginId);
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		resultMap.put("isDuplicate", isDuplicate);
		
		return resultMap;
		
	}
	
	// 로그인 API
	@PostMapping("/login")
	public Map<String, String> login(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, HttpServletRequest request) {
		
		User user = userService.getUser(loginId, password);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(user != null) {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			
			resultMap.put("result", "success");
		} else {
			// 로그인 실패 
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
		
	}

}
