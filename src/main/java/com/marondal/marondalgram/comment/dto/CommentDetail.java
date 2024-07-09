package com.marondal.marondalgram.comment.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommentDetail {
	
	private int commentId;
	private int userId;
	private int postId;
	// 댓글 내용, 작성자 id
	private String userLoginId;
	private String contents;

}
