package com.gp.learn.awardservice.service;

import java.time.LocalDateTime;

import com.gp.learn.awardservice.entity.Award;

public interface AwardService {
	
	public Award addAward(Award incomingAward);
	public Award findAward(Long id);
	public Award modifyPriceEffectiveDate(Award award, LocalDateTime newPriceEffectiveDate);
}
