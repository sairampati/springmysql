package com.example.springmysql.controller;

import com.example.springmysql.repository.EmployeeRepo;
import com.example.springmysql.entity.Employee;
import com.example.springmysql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/add")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @PostMapping("/addEmployees")
    public List<Employee> saveEmployees(@RequestBody List<Employee> employees){
        return employeeService.saveEmployees(employees);
    }

    @GetMapping("/getAll")
    public List<Employee> getEmpolyee(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmpoyeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("employeeByname/{firstname}")
    public Employee getEmployeeByFirstName(@PathVariable String firstname){
        return employeeService.getEmployeeByfFirstName(firstname);
    }

    @PutMapping("/update")
    public Employee updateEmpolyee(@RequestBody Employee employee){
        return employeeService.updateEmployeeById(employee);
    }

    @DeleteMapping("delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);
    }

}
