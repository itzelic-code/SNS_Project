package com.marondal.marondalgram.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.marondal.marondalgram.user.domain.User;

@Mapper
public interface UserRepository {
	
	public int insertUser(
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("name") String name
			, @Param("email") String email);
	
	 // 전달받은 loginId 와 일치하는 행의 개수를 조회 하는 기능
	 public int selectCountByLoginId(@Param("loginId") String loginId);

	 public User selectUser(
			 @Param("loginId") String loginId
			 , @Param("password") String password);
	 
	 public User selectUserById(@Param("id") int id);
}
