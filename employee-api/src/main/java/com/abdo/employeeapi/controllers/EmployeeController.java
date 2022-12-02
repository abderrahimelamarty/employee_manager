package com.abdo.employeeapi.controllers;

import com.abdo.employeeapi.models.Employee;
import com.abdo.employeeapi.services.EmployeeService;
import jakarta.persistence.Column;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    EmployeeService empervice;
    @GetMapping("/Employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees=empervice.findAllEmployees();
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/Employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id){
        Employee employee=empervice.findEmployee(id);
        return  new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
        Employee employee=empervice.addEmployee(emp);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id")  Long id){
        boolean deleted=false;
        empervice.deleteEmployee(id);
        Employee emp= empervice.findEmployee(id);
        if(emp==null){
            deleted=true;
            return new ResponseEntity<>(deleted,HttpStatus.OK);
        }
        return new ResponseEntity<>(deleted,HttpStatus.OK);
    }
 @PutMapping("updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody  Employee emp){
     Employee updateEmployee = empervice.updateEmployee(emp);
     return new ResponseEntity<>(updateEmployee, HttpStatus.OK);

 }

}
