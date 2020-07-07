package com.gp.learn.awardservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AwardItem {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long economst;
	
	@OneToOne
	@JsonIgnore
	private Award award;

	public AwardItem(Long id, Long economst) {
		super();
		this.id = id;
		this.economst = economst;
	}
	public AwardItem(Long id, Long economst, Award award) {
		super();
		this.id = id;
		this.economst = economst;
		this.award = award;
	}
	
	public AwardItem() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEconomst() {
		return economst;
	}

	public void setEconomst(Long economst) {
		this.economst = economst;
	}

	public Award getAward() {
		return award;
	}

	public void setAward(Award award) {
		this.award = award;
	}

	@Override
	public String toString() {
		return "AwardItem [id=" + id + ", economst=" + economst + "]";
	}
	

}
