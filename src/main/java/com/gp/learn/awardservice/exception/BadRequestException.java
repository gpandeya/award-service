package com.gp.learn.awardservice.exception;

public class BadRequestException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String category;
	private String deatils;
	
	public BadRequestException(String category, String deatils) {
		super();
		this.category = category;
		this.deatils = deatils;
	}

	
	
	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getDeatils() {
		return deatils;
	}



	public void setDeatils(String deatils) {
		this.deatils = deatils;
	}



	@Override
	public String toString() {
		return "BadRequestException [category=" + category + ", deatils=" + deatils + "]";
	}

	
	
}
