package com.gp.learn.awardservice.exception;

public class BadAwardException extends RuntimeException{

	private String message;
	
	public BadAwardException() {
		
	}
	public BadAwardException(String message) {
		this.message = message;
	}
	
}
