package com.gp.learn.awardservice.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.learn.awardservice.entity.Award;
import com.gp.learn.awardservice.repository.AwardRepository;

@Service
public class AwardServiceImpl implements AwardService{

	@Autowired
	private AwardRepository repository;
	
	@Override
	public Award addAward(Award incomingAward) throws IllegalArgumentException{
		incomingAward.getNotes().forEach(note -> note.setAward(incomingAward));
		return repository.save(incomingAward);
		
	}

	@Override
	public Award modifyPriceEffectiveDate(Award award, LocalDateTime newPriceEffectiveDate) {
		Award modifiedAward = award.modifyPriceEffectiveDate(newPriceEffectiveDate);
		
		return repository.save(modifiedAward);
		
	}

	@Override
	public Award findAward(Long id) {
		return repository.findById(id).orElse(null);
	}

	

}
