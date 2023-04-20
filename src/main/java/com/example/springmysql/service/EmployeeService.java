package com.example.springmysql.service;

import com.example.springmysql.entity.Employee;
import com.example.springmysql.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;


    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

    public List<Employee> saveEmployees(@RequestBody List<Employee> employees){
        return employeeRepo.saveAll(employees);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepo.findById(id).orElse(null);
    }

    public Employee getEmployeeByfFirstName(String firstname){
        return employeeRepo.findByfirstname(firstname);
    }

    public Employee updateEmployeeById(Employee employee){
        Employee existingEmployee=employeeRepo.findById(employee.getId()).orElse(null);
        existingEmployee.setFirstname(employee.getFirstname());
        return employeeRepo.save(existingEmployee);
    }
    public String deleteEmployeeById(Long id){
      employeeRepo.deleteById(id);
      //System.out.println("employee removed for id:"+ id);
      return "employee removed for id"+id;
    }


}
