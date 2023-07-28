package com.EmployeeTask.Repository;

import com.EmployeeTask.Entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <EmployeeDetails, String>{
}
