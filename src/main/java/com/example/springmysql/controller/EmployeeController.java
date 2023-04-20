package com.example.springmysql.controller;

import com.example.springmysql.repository.EmployeeRepo;
import com.example.springmysql.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    private final EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @PostMapping("/add")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

    @GetMapping("/get")
    public List<Employee> getEmpolyee(){

        return employeeRepo.findAll();
    }
}
