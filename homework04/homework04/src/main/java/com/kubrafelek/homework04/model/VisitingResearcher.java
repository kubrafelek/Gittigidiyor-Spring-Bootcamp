package com.kubrafelek.homework04.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VisitingResearcher extends Instructor {
    private double hourlySalary;
}
