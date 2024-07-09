package com.marondal.marondalgram.like.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marondal.marondalgram.like.domain.Like;

import jakarta.transaction.Transactional;

public interface LikeRepository extends JpaRepository<Like, Integer> {
	
//		SELECT count(*) FROM `like` WHERE `postId` = 4;
	public int countByPostId(int postId);
	
//	SELECT count(*) FROM `like` WHERE `postId` = 2 AND `userId` = 3;
	public int countByUserIdAndPostId(int userId, int postId);
	
	// WHERE `postId` = #{} AND `userId` = #{}
	public Optional<Like> findByPostIdAndUserId(int postId, int userId);
	
	// transaction 으로 실행
	// SELECT * FROM `like` WHERE `postId` = ${} 
	// DELETE FROM `like` WHERE `postId` = #{}
	@Transactional
	public void deleteByPostId(int postId);

}
