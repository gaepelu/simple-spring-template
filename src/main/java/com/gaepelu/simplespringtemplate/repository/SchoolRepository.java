package com.gaepelu.simplespringtemplate.repository;

import com.gaepelu.simplespringtemplate.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {

    List<School> findByName(String name);

    @Query("""
            select s
            from School s
            where s.description = :description
            """)
    List<School> findByDescription(@Param("description") String description);
}
