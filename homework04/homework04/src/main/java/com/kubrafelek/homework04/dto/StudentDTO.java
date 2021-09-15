package com.kubrafelek.homework04.dto;

import com.kubrafelek.homework04.model.AbstractBaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO extends AbstractBaseEntity {

    @ApiModelProperty(hidden = true)
    private long id;

    @ApiModelProperty(example = "Kübra")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @ApiModelProperty(example = "1997-01-01")
    @NotBlank(message = "Birthdate is mandatory")
    private LocalDate birthdate;

    @ApiModelProperty(example = "İstanbul")
    @NotBlank(message = "Address is mandatory")
    private String address;

    @ApiModelProperty(example = "Female or Male")
    @NotBlank(message = "Gender is mandatory")
    private String gender;
}
