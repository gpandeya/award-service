package com.gp.learn.awardservice.exception;

public class AwardNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String category;
	private String deatils;
	
	public AwardNotFoundException(String category, String deatils) {
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
		return "AwardNotFoundException [category=" + category + ", deatils=" + deatils + "]";
	}

	
	
}
