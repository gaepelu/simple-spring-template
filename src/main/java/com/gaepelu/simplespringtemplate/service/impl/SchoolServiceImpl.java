package com.gaepelu.simplespringtemplate.service.impl;

import com.gaepelu.simplespringtemplate.exception.NotFoundException;
import com.gaepelu.simplespringtemplate.model.School;
import com.gaepelu.simplespringtemplate.repository.SchoolRepository;
import com.gaepelu.simplespringtemplate.service.SchoolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class SchoolServiceImpl implements SchoolService {

    private static Supplier<NotFoundException> schoolNotFound(Long id) {
        return () -> new NotFoundException("school not found with id=" + id);
    }


    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    @Override
    public School findById(Long id) {
        return schoolRepository.findById(id).orElseThrow(schoolNotFound(id));
    }
}
