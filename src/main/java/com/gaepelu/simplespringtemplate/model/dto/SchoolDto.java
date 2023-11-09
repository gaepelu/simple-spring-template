package com.gaepelu.simplespringtemplate.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SchoolDto {

    @NotEmpty(message = "400#name must be not empty")
    private String name;

    @NotEmpty(message = "400#description must be not empty")
    private String description;

}
