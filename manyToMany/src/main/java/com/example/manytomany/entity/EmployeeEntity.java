package com.example.manytomany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "employee")
public class  EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_department",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id"))
      private Set<DepartmentEntity> department;
}
