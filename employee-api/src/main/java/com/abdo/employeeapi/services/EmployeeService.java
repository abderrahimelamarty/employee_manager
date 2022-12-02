package com.abdo.employeeapi.services;

import com.abdo.employeeapi.models.Employee;
import com.abdo.employeeapi.repo.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class EmployeeService {
    @Autowired
     EmployeeRepo emprepo;
public Employee addEmployee(Employee emp){
    emp.setEmployeeCode(UUID.randomUUID().toString());
    return emprepo.save(emp);
}
public List<Employee> findAllEmployees(){
    return emprepo.findAll();
}
public Employee updateEmployee(Employee emp){
    return emprepo.save(emp);
}
public void deleteEmployee(Long id){
    emprepo.deleteEmployeeById(id);
}
public Employee findEmployee(Long id){
    System.out.println(id);
    return emprepo.findEmployeeById(id);
}

}
