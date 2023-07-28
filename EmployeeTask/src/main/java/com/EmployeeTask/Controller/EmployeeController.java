package com.EmployeeTask.Controller;

import com.EmployeeTask.Entity.EmployeeDetails;
import com.EmployeeTask.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employeeDetails")
    public List<EmployeeDetails> addUsers(@RequestBody List<EmployeeDetails> employeeDetails) {
        return employeeService.saveEmployeeDetails(employeeDetails);
    }

    @GetMapping("employeeTax/{employeeId}")
    public Map<String, Object> getTaxDeduction(@PathVariable int employeeId){
        return employeeService.getTaxDeduction(employeeId);
    }


}
