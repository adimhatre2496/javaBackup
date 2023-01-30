package com.example.employee.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeEnitity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String name;
    private String dob;
    private String email;
    private Double salary;
}
