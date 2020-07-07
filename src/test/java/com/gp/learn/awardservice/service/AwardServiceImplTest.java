package com.gp.learn.awardservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gp.learn.awardservice.entity.Award;
import com.gp.learn.awardservice.entity.AwardItem;
import com.gp.learn.awardservice.repository.AwardRepository;

@DisplayName("Testing Award Service")
//@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class AwardServiceImplTest {

	@Mock
	AwardRepository awardRepository;
	
	@InjectMocks
	AwardServiceImpl awardServiceImpl;
	
	Award award;
	AwardItem item;
	
	@BeforeEach
	public void init() {
		//AwardItem(Long id, Long economst)
		item = new AwardItem(1001L,500197L);
		award = new Award(101L,"award101",LocalDateTime.now(),1001L,
									LocalDateTime.now(),LocalDateTime.now(),item);
	}
	
	@Nested
	@DisplayName("Add Award Tests")
	class AddAwardTests{
		@Test
		@DisplayName("award should be added successfully.")
		public void addAward_basictest() {
			
			when(awardRepository.save(award)).thenReturn(award);
			
			Award createdAward = awardServiceImpl.addAward(award);
			
			assertEquals(101L, createdAward.getId());
			
		}
	}
	
	@Nested
	@DisplayName("Price Effective Date Tests")
	class PriceEffectiveDateTests{
		@Test
		@DisplayName("Date should be modified successfully.")
		public void modifyPriceEffectiveDate_basicTest() {
			LocalDateTime newPriceEffectiveDate = LocalDateTime.now().plusDays(4);
			when(awardRepository.save(award)).thenReturn(award);
			Award modifiedAward  = awardServiceImpl.modifyPriceEffectiveDate(award, newPriceEffectiveDate);
			
			assertEquals(101L, modifiedAward.getId());
			assertEquals(LocalDateTime.now().plusDays(4).toLocalDate(),
					modifiedAward.getActual().getEffectiveDate().toLocalDate());
			
		}
		
		@Test
		@DisplayName("Past Date must not be allowed and throw exeception")
		public void modifyPriceEffectiveDate_pastDateTest() {

			assertThrows(IllegalArgumentException.class, 
					()->awardServiceImpl.modifyPriceEffectiveDate(award, LocalDateTime.now().minusDays(4)));
		}
		
		@Test
		@DisplayName("Past Date must not be null and throw exeception")
		public void modifyPriceEffectiveDate_nullDateTest() {

			assertThrows(IllegalArgumentException.class, 
					()->awardServiceImpl.modifyPriceEffectiveDate(award, null));
		}
	}
	
}
