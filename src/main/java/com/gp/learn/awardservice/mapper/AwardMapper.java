package com.gp.learn.awardservice.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gp.learn.awardservice.dto.AwardDTO;
import com.gp.learn.awardservice.entity.Award;

@Mapper(componentModel="spring")
public interface AwardMapper{

	@Mapping(source="notes", target="noteDTOs")
	@Mapping(source="item",target="itemDTO")
	@Mapping(source="actual.effectiveDate", target="actualPriceEffectiveDate")
	@Mapping(source="original.effectiveDate", target="originalPriceEffectiveDate")
	AwardDTO toDto(Award award);

	@Mapping(source="noteDTOs", target="notes")
	@Mapping(source="itemDTO",target="item")
	@Mapping(source="actualPriceEffectiveDate", target="actual")
	@Mapping(source="originalPriceEffectiveDate", target="original")
	Award toEntity(AwardDTO awardDTO);
}
