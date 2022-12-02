package com.abdo.employeeapi.repo;

import com.abdo.employeeapi.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo  extends JpaRepository<Employee,Long> {
    void deleteEmployeeById(Long id);

    Employee findEmployeeById(Long id);
}
