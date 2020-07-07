package com.gp.learn.awardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.learn.awardservice.entity.Award;

public interface AwardRepository extends JpaRepository<Award, Long>{

}
