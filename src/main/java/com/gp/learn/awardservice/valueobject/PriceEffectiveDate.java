package com.gp.learn.awardservice.valueobject;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

@Embeddable
public class PriceEffectiveDate {
	
	private LocalDateTime effectiveDate;

	public PriceEffectiveDate() {
		
	}
	public PriceEffectiveDate(LocalDateTime effectiveDate) {
	
		this.setEffectiveDate(effectiveDate);
	}


	public LocalDateTime getEffectiveDate() {
		return effectiveDate;
	}

	private void setEffectiveDate(LocalDateTime effectiveDate) {
		
		if(effectiveDate==null  || effectiveDate.toLocalDate().isBefore(LocalDateTime.now().toLocalDate()))
			throw new IllegalArgumentException("New Price Effective Date cannot be null or in the past");

		this.effectiveDate = effectiveDate;
	}
	
	public boolean isAfter(PriceEffectiveDate in) {
		if(this.effectiveDate.isAfter(in.effectiveDate))
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "PriceEffectiveDate [effectiveDate=" + effectiveDate + "]";
	}
	
	

}
