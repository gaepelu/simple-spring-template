package com.gaepelu.simplespringtemplate.service.impl;

import com.gaepelu.simplespringtemplate.exception.NotFoundException;
import com.gaepelu.simplespringtemplate.mapper.SchoolMapper;
import com.gaepelu.simplespringtemplate.model.School;
import com.gaepelu.simplespringtemplate.model.dto.SchoolDto;
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

    private final SchoolMapper schoolMapper;

    public SchoolServiceImpl(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    @Override
    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    @Override
    public School findById(Long id) {
        return schoolRepository.findById(id).orElseThrow(schoolNotFound(id));
    }

    @Override
    public School createSchool(SchoolDto schoolDto) {
        School school = schoolMapper.toEntity(schoolDto);
        return schoolRepository.save(school);
    }

    @Override
    public School updateSchool(Long id, SchoolDto schoolDto) {
        School school = findById(id);
        school.setName(schoolDto.getName());
        school.setDescription(schoolDto.getDescription());
        return schoolRepository.save(school);
    }
}
