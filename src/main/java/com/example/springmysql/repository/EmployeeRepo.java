package com.example.springmysql.repository;

import com.example.springmysql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
//    List<Employee> getAllEmployees();
}
