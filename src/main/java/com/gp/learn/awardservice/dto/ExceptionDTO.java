package com.gp.learn.awardservice.dto;

import java.time.LocalDateTime;

public class ExceptionDTO {
	
	private String category;
	private String deatils;
	private String source;
	private LocalDateTime createdAt;
	
	public ExceptionDTO() {
		
	}
	
	public ExceptionDTO(String category, String deatils,String source) {
	
		this.category = category;
		this.deatils = deatils;
		this.source = source;
		this.createdAt = LocalDateTime.now();
	}
	
	public String getCategory() {
		return category;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "AwardNotFoundExceptionDTO [category=" + category + ", deatils=" + deatils + ", source=" + source
				+ ", createdAt=" + createdAt + "]";
	}

}
