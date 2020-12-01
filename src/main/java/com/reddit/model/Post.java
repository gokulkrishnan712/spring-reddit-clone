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
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	private String postName;
	private String url;
	private String description;
	private Integer voteCount;
	@ManyToOne
	@JoinColumn(name="userId",referencedColumnName="userId")
	private User user;
	private Instant createdDate;
	@ManyToOne
	@JoinColumn(name="id",referencedColumnName="id")
	private SubReddit subReddit; 

}
