package com.gaepelu.simplespringtemplate.controller;

import com.gaepelu.simplespringtemplate.model.School;
import com.gaepelu.simplespringtemplate.service.SchoolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/school")
    public List<School> schools() {
        return schoolService.findAll();
    }
}
