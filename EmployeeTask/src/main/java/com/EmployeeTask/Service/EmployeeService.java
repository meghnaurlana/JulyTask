package com.EmployeeTask.Service;

import com.EmployeeTask.Entity.EmployeeDetails;
import com.EmployeeTask.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeDetails> saveEmployeeDetails(List<EmployeeDetails> employeeDetails) {
        return employeeRepository.saveAll(employeeDetails);
    }


}
