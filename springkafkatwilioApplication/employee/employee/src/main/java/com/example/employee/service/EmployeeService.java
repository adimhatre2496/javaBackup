package com.example.employee.service;


import com.example.employee.entity.EmployeeEnitity;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.model.EmployeeRequest;
import com.example.employee.model.EmployeeResponse;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        EmployeeEnitity employeeEnitity = employeeMapper.modelToEnitity(employeeRequest);
        employeeRepository.save(employeeEnitity);

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmployeeId(employeeEnitity.getEmployeeId());
        return employeeResponse;
    }
}
