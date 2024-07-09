package com.marondal.marondalgram.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marondal.marondalgram.comment.domain.Comment;

import jakarta.transaction.Transactional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	// WHERE `postId` = #{} ORDER BY `id` DESC
	public List<Comment> findByPostIdOrderByIdDesc(int postId);
	
	// DELETE FROM `comment` WHERE `postId` = #{}
	@Transactional
	public void deleteByPostId(int postId);
	

}
