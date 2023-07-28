package com.EmployeeTask.Service;

import com.EmployeeTask.Entity.EmployeeDetails;
import com.EmployeeTask.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeDetails> saveEmployeeDetails(List<EmployeeDetails> employeeDetails) {
        return employeeRepository.saveAll(employeeDetails);
    }


    public Map<String, Object> getTaxDeduction(int employeeId) {
        Map<String, Object> taxDeduction = new HashMap<>();
        EmployeeDetails employeeDetails = employeeRepository.findById(String.valueOf(employeeId)).orElse(null);
        if (employeeDetails != null) {

            int yearlySalary = (int) (employeeDetails.getSalary() * 12);

            double tax;
            double cess;
            if (yearlySalary <= 250000) {
                tax = 0.0;
                System.out.println(tax);
            } else if (yearlySalary <= 500000) {
                tax = (yearlySalary - 250000) * 0.05;
                System.out.println(tax);
            } else if (yearlySalary <= 1000000) {
                tax = (12500 + (yearlySalary - 500000) * 0.1);
                System.out.println(tax);
            } else {
                tax = 12500 + 50000 + (yearlySalary - 1000000) * 0.2;
                System.out.println(tax);
            }

            if (yearlySalary > 2500000) {
                cess = (yearlySalary) * 0.02;
            } else {
                cess = 0;
            }
            taxDeduction.put("employeeId", employeeId);
            taxDeduction.put("firstName", employeeDetails.getFirstName());
            taxDeduction.put("lastName", employeeDetails.getLastName());
            taxDeduction.put("Cess", cess);
            taxDeduction.put("yearly Salary", yearlySalary);
            taxDeduction.put("taxDeduction", tax);
            return taxDeduction;
        }

        return taxDeduction;
    }
}



