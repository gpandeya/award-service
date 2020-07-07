package com.gp.learn.awardservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Note {

	@Id
	@GeneratedValue
	private Long id;
	private String note;
	
	@ManyToOne
	@JsonIgnore
	private Award award;

	public Note() {
		
	}
	public Note(Long id, String note) {
		super();
		this.id = id;
		this.note = note;
	}

	public Note(Long id, String note, Award award) {
		super();
		this.id = id;
		this.note = note;
		this.award = award;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Award getAward() {
		return award;
	}
	public void setAward(Award award) {
		this.award = award;
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", note=" + note + "]";
	}
	
	
	
	
}
