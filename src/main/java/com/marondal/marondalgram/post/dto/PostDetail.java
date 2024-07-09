package com.marondal.marondalgram.post.dto;

import java.util.List;

import com.marondal.marondalgram.comment.dto.CommentDetail;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostDetail {
	// 카드 화면을 구성하기 위해 필요한 데이터
	private int postId;
	private int userId;
	private int likeCount;
	private boolean isLike;
	private String userLoginId;
	private String contents;
	private String imagePath;
	private List<CommentDetail> commentList;

}
