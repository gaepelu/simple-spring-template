package com.gaepelu.simplespringtemplate.service;

import com.gaepelu.simplespringtemplate.model.School;

import java.util.List;

public interface SchoolService {

    List<School> findAll();

    School findById(Long id);
}
