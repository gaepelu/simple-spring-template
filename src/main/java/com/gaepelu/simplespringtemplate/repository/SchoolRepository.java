package com.gaepelu.simplespringtemplate.repository;

import com.gaepelu.simplespringtemplate.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Long> {
}
