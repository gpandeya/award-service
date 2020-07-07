package com.gp.learn.awardservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.gp.learn.awardservice.dto.AwardDTO;
import com.gp.learn.awardservice.entity.Award;
import com.gp.learn.awardservice.mapper.AwardMapper;
import com.gp.learn.awardservice.service.AwardService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AwardController.class)
@DisplayName("awad controller test")
class AwardControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AwardService awardServiceImpl;
	
	@MockBean
	private AwardMapper mapper;
	
	Award award;
	AwardDTO awardDTO;
	
	@BeforeEach
	public void init() {
		award = new Award();
		award.setId(101L);
		award.setAwardId("award123");
		award.setOriginal(LocalDateTime.now());
		award.setActual(LocalDateTime.now());
		
		awardDTO = new AwardDTO();
		awardDTO.setId(101L);
		awardDTO.setAwardId("award123");
		awardDTO.setOriginalPriceEffectiveDate(LocalDateTime.now());
		awardDTO.setActualPriceEffectiveDate(LocalDateTime.now());
		
	}

	@Test
	@DisplayName("sanity check url basic test")
	public void checkMe_basicTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
									.get("/awards/check")
									.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(request)
							.andExpect(status().isOk())
							.andReturn();
		
		assertEquals("Hello from Award Controller", result.getResponse().getContentAsString());
	}
	
	@Nested
	@DisplayName("Get Award End Point Test")
	class GetAwardTest{
		
		@Test
		@DisplayName("system should find the award and return successfully.")
		public void getAward_basicTest() throws Exception {
	
			when(awardServiceImpl.findAward(101L)).thenReturn(award);
			when (mapper.toDto(award)).thenReturn(awardDTO);
			
			RequestBuilder request = MockMvcRequestBuilders.get("/awards/101")
					.accept(MediaType.APPLICATION_JSON);
			
			mockMvc.perform(request).andExpect(status().isOk());
			
		}
		@Test
		@DisplayName("System does not find matching end point and returns 404")
		public void getAward_404DueToBadURLTest() throws Exception {
			when(awardServiceImpl.findAward(101L)).thenReturn(award);
			when (mapper.toDto(award)).thenReturn(awardDTO);
			RequestBuilder request = MockMvcRequestBuilders.get("/102")
					.accept(MediaType.APPLICATION_JSON);
			
			mockMvc.perform(request).andExpect(status().isNotFound()).andReturn();
			
		}
	}
	

}
