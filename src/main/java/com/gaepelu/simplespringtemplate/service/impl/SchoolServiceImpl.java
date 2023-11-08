package com.gaepelu.simplespringtemplate.service.impl;

import com.gaepelu.simplespringtemplate.model.School;
import com.gaepelu.simplespringtemplate.repository.SchoolRepository;
import com.gaepelu.simplespringtemplate.service.SchoolService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public List<School> findAll() {
        return schoolRepository.findAll();
    }
}
