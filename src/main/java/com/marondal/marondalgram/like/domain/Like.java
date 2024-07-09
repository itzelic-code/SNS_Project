package com.marondal.marondalgram.like.domain;

import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="`like`")
@Entity
public class Like {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="postId")
	private int postId;
	@Column(name="userId")
	private int userId;
	
	@UpdateTimestamp
	@Column(name="createdAt")
	private Date createdAt;
}
