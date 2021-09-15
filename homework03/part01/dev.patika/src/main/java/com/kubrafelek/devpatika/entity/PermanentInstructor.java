package com.kubrafelek.devpatika.entity;

import lombok.*;

@Data
@RequiredArgsConstructor
public class PermanentInstructor extends Instructor{

    private double fixedSalary;

    public PermanentInstructor(String name, String address, String phoneNumber, double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }
}
