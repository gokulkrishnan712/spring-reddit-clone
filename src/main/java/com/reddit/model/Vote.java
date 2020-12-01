package com.reddit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.reddit.enumeration.VoteType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long voteId;
	private VoteType voteType;
	@ManyToOne
	@JoinColumn(name="postId",referencedColumnName="postId")
	private Post post;
	@ManyToOne
	@JoinColumn(name="userId",referencedColumnName="userId")
	private User user;
	
}
