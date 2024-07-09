package com.marondal.marondalgram.like.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.marondalgram.like.domain.Like;
import com.marondal.marondalgram.like.repository.LikeRepository;

@Service
public class LikeService {
	
	@Autowired
	private LikeRepository likeRepository;
	
	public Like addLike(int postId, int userId) {
		
		Like like = Like.builder()
						.postId(postId)
						.userId(userId)
						.build();
		
		return likeRepository.save(like);
	}
	
	public int getLikeCount(int postId) {
		return likeRepository.countByPostId(postId);
	}
	
	// 특정 사용자가 특정 게시물에 좋아요를 했는지 여부 
	public boolean isLike(int userId, int postId) {
		int count = likeRepository.countByUserIdAndPostId(userId, postId);
		
//		if(count >= 1) {
//			return true;
//		} else {
//			return false;
//		}
		
		return count >= 1;
	}
	
	public Like deleteLike(int postId, int userId) {
	
		Optional<Like> optionalLike = likeRepository.findByPostIdAndUserId(postId, userId);
		Like like = optionalLike.orElse(null);
		
		if(like != null) {
			likeRepository.delete(like);
		}
		
		return like;
	} 
	
	
	public void deleteLikeByPostId(int postId) {
		
		likeRepository.deleteByPostId(postId);
	}
	

}
