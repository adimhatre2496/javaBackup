package com.example.manytomany.service;

import com.example.manytomany.entity.EmployeeEntity;
import com.example.manytomany.mapper.EmployeeMapper;
import com.example.manytomany.model.Employee;
import com.example.manytomany.model.EmployeeResponse;
import com.example.manytomany.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponse createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = null;
        employeeEntity = employeeMapper.modelToEntity(employee);
        employeeRepository.save(employeeEntity);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employeeEntity.getId());
        return employeeResponse;
    }

    public Employee getEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(id);
        Employee employee= new Employee();
        if (employeeEntity.isPresent()){
            EmployeeEntity employeeEntity1=employeeEntity.get();
            employee=employeeMapper.entityToModel(employeeEntity1);
           log.info(" employee-department found with id {}",id);
        }
        else {
            log.info("employee-department not found with id {}",id);
        }
        return employee;
    }
}
