package com.gp.learn.awardservice.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.gp.learn.awardservice.valueobject.PriceEffectiveDate;


@Entity
public class Award {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank(message ="award id is mandatory.")
	private String awardId;

	private LocalDateTime awardDate;
	
	private Long volume;
	
	@Embedded
	@AttributeOverride(name = "effectiveDate", column = @Column(name = "original_price_effective_date"))
	private PriceEffectiveDate original;


	@Embedded
	@AttributeOverride(name = "effectiveDate", column = @Column(name = "actual_price_effective_date"))
	private PriceEffectiveDate actual;
	
	
	@OneToOne(mappedBy="award", cascade = CascadeType.ALL)
	private AwardItem item;

	@OneToMany(mappedBy="award" , cascade = CascadeType.ALL)
	private List<Note> notes = new ArrayList<Note>();
	
	public Award() {
	}

	public Award(Long id, String awardId, LocalDateTime awardDate, Long volume,
			LocalDateTime originalPriceEffectiveDate, LocalDateTime actualPriceEffectiveDate, AwardItem item) {
		this.id = id;
		this.awardId = awardId;
		this.awardDate = awardDate;
		this.volume = volume;
		this.setOriginal(originalPriceEffectiveDate);
		this.setActual(actualPriceEffectiveDate);
		this.setItem(item);
	}

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

	public AwardItem getItem() {
		return item;
	}

	public void setItem(AwardItem item) {
		this.item = item;
		this.item.setAward(this);
	}
	
	public List<Note> getNotes() {
		return notes;
	}

	public void addNote(Note note) {
		this.notes.add(note);
		note.setAward(this);
	}
	
	
	public PriceEffectiveDate getOriginal() {
		return original;
	}

	public void setOriginal(LocalDateTime originalPriceEffectiveDate) {
		this.original = new PriceEffectiveDate(originalPriceEffectiveDate);
	}

	public PriceEffectiveDate getActual() {
		return actual;
	}

	public void setActual(LocalDateTime actualPriceEffectiveDate) {
		this.actual = new PriceEffectiveDate(actualPriceEffectiveDate);
	}

	public Award modifyPriceEffectiveDate(LocalDateTime newDate) {
				
		this.actual = new PriceEffectiveDate(newDate);
		return this;
	}

	@Override
	public String toString() {
		return "Award [id=" + id + ", awardId=" + awardId + ", awardDate=" + awardDate + ", volume=" + volume
				+ ", original=" + original + ", actual=" + actual + ", item=" + item + ", notes=" + notes + "]";
	}

	
	
}
