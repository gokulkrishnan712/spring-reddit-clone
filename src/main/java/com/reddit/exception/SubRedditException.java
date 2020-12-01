package com.reddit.exception;

public class SubRedditException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SubRedditException(String message) {
		super(message);
	}
}
