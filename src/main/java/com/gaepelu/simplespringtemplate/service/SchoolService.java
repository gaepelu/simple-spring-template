package com.gaepelu.simplespringtemplate.service;

import com.gaepelu.simplespringtemplate.model.School;
import com.gaepelu.simplespringtemplate.model.dto.SchoolDto;

import java.util.List;

public interface SchoolService {

    List<School> findAll();

    School findById(Long id);

    School createSchool(SchoolDto schoolDto);

    School updateSchool(Long id, SchoolDto schoolDto);
}
