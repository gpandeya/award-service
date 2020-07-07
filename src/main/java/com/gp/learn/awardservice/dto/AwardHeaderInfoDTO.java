package com.gp.learn.awardservice.dto;

import java.time.LocalDateTime;

public class AwardHeaderInfoDTO {

	private Long id;
	private String awardId;
	private LocalDateTime awardDate;
	private Long volume;
	private LocalDateTime originalPriceEffectiveDate;
	private LocalDateTime actualPriceEffectiveDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAwardId() {
		return awardId;
	}
	public void setAwardId(String awardId) {
		this.awardId = awardId;
	}
	public LocalDateTime getAwardDate() {
		return awardDate;
	}
	public void setAwardDate(LocalDateTime awardDate) {
		this.awardDate = awardDate;
	}
	public Long getVolume() {
		return volume;
	}
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	public LocalDateTime getOriginalPriceEffectiveDate() {
		return originalPriceEffectiveDate;
	}
	public void setOriginalPriceEffectiveDate(LocalDateTime originalPriceEffectiveDate) {
		this.originalPriceEffectiveDate = originalPriceEffectiveDate;
	}
	public LocalDateTime getActualPriceEffectiveDate() {
		return actualPriceEffectiveDate;
	}
	public void setActualPriceEffectiveDate(LocalDateTime actualPriceEffectiveDate) {
		this.actualPriceEffectiveDate = actualPriceEffectiveDate;
	}
	
	@Override
	public String toString() {
		return "AwardHeaderInfoDTO [id=" + id + ", awardId=" + awardId + ", awardDate=" + awardDate + ", volume="
				+ volume + ", originalPriceEffectiveDate=" + originalPriceEffectiveDate + ", actualPriceEffectiveDate="
				+ actualPriceEffectiveDate + "]";
	}
	
	
}
