package com.gp.learn.awardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.learn.awardservice.entity.AwardItem;

public interface AwardItemRepository extends JpaRepository<AwardItem, Long> {

}
