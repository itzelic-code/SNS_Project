package com.marondal.marondalgram.like.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.marondal.marondalgram.like.domain.Like;

@SpringBootTest
class LikeServiceTest {

	@Autowired
	private LikeService likeService;	
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void likeUnlikeTest() {
		
		// 테스트 설계
		// addLike 호출결과 리턴된 값이 null 이 아니다. 
		// 방금 저장된 정보를 deleteLike로 호출한 결과 리턴된 값이 null 이 아니다. 
		
		Like like = likeService.addLike(5, 10);
		logger.info("좋아요 추가 : " + like.getId() + " " + like.getPostId());
		
		
		like = likeService.deleteLike(5, 10);
		logger.info("좋아요 삭제 : " + like.getId() + " " + like.getPostId());
		
	}

}
