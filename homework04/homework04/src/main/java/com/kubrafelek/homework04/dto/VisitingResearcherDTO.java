package com.kubrafelek.homework04.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class VisitingResearcherDTO extends InstructorDTO{

    @ApiModelProperty(example = "100.0")
    @NotNull(message = "Hourly Salary is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private double hourlySalary;
}
