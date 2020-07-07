package com.gp.learn.awardservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Testing Award")
class AwardTest {

	Award award;
	
	@BeforeEach
	void initalize() {
		award = new Award();
		award.setAwardId("101");
		award.setAwardDate(LocalDateTime.now());
		award.setOriginal(LocalDateTime.now());
		award.setActual(LocalDateTime.now());
	}
	
	@Nested
	@DisplayName("Price Effective Date related testing")
	class PriceEffectiveDateTest{
		@Test
		@DisplayName("price effective date should be changed")
		void modifyPriceEffectiveDate_basicTest() {
			
			Award modifiedAward = award.modifyPriceEffectiveDate(LocalDateTime.now().plusDays(3));
			
			assertEquals("101", modifiedAward.getAwardId());
			assertTrue(modifiedAward.getActual().
						isAfter(modifiedAward.getOriginal()));
		}

		@Test
		@DisplayName("Exception thrown if new price effective date is null")
		void modifyPriceEffectiveDate_nullTest() {
		
			assertThrows(IllegalArgumentException.class, ()->award.modifyPriceEffectiveDate(null));
		}
		
		@Test
		@DisplayName("Exception thrown if new price effective date is in past")
		void modifyPriceEffectiveDate_pastDateTest() {
			
			assertThrows(IllegalArgumentException.class, ()->award.modifyPriceEffectiveDate(LocalDateTime.now().minusDays(2)));
		}
	}
	
}
