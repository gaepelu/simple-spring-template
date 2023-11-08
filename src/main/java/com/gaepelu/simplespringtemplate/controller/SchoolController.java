package com.gaepelu.simplespringtemplate.controller;

import com.gaepelu.simplespringtemplate.model.School;
import com.gaepelu.simplespringtemplate.service.SchoolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/schools")
    public List<School> schools() {
        return schoolService.findAll();
    }

    @GetMapping("/schools/{id}")
    public School school(@PathVariable("id") Long id) {
        return schoolService.findById(id);
    }
}