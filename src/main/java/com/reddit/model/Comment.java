package com.reddit.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String text;
	@ManyToOne
	@JoinColumn(name="postId",referencedColumnName="postId")
	private Post post;
	private Instant createdDate;
	@ManyToOne
	@JoinColumn(name="userId",referencedColumnName="userId")
	private User user;
	

}
