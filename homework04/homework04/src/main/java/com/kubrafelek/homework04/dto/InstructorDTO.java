package com.kubrafelek.homework04.dto;

import com.kubrafelek.homework04.model.AbstractBaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDTO extends AbstractBaseEntity {

    @ApiModelProperty(hidden = true)
    private long id;

    @ApiModelProperty(example = "Ayşe")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @ApiModelProperty(example = "Şile")
    @NotBlank(message = "Address is mandatory")
    private String address;

    @ApiModelProperty(example = "05098976655")
    @NotBlank(message = "Phone Number is mandatory")
    private String phoneNumber;
}
