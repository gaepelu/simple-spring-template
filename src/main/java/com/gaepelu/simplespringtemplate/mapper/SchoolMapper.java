package com.gaepelu.simplespringtemplate.mapper;

import com.gaepelu.simplespringtemplate.model.School;
import com.gaepelu.simplespringtemplate.model.dto.SchoolDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SchoolMapper {

    School toEntity(SchoolDto schoolDto);
}
