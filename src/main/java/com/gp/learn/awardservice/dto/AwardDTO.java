package com.gp.learn.awardservice.dto;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="DTO representation for Award entity."
	+ " It is deeply populdated DTO that has notes and item populated.")
public class AwardDTO {
	private Long id;
	private String awardId;
	private LocalDateTime awardDate;
	private Long volume;
	
	@ApiModelProperty(notes="Original Price Effective Date",required=true,allowEmptyValue = false)
	private LocalDateTime originalPriceEffectiveDate;
	
	@ApiModelProperty(notes="Actual Price Effective Date",required=true,allowEmptyValue = false)
	private LocalDateTime actualPriceEffectiveDate;
	
	private AwardItemDTO itemDTO;
	
	@ApiModelProperty(notes="notes that are linked to award .", required=false,allowEmptyValue = true)
	private List<NoteDTO> noteDTOs;
	
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
	public AwardItemDTO getItemDTO() {
		return itemDTO;
	}
	public void setItemDTO(AwardItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}
	public List<NoteDTO> getNoteDTOs() {
		return noteDTOs;
	}
	public void setNoteDTOs(List<NoteDTO> noteDTOs) {
		this.noteDTOs = noteDTOs;
	}
	
	@Override
	public String toString() {
		return "AwardDTO [id=" + id + ", awardId=" + awardId + ", awardDate=" + awardDate + ", volume=" + volume
				+ ", originalPriceEffectiveDate=" + originalPriceEffectiveDate + ", actualPriceEffectiveDate="
				+ actualPriceEffectiveDate + ", itemDTO=" + itemDTO + ", noteDTOs=" + noteDTOs + "]";
	}
	
	
}
