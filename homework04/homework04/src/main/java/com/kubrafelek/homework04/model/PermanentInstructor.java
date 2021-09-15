package com.kubrafelek.homework04.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PermanentInstructor extends Instructor{

    private double fixedSalary;

}
