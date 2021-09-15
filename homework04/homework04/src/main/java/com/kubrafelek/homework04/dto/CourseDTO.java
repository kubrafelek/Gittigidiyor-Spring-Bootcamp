package com.kubrafelek.homework04.dto;

import com.kubrafelek.homework04.model.AbstractBaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO extends AbstractBaseEntity {

    @ApiModelProperty(hidden = true)
    private long id;

    @ApiModelProperty(example = "Introduction To Java")
    @NotBlank(message = "Course Name is mandatory")
    private String courseName;

    @ApiModelProperty(example = "111")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @NotNull(message = "Course Code is mandatory")
    private int courseCode;

    @ApiModelProperty(example = "4")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @NotNull(message = "Credit Score is mandatory")
    private int creditScore;
}
