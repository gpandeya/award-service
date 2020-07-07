package com.gp.learn.awardservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gp.learn.awardservice.dto.AwardDTO;
import com.gp.learn.awardservice.entity.Award;
import com.gp.learn.awardservice.entity.AwardItem;
import com.gp.learn.awardservice.mapper.AwardMapper;
import com.gp.learn.awardservice.service.AwardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/awards")
@Api(value="End Point for Award")
public class AwardController {
	
	@Autowired
	AwardService awardServiceImpl;
	@Autowired
	AwardMapper mapper;
	Logger logger = LoggerFactory.getLogger(AwardController.class);

	@ApiOperation(value = "sanity check endpoint for awards APIs",
				notes="to be added later", 
				response=String.class)
	@GetMapping("/check")
	public String checkMe(){
		return "Hello from Award Controller";
	}
	
	@ApiOperation(value="end point to create new award",
				notes="System performs validation only on price effective date at this time. "
						+ "Validations for other attributes will be added later.",
				response=ResponseEntity.class,httpMethod = "POST",code=201)
	@PostMapping("/")
	public ResponseEntity<AwardDTO> addAward(@ApiParam(value="single award that need to be created.",required=true)
		@RequestBody AwardDTO awardDTO) {
		logger.info("Request Payload {} ",awardDTO);
		
		AwardItem item = new AwardItem();
		item.setEconomst(awardDTO.getItemDTO().getEconomst());

		Award incomingAward = mapper.toEntity(awardDTO);
		logger.info("After conversion {} ",incomingAward);
		
		Award savedAward = awardServiceImpl.addAward(incomingAward);
		
		ResponseEntity<AwardDTO> response = ResponseEntity.status(HttpStatus.CREATED)
														.body(mapper.toDto(savedAward));
		
		return response;
		
	}

	@ApiOperation(value="parses the input ID of the award and returns the matching award.",
					notes="Please note it is NOT the award ID sent by C1.",
					response=AwardDTO.class)
	@GetMapping("/{id}")
	public AwardDTO getAward(@ApiParam(value="ID based award lookup."
			+ " Note that it is not the id sent by C1.")@PathVariable String id) {
		logger.info("Request received for id : {} ", id);
		Award award = awardServiceImpl.findAward(Long.parseLong(id));
		AwardDTO awardDTO = mapper.toDto(award);
		return awardDTO;
		
	}
}
