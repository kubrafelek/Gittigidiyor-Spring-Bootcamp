package com.kubrafelek.devpatika.entity;

import lombok.*;

import java.util.List;

@Data
@RequiredArgsConstructor
public class VisitingResearcher extends Instructor {

    private double hourlySalary;

    public VisitingResearcher(String name, String address, String phoneNumber, double hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }
}
